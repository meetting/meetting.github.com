package com.teamtwo;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.teamtwo.mapper.AutoMobileDao;
import com.teamtwo.pojo.Automobile;
import com.teamtwo.service.AutoMobileService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:spring-root.xml")
public class TestAutomobileUnit {
	
	@Autowired
	private AutoMobileService automobileservice;
	private AutoMobileDao automobiledao;
	
	/*@Test
	public void test1(){
		
		Automobile automobile=new Automobile();
		automobile.setAutomobileid(3);
		automobile.setCartweight("15��");
		automobile.setCarvolume("100����");
		automobile.setCartate("����");
		automobile.setPointid(4);
		
		automobileservice.addAutomobile(automobile);
	}*/
	
	
	/*@Test
	public void test2(){
		
		Automobile automobile=new Automobile();
		automobile.setAutomobileid(2);
		automobile.setCartweight("16吨");
		automobile.setCarvolume("100立方");
		automobile.setCartate("空闲");
		automobile.setPointid(5);
		
		automobileservice.modifyAutomobile(automobile);
	}*/
	
	/*@Test
	public void test3(){
	
		List<Automobile> resultset=automobileservice.queryAutomobile();
		for(int i=0;i<resultset.size();i++){
			System.out.println(resultset.get(i).getCartweight());
		}
	}*/
	
	@Test
	public void test4(){
	    
		Automobile automobile=automobileservice.queryMobileById(3);
		System.out.println(automobile.getCartate());
	}

}
