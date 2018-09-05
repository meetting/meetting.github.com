package com.teamtwo.service.impl;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.teamtwo.mapper.PointSeekRangeMapper;
import com.teamtwo.service.PointSeekRangeService;

@Service
public class PointSeekRangeServiceImpl implements PointSeekRangeService {

	@Autowired
	private PointSeekRangeMapper pointSeekRangeMapper;
	
	//通过pointid查找配送范围
	@Override
	public List<HashMap<String, Object>> sbpointid(int pointid) {
		
		return pointSeekRangeMapper.sbpointid(pointid);
	}

	
}
