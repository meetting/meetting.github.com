package com.teamtwo.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.teamtwo.mapper.BookingDao;
import com.teamtwo.service.BookingService;

@Service
public class BookingServiceImpl implements BookingService {

	@Autowired
	private BookingDao bookingDao;
	
	@Override
	public List<Map<String,Object>> queryBookingInfo(){
		return bookingDao.queryBookingInfo();
	}
	
	@Override
	public Map<String,Object> queryChargeInfo(Integer startpointid,Integer endpointid){
		return bookingDao.queryChargeInfo(startpointid,endpointid);
	}
	
	@Override
	public void addBookingInfo(Integer customid,String startaddr,Date sendtime,String sendname,String sendphone,
			String endaddr,String recvname,String recvphone,Integer startpointid,Integer endpointid,double weight,
			double volume,double cost,String statev,String describeo){
		    bookingDao.addBookingInfo(customid,startaddr,sendtime,sendname,sendphone,endaddr,recvname,recvphone,
				startpointid,endpointid,weight,volume,cost,statev,describeo);
	}
	
	@Override
	public Map<String,Object> modifyBookingInfo(Integer orderid){
		return bookingDao.modifyBookingInfo(orderid);
	}
	
	@Override
	public void updateBookingInfo(Integer orderid,Integer customid,String startaddr,Date sendtime,String sendname,String sendphone,
			String endaddr,String recvname,String recvphone,Integer startpointid,Integer endpointid,double weight,
			double volume,double cost,String statev,String describeo){
		    bookingDao.updateBookingInfo(orderid,customid,startaddr,sendtime,sendname,sendphone,endaddr,recvname,recvphone,
				startpointid,endpointid,weight,volume,cost,statev,describeo);
	}
}
