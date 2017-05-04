package com.iyunr.pro.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.iyunr.pro.dao.AppointmentDao;
import com.iyunr.pro.dao.BookDao;
import com.iyunr.pro.dto.AppointExectionDto;
import com.iyunr.pro.entity.Appointment;
import com.iyunr.pro.entity.Book;
import com.iyunr.pro.enums.AppointStateEnum;
import com.iyunr.pro.exception.AppointException;
import com.iyunr.pro.exception.NoNumberException;
import com.iyunr.pro.exception.RepeatAppointException;
import com.iyunr.pro.service.BookService;

@Service
public class BookServiceImpl implements BookService{
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private BookDao bookDao;
	
	@Autowired
	private AppointmentDao appointmentDao;

	@Override
	public Book queryById(Long id) {
		return bookDao.queryById(id);
	}

	@Override
	public List<Book> queryAllBooks(int offset, int limit) {
		return bookDao.queryAllBooks(offset, limit);
	}
	

	/**
	 * 查询所有图书-(使用pageHelper分页插件版本)
	 */
	@Override
	public List<Book> queryAllBooksByPageHelper() {
		return bookDao.queryAllBooksByPageHelper();
	}

	@Override
	@Transactional
	public AppointExectionDto appintBook(Long bookId, Long studentId) {
		try {
			//减库存(这里如果使用bookDao直接调用的话，如果出错事务是不会回滚的，事务具有传播性)
			int uptNum = bookDao.reduceBookNumber(bookId);
			if(uptNum <= 0){//库存不足
				throw new NoNumberException("no book!!");
			}else{
				//执行预约操作
				int insertAppoint = appointmentDao.insertAppointment(bookId, studentId);
				if(insertAppoint <= 0){//重复预约
					throw new RepeatAppointException("repeat appoint!!");
				}else{
					Appointment appointment = appointmentDao.queryAppointmentByBookIdAndStudentId(bookId, studentId);
					return new AppointExectionDto(bookId, AppointStateEnum.SUCCESS, appointment);
				}
			}
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
//			e.printStackTrace();
			//所有编译期异常转换为运行期异常
			throw new AppointException("appoint inner error:"+e.getMessage());
		}
	}

	@Override
	@Transactional
	public int reduceBookNumber(Long bookId) {
		int num = bookDao.reduceBookNumber(bookId);
		num = num / 0;//测试事务是否生效
		return num;
	}
	

}
