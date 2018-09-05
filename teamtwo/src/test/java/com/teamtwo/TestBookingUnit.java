package com.teamtwo;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.teamtwo.mapper.BookingDao;
import com.teamtwo.service.BookingService;
import com.teamtwo.service.JoinService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:spring-root.xml")
public class TestBookingUnit {

	@Autowired
	private JoinService joinservice;
	@Autowired
	private BookingService bookingservice;
	
	@Autowired
	private BookingDao bookingdao;
	
	
	/*@Test
	public void test1(){
	    
		List<Map<String,Object>> startpointnames=joinservice.getStartPointName();
	}*/
	
	/*@Test
	public void test2(){
	    
	Map<String,Object> resultset=bookingservice.queryChargeInfo(2, 7);
	}*/
	
	@Test
	public void test3(){
	
		Date t=new Date();
		bookingservice.addBookingInfo(1, "重庆永川", t, "杨洋", "2525325", "河南洛阳", "江小白", "5525", 3, 4, 34.2, 34.3, 34.3, "", "");
		/*bookingdao.addBookingInfo(1, "重庆永川", t, "杨洋","2525325", "河南洛阳", "江小白");*/
	}
}
