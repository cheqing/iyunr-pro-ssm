package com.iyunr.pro.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.iyunr.pro.entity.Appointment;

/**
 * 图书预约持久化类（接口参数中必须要添加注解：@Param 否则参数会传不过去）
 * @author Boyce Lee
 *
 */
@Repository
public interface AppointmentDao {
	/**
	 * 插入预约图书记录
	 * @param bookId	图书id
	 * @param studentId	学生id
	 * @return	插入的行数
	 */
	int insertAppointment(@Param("bookId") Long bookId, @Param("studentId") Long studentId);
	
	/**
	 * 通过主键查询预约图书记录，并且携带图书实体
	 * @param bookId
	 * @param studentId
	 * @return
	 */
	Appointment queryAppointmentByBookIdAndStudentId(@Param("bookId") Long bookId, @Param("studentId") Long studentId);
	
}
