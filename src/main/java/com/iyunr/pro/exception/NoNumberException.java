package com.iyunr.pro.exception;

/**
 * 库存不足异常类（此处多个异常类应该可以使用工厂方法实现）
 * @author Boyce Lee
 *
 */
public class NoNumberException extends RuntimeException{
	private static final long serialVersionUID = 1L;

	public NoNumberException(String message) {
		super(message);
	}
	
	public NoNumberException(String message, Throwable cause) {
		super(message, cause);
	}
}
