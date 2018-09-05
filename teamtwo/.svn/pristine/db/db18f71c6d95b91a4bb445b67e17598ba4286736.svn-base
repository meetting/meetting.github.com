package com.teamtwo.mapper;

import static org.junit.Assert.assertEquals;

import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.teamtwo.BaseTest;
import com.teamtwo.pojo.City;

public class CityDaoTest extends BaseTest {

	@Autowired
	private CityDao cityDao;
	
	@Test
	@Ignore
	public void testInsertCity(){
		City city = new City();
		
		city.setProvice("重庆市");
		city.setCity("重庆市");
		city.setDistrict("南岸区");
		
		int effectedNum = cityDao.insertCity(city);
		assertEquals(1,effectedNum);
	}
	
	@Test
	public void testSelectById(){
		City city = new City();
		city = cityDao.selectById(13);
		System.out.println(city.getCityid()+city.getProvice()+city.getCity()+city.getDistrict());
	}
}
