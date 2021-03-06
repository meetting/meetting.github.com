package com.teamtwo;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.teamtwo.service.ClassService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:spring-root.xml")
public class TestClassUnit {

	@Autowired
	private ClassService classService;
	
	/*@Test
	public void test1(){
	    float f=3.3f;
		com.teamtwo.pojo.Class lclass=new com.teamtwo.pojo.Class();
		lclass.setAutomobileid(4);
		lclass.setClassendtime(new Date());;
		lclass.setDriverid(9);
		lclass.setEndpointid(9);
		lclass.setRoadid(2);
		lclass.setStartpointid(6);
		lclass.setWeight(f);
		
		//lclass.setClassid(3);
		//lclass.setClassremarks(null);
		//lclass.setClassstate(null);
		classService.addClass(lclass);
	}*/
	
//	@Test
//	public void test2(){
//	    List<com.teamtwo.pojo.Class> list=classService.queryClass();
//	    for(int i=0;i<list.size();i++){
//	    	System.out.println(list.get(i).getRoadid());
//	    }
//	}
	
	/*@Test
	public void test3(){
	    float f=76.9f;
	    com.teamtwo.pojo.Class lclass=new com.teamtwo.pojo.Class();
	    lclass.setClassid(3);
		lclass.setAutomobileid(15);
		lclass.setClassendtime(new Date());;
		lclass.setDriverid(9);
		lclass.setEndpointid(2);
		lclass.setRoadid(8);
		lclass.setStartpointid(6);
		lclass.setWeight(f);
		
		//lclass.setClassid(3);
		//lclass.setClassremarks(null);
		//lclass.setClassstate(null);
		classService.updateClass(lclass);
	}*/
	
	@Test
	public void test4(){
	    
		com.teamtwo.pojo.Class lclass=classService.queryClassById(7);
		System.out.println(lclass.getClassendtime());
	}
}
