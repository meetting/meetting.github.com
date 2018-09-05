package com.teamtwo.service;

import com.teamtwo.pojo.City;

public interface CityService {

	/**
	 * 添加城市
	 * @param city
	 * @return
	 */
	boolean addCity(City city);

	/**
	 * 通过省市区查对应的城市id
	 * @param city
	 * @return
	 */
	int selectByPCD(City city);

	/**
	 * 根据id获取城市信息
	 */
	City getCityById(Integer cityid);

	
}
