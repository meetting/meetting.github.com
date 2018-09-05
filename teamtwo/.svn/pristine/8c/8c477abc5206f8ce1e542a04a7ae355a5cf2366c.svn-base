package com.teamtwo.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.teamtwo.mapper.RoadDao;
import com.teamtwo.pojo.Road;
import com.teamtwo.service.RoadService;
@Service
public class RoadServiceImpl implements RoadService {

	@Autowired
	private RoadDao roaddao;
	
	@Override
	public void addRoad(Road road) {

		roaddao.addRoad(road);
	}
	
	@Override
	public List<Road> queryRoad() {

		return roaddao.getRoad();
	}

	@Override
	public Road queryRoadById(Integer id){
		
	    return roaddao.getRoadById(id);
	}
	
	@Override
	public void modifyRoad(Road road){
	    roaddao.modifyRoad(road);
	}
	
	@Override
	public List<Map<String,Object>> seekRoadById(Integer roadid){
		return roaddao.seekRoadById(roadid);
	}
	
	@Override
	public List<Map<String,Object>> seekRoadByStartPoint(String pointname){
		return roaddao.seekRoadByStartPoint(pointname);
	}
	
	@Override
	public List<Map<String,Object>> seekRoadByEndPoint(String pointname){
		return roaddao.seekRoadByEndPoint(pointname);
	}
	
	@Override
	public List<Map<String,Object>> seekRoadByRoadLength(Float roadlength){
		return roaddao.seekRoadByRoadLength(roadlength);
	}
}
