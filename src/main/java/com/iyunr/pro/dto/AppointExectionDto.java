package com.iyunr.pro.dto;

import com.iyunr.pro.entity.Appointment;
import com.iyunr.pro.enums.AppointStateEnum;

/**
 * 存储执行预约操作的返回结果
 * dto相当于vo，主要用于service层于web层之间的传输，因为entity可能并不能满足我们的业务需求，
 * 可能返回给用户的数据很多，我们可以将entity数据也封装进来
 * @author Boyce Lee
 *
 */
public class AppointExectionDto {
	//图书id
	private long bookId;
	//秒杀预约结果状态码
	private int state;
	//状态标识信息
	private String stateInfo;
	//预约成功对象
	private Appointment appointment;
	
	/**
	 * 预约失败的构造器
	 * @param bookId	图书id
	 * @param state		状态码
	 * @param stateInfo	状态信息
	 */
	public AppointExectionDto(long bookId, AppointStateEnum ase) {
		this.bookId = bookId;
		this.state = ase.getState();
		this.stateInfo = ase.getStateInfo();
	}
	
	/**
	 * 预约成功的构造器
	 * @param bookId	图书id
	 * @param state		状态码
	 * @param stateInfo	状态信息
	 * @param appointment	预约成功对象
	 */
	public AppointExectionDto(long bookId, AppointStateEnum ase, Appointment appointment) {
		this.bookId = bookId;
		this.state = ase.getState();
		this.stateInfo = ase.getStateInfo();
		this.appointment = appointment;
	}
	
	public long getBookId() {
		return bookId;
	}
	public void setBookId(long bookId) {
		this.bookId = bookId;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	public String getStateInfo() {
		return stateInfo;
	}
	public void setStateInfo(String stateInfo) {
		this.stateInfo = stateInfo;
	}
	public Appointment getAppointment() {
		return appointment;
	}
	public void setAppointment(Appointment appointment) {
		this.appointment = appointment;
	}

	@Override
	public String toString() {
		return "AppointExectionDto [bookId=" + bookId + ", state=" + state
				+ ", stateInfo=" + stateInfo + ", appointment=" + appointment
				+ "]";
	}
	
	
}
