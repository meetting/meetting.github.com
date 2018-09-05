package com.teamtwo.mapper;

import com.teamtwo.pojo.City;

public interface CityDao {

	/**
	 * 增加城市信息
	 * @param city
	 * @return
	 */
	int insertCity(City city);

	/**
	 * 获取城市id
	 * @param city
	 * @return
	 */
	int selectIdByPcd(City city);
	
	/**
	 * 通过id查城市
	 * @param cityid
	 * @return
	 */
	City selectById(int cityid);

}
