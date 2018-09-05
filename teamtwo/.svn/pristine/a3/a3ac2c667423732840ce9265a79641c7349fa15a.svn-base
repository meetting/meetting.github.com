package com.teamtwo.service;

import java.util.Date;
import java.util.List;
import java.util.Map;

public interface BookingService {

	public List<Map<String,Object>> queryBookingInfo();
	
	public Map<String,Object> queryChargeInfo(Integer startpointid,Integer endpointid);
	
	public void addBookingInfo(Integer customid,String startaddr,Date sendtime,String sendname,String sendphone,
			String endaddr,String recvname,String recvphone,Integer startpointid,Integer endpointid,double weight,
			double volume,double cost,String statev,String describeo);
	
	public Map<String,Object> modifyBookingInfo(Integer orderid);
	
	public void updateBookingInfo(Integer orderid,Integer customid,String startaddr,Date sendtime,String sendname,String sendphone,
			String endaddr,String recvname,String recvphone,Integer startpointid,Integer endpointid,double weight,
			double volume,double cost,String statev,String describeo);
}
