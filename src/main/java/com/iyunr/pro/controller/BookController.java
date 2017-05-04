package com.iyunr.pro.controller;

import java.util.List;
import java.util.UUID;



//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.iyunr.pro.dto.AppointExectionDto;
import com.iyunr.pro.dto.ResultDto;
import com.iyunr.pro.entity.Book;
import com.iyunr.pro.enums.AppointStateEnum;
import com.iyunr.pro.exception.NoNumberException;
import com.iyunr.pro.exception.RepeatAppointException;
import com.iyunr.pro.service.BookService;

@Controller
@RequestMapping("/book")
public class BookController{
//	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private BookService bookService;
	
	/**
	 * 查询所有图书-(该请求走beetl的视图解析器)
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/list", method=RequestMethod.GET)
	public String queryAllBooks(Model model){
		List<Book> books = bookService.queryAllBooks(0, 100);
		model.addAttribute("data", books);
		return "/views/list";
	}
	
	/**
	 * 查询所有图书-(该请求走jsp的视图解析器)
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/list2", method=RequestMethod.GET)
	public String queryAllBooks2(Model model){
		List<Book> books = bookService.queryAllBooks(0, 100);
		model.addAttribute("data", books);
		return "list";
	}
	
	/**
	 * 查询所有图书-(使用pageHelper分页插件版本)
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/list1", method=RequestMethod.GET)
	public String queryAllBooksByPageHelper(Model model){
		Page<Book> pageBook = PageHelper.startPage(0, 3);
		bookService.queryAllBooksByPageHelper();
		model.addAttribute("data", pageBook);
		return "/views/list";
	}
	
	@RequestMapping(value="/{bookId}/detail", method=RequestMethod.GET)
	public String queryById(@PathVariable("bookId") Long bookId, Model model){
		if(bookId == null){
			return "redirect:list";
		}
		Book book = bookService.queryById(bookId);
		if(book == null){
			return "forward:list";
		}
		model.addAttribute("book", book);
		return "detail";
	}
	
	@RequestMapping(value="/{bookId}/appoint", method=RequestMethod.POST, produces = {
	"application/json; charset=utf-8" })
	public ResultDto<AppointExectionDto> appoint(Long bookId, Long studentId){
		if (studentId == null || studentId.equals("")) {
			return new ResultDto<>("400", null, "学号不能为空");
		}
		AppointExectionDto execution = null;
		try {
			execution = bookService.appintBook(bookId, studentId);
		} catch (NoNumberException e1) {
			execution = new AppointExectionDto(bookId, AppointStateEnum.NO_NUMBER);
		} catch (RepeatAppointException e2) {
			execution = new AppointExectionDto(bookId, AppointStateEnum.REPEAT_APPOINT);
		} catch (Exception e) {
			execution = new AppointExectionDto(bookId, AppointStateEnum.INNER_ERROR);
		}
		return new ResultDto<AppointExectionDto>("200", execution, "执行结果正常");
	}
	
	/**
	 * fastjson的简单使用
	 */
//	public static void main(String[] args) {
//		Book book = new Book();
//		book.setId(1l);
//		book.setName("Jerry");
//		book.setNumber(5);
//		String str0 = JSON.toJSONString(book);
//		System.out.println(str0);
//		book = JSON.parseObject(str0, Book.class);
//		System.out.println(book);
//		System.out.println("---------------------------------------------------------------------");
//		
//		String str = "{\"name\":{\"name\":\"ljw\",\"id\":18, \"number\":10}}";
//		Map<String, Book> bookMap = JSON.parseObject(str, new TypeReference<Map<String, Book>>(){});
//		System.out.println(bookMap);
//		System.out.println(JSON.toJSONString(bookMap));
//		System.out.println("---------------------------------------------------------------------");
//		
//		String str1 = "[{\"name\":\"ljw\",\"id\":18, \"number\":10}, {\"name\":\"ljw1\",\"id\":19, \"number\":11}]";
//		List<Book> bookList = JSON.parseArray(str1, Book.class);
//		System.out.println(bookList);
//	}
	
	
	/**
	 * 对两个有序数组进行合并排序
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(UUID.randomUUID().toString().replaceAll("-", ""));
		int[] a = new int[]{1, 3, 5, 12, 24, 30, 37, 50};
		int[] b = new int[]{2, 4, 6, 13, 15, 40, 45, 60, 65, 66, 70};
		
		System.out.println("a.len:"+a.length+"\rb.len"+b.length);
		
		int[] c = new int[a.length + b.length];
		
		int i=0, j=0, k=0;//abc的游标
		
		while(i<a.length && j<b.length){
			if(a[i] < b[j]){
				c[k++] = a[i++];
			}else{
				c[k++] = b[j++];
			}
		}
		
		while(i < a.length){
			c[k++] = a[i++];
		}
		while(j < b.length){
			c[k++] = b[j++];
		}
		
//		if(i == a.length){
//			for(int m=k;m<c.length;m++){
//				c[m] = b[j++];
//			}
//		}else{
//			for(int m=k;m<c.length;m++){
//				c[m] = a[i++];
//			}
//		}
		
		for(int istr : c){
			System.out.print(istr+",");
		}
	}
	
}
