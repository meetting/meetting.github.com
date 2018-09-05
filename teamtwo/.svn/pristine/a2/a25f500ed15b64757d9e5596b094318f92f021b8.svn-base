package com.teamtwo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.teamtwo.mapper.OcMapper;
import com.teamtwo.pojo.Point;
import com.teamtwo.service.OcService;

@Service
public class OcServiceImpl implements OcService {
	
	@Autowired
	private OcMapper ocMapper;
	
	public List<Point> getCitys(){
		
		return ocMapper.getCitys();
	}

}
