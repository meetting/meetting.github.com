package com.teamtwo;

import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.teamtwo.service.RoadService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:spring-root.xml")
public class TestRoadUnit {

	@Autowired
	private RoadService roadservice;
	
	/*@Test
	public void test1(){
	    float f=65.4f;
	    Road road=new Road();
	    road.setRoadid(2);
	    road.setStartpointid(5);
	    road.setEndpointid(9);
	    road.setRoadlength(f);
		roadservice.addRoad(road);
	}*/
	
	/*@Test
	public void test2(){
	    Assert.notEmpty(roadservice.queryRoad());
	    System.out.println(roadservice.queryRoad().get(0).getEndpointid());
	}*/
	
	@Test
	public void test3(){
	   System.out.println("seekRoadByStartPointName:");
	   List<Map<String,Object>> result=roadservice.seekRoadByStartPoint("北京");
	   for(Map<String,Object> info:result){
		   System.out.println(info.values());
	   }
	}
}
