package com.iyunr.pro.service;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.iyunr.pro.BaseTest;
import com.iyunr.pro.dto.AppointExectionDto;
import com.iyunr.pro.entity.Book;

/**
 * ����service��ҵ��
 * @author Boyce Lee
 *
 */
public class BookServiceTest extends BaseTest{
	@Autowired
	private BookService bookService;
	
	@Test
	public void queryById(){
		Book book = bookService.queryById(1001L);
		System.out.println(book);
	}
	
	@Test
	public void queryAllBooks(){
		List<Book> books = bookService.queryAllBooks(0, 5);
		System.out.println(books);
	}
	
	/**
	 * 减少库存测试（也主要用于测试事务是否能够回滚）
	 */
	@Test
	public void reduceBookNumber(){
		int num = bookService.reduceBookNumber(1002L);
		System.out.println(num);
	}
	
	@Test
	public void AppointBook(){
		AppointExectionDto exectionDto = bookService.appintBook(1001L, 9L);
		System.out.println(exectionDto);
	}
}
