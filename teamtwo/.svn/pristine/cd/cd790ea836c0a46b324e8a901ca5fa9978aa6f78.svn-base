package com.teamtwo.service;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import com.teamtwo.BaseTest;
import com.teamtwo.exceptions.PointOperationException;
import com.teamtwo.pojo.City;
import com.teamtwo.pojo.Point;

public class PointServiceTest extends BaseTest {
	@Autowired
	private PointService pointService;
	
	@Test
	@Ignore
	public void testGetPointList(){
		Point pointCondition = new Point();
		List<Point> pointList = pointService.getPointList(pointCondition,0,2);
		System.out.println(pointList.get(1).getPointname());
	}
	
	@Test
	@Ignore
	public void testModifyPoint() throws PointOperationException{
		Point point = pointService.getByPointId(1);
		point.setPointname("新的");
		boolean bl = pointService.modifyPoint(point);
		assertEquals(true,bl);
	}
	
	@Test
	public void testAddPoint() throws PointOperationException{
		Point point = new Point();
		City city = new City();
		
		city.setCityid(2);
		point.setPointname("重庆");
		point.setPointstamp(1234);
		point.setPointaddr("南岸");
		point.setPointphone("1234567897");
		point.setIcome(100);
		
		boolean bl = pointService.addPoint(point);
		assertEquals(true,bl);
		
		
	}
	
	
	
	

}
