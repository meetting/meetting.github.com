package com.teamtwo.service.impl;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.teamtwo.mapper.JournalingMapper;
import com.teamtwo.service.JournalingService;

@Service
public class JournalingServiceImpl implements JournalingService {

	@Autowired
	private JournalingMapper journalingMapper;
	
	//根据年份查询
	@Override
	public List<HashMap<String, Object>> selectByYear(String startYear) {
		
		return journalingMapper.selectByYear(startYear);
	}
	
	//根据年份查询
	@Override
	public List<HashMap<String, Object>> selectByMonth(String startMonth) {
			
		return journalingMapper.selectByMonth(startMonth);
	}

	//根据季度查询(具体选哪个季度，前台进行传值处理)
	@Override
	public List<HashMap<String, Object>> selectByQuarter(String startt, String endt) {
		
		return journalingMapper.selectByQuarter(startt, endt);
	}


	
	
	
	
}
