package com.iyunr.pro.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.iyunr.pro.entity.Book;

@Repository
public interface BookDao {	
	/**
	 *通过ID查询单本图书
	 * @param bookId
	 * @return
	 */
	Book queryById(Long bookId);
	
	/**
	 * 查询所有图书
	 * @param offset	查询起始位置
	 * @param limit		查询条数
	 * @return
	 */
	List<Book> queryAllBooks(@Param("offset") int offset, @Param("limit") int limit);
	
	/**
	 * 查询所有图书-(使用pageHelper分页插件版本)
	 * @return
	 */
	List<Book> queryAllBooksByPageHelper();
	
	/**
	 * 根据图书id减少馆藏数量
	 * @param bookId
	 * @return 如果影响行数等于>1，表示更新的记录行数
	 */
	int reduceBookNumber(Long bookId);
}
