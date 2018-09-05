package com.teamtwo;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.teamtwo.mapper.CheckOrderDao;
import com.teamtwo.service.CheckOrderService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:spring-root.xml")
public class TestCheckOrderUnit {

	@Autowired
	private CheckOrderDao checkorderdao;
	
	@Autowired
	private CheckOrderService checkorderservice;
	
	@Test
	public void test3(){
	
		//checkorderservice.modifyCheckOrderInfoToPass(2);
		checkorderdao.modifyCheckOrderInfoToPass(2);
	}
}
