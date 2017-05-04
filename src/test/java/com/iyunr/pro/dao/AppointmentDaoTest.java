package com.iyunr.pro.dao;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.iyunr.pro.BaseTest;
import com.iyunr.pro.entity.Appointment;

/**
 * 图书预约测试类
 * @author Boyce Lee
 *
 */
public class AppointmentDaoTest extends BaseTest{
	@Autowired
	private AppointmentDao appointmentDao;
	
	@Test
	public void insertAppointment(){
		int num = appointmentDao.insertAppointment(1003L, 8L);
		System.out.println(num);
	}
	
	@Test
	public void queryAppointmentByBookIdAndStudentId(){
		Appointment app = appointmentDao.queryAppointmentByBookIdAndStudentId(1001L, 10L);
		System.out.println(app);
		System.out.println(app.getBook());
	}
	
}
