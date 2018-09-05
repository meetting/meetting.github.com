package com.teamtwo.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.teamtwo.mapper.JoinDao;
import com.teamtwo.pojo.Join;
import com.teamtwo.service.JoinService;

@Service
public class JoinServiceImpl implements JoinService {

	@Autowired
	private JoinDao joindao;
	
	@Override
	public void insertJoin(Integer startpointid,Integer endpointid,Date jointime,Integer automobileid) {
		
		joindao.insertJoin(startpointid,endpointid,jointime,automobileid);
	}
	
	/*@Override
	public List<Join> queryJoin(String startpointaddr,String endpointaddr){
		return joindao.queryJoin(startpointaddr,endpointaddr);
	}*/
	
	@Override
	public List<Map<String,Object>> getStartPointName(){
		return joindao.getStartPointName();
	}

	@Override
	public List<Map<String,Object>> getEndPointNames(Integer startpointid){
		return joindao.getEndPointNames(startpointid);
	}
	
	@Override
	public List<Map<String,Object>> getJoinInfo(){
		return joindao.getJoinInfo();
	}
	
	@Override
	public List<Map<String,Object>> getClassIds(){
		return joindao.getClassIds();
	}
	
	@Override
	public List<Map<String,Object>> getOrderIds(){
		return joindao.getOrderIds();
	}
	
	@Override
	public void insertBindInfos(Integer joinid,Integer classid,Integer orderid){
		joindao.insertBindInfos(orderid,joinid,classid);
	}
	
	@Override
	public List<Integer> getOrderByJoinIds(){
		return joindao.getOrderByJoinIds();
	}
	
	@Override
	public Map<String,Object> getJoinInfoNew(Integer joinid){
		return joindao.getJoinInfoNew(joinid);
	}
	
	@Override
	public void deleteJoinOrderId(Integer joinid,Integer orderid){
		joindao.deleteJoinOrderId(joinid,orderid);
	}
}
