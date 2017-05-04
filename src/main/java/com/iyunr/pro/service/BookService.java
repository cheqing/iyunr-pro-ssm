package com.iyunr.pro.service;

import java.util.List;

import com.iyunr.pro.dto.AppointExectionDto;
import com.iyunr.pro.entity.Book;

/**
 * 业务接口：站在"使用者"角度设计接口 三个方面：方法定义粒度，参数，返回类型（return 类型/异常）
 * @author Boyce Lee
 *
 */
public interface BookService {
	
	/**
	 * 查询一本图书
	 * @param id
	 * @return
	 */
	Book queryById(Long bookId);
	
	/**
	 * 查询所有图书
	 * @param offset 	起始位置
	 * @param limit		查询条数
	 * @return
	 */
	List<Book> queryAllBooks(int offset, int limit);
	
	/**
	 * 查询所有图书-(使用pageHelper分页插件版本)
	 * @return
	 */
	List<Book> queryAllBooksByPageHelper();
	
	/**
	 * 预约图书
	 * @param bookId		图书id
	 * @param studentId		学生id
	 * @return
	 */
	AppointExectionDto appintBook(Long bookId, Long studentId);
	
	/**
	 * 减少馆藏数量
	 * @param bookId 图书id
	 * @return
	 */
	int reduceBookNumber(Long bookId);
}
