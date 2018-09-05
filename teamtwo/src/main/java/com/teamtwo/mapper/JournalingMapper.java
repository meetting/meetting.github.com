package com.teamtwo.mapper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface JournalingMapper {

	
	//按年份统计信息
	List<HashMap<String, Object>> selectByYear(String startYear);
	
	//按月份统计信息
	List<HashMap<String, Object>> selectByMonth(String startMonth);
	
	//按季度统计信息
	List<HashMap<String, Object>> selectByQuarter(@Param("startt") String startt,@Param("endt") String endt);

}
	
