package com.iyunr.pro.entity;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 预约图书表
 * @author Boyce Lee
 *
 */
public class Appointment {
	private long bookId;
	private long studentId;
	private Date appointTime;
	private Book book;
	public long getBookId() {
		return bookId;
	}
	public void setBookId(long bookId) {
		this.bookId = bookId;
	}
	public long getStudentId() {
		return studentId;
	}
	public void setStudentId(long studentId) {
		this.studentId = studentId;
	}
	public Date getAppointTime() {
		return appointTime;
	}
	public void setAppointTime(Date appointTime) {
		this.appointTime = appointTime;
	}
	
	public Book getBook() {
		return book;
	}
	public void setBook(Book book) {
		this.book = book;
	}
	@Override
	public String toString() {
		return "Appointment [bookId=" + bookId + ", studentId=" + studentId
				+ ", appointTime=" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(appointTime) + ", book=" + book
				+ "]";
	}
	
	
	
}
