package com.iyunr.pro.dto;

/**
 * 封装json对象，所有返回结果都使用它
 * @author Boyce Lee
 *
 */
public class ResultDto<T> {
	private String status;	//是否成功的标识
	private T data;			//成功时返回的数据
	private String msg;		//错误信息
	
	
	
	public ResultDto(String status, T data, String msg) {
		super();
		this.status = status;
		this.data = data;
		this.msg = msg;
	}
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public T getData() {
		return data;
	}
	public void setData(T data) {
		this.data = data;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	
	
}
