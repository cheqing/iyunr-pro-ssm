package com.iyunr.pro.entity;

/**
 * 图书实体类
 * @author Boyce Lee
 *
 */
public class Book {
	private long id;
	private String bookName;	//图书名称
	private int bookNumber;		//馆藏数量
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public int getBookNumber() {
		return bookNumber;
	}
	public void setBookNumber(int bookNumber) {
		this.bookNumber = bookNumber;
	}
	@Override
	public String toString() {
		return "Book [id=" + id + ", bookName=" + bookName + ", bookNumber="
				+ bookNumber + "]";
	}
	
	
}
