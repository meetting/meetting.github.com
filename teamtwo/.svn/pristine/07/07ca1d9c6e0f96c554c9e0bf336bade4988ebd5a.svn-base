package com.teamtwo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.teamtwo.exceptions.CityOperationException;
import com.teamtwo.mapper.CityDao;
import com.teamtwo.pojo.City;
import com.teamtwo.service.CityService;

@Service
public class CityServiceImpl implements CityService {

	@Autowired
	private CityDao cityDao;

	@Override
	public boolean addCity(City city) {
		if(city == null){
			return false;
		}
		try{
			int effectedNum = cityDao.insertCity(city);
			if(effectedNum <= 0){
				throw new CityOperationException("添加城市失败");
			}
		}catch(Exception e){
			throw new CityOperationException("addCity error:"+e.getMessage());
		}
		return true;
	}

	@Override
	public int selectByPCD(City city) {
		int cid = 0;
		if(city == null){
			throw new CityOperationException("城市为空");
		}
		try{
			int cityid = cityDao.selectIdByPcd(city);
			return cityid;
		}catch(Exception e){
			return cid;
		}
	}

	@Override
	public City getCityById(Integer cityid) {
		return cityDao.selectById(cityid);
	}
}