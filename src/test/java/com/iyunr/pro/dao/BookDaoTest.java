package com.iyunr.pro.dao;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.iyunr.pro.BaseTest;
import com.iyunr.pro.dao.BookDao;
import com.iyunr.pro.entity.Book;

/**
 * 测试BookDao
 * @author Boyce Lee
 *
 */
public class BookDaoTest extends BaseTest{
	@Autowired
	private BookDao bookDao;
	
//	@Autowired
//	private BookService bookService;
	
	@Test
	public void testQueryById(){
		Book book = bookDao.queryById(1001L);
		System.out.println(book);
	}
	
	/**
	 * 查询所有书籍，该查询没有使用pageHelper插件
	 */
	@Test
	public void testQueryAllBooks1(){
		List<Book> book = bookDao.queryAllBooks(0, 3);
		System.out.println(book);
	}
	
	/**
	 * 查询所有书籍，该查询使用pageHelper插件
	 */
	@Test
	public void testQueryAllBooks2(){
		//只对该代码下面第一行查询有效，page即为查询到的数据
		Page<Book> page = PageHelper.startPage(0, 3);
		bookDao.queryAllBooksByPageHelper();
		System.out.println("boo.size:"+page.size());
		System.out.println("page--book:"+page);
		
		//page可以再次封装为PageInfo,PageInfo的属性相对较多
		PageInfo<Book> book = new PageInfo<Book>(page);
		System.out.println("book.getPages:"+book.getPages());
	}
	
//	@Test
//	public void reduceBookNums(){
//		int num = bookService.reduceBookNums(1001);
//		System.out.println(num);
//	}
}
