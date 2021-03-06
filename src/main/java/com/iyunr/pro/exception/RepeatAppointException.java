package com.iyunr.pro.exception;

/**
 * 重复预约异常
 * @author Boyce Lee
 *
 */
public class RepeatAppointException extends RuntimeException{
	private static final long serialVersionUID = 1L;

	public RepeatAppointException(String message) {
		super(message);
	}

	public RepeatAppointException(String message, Throwable cause) {
		super(message, cause);
	}
}
