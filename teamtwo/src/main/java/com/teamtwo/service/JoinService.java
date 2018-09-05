package com.teamtwo.service;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.teamtwo.pojo.Join;

public interface JoinService {

	public void insertJoin(Integer startpointid,Integer endpointid,Date jointime,Integer automobileid);
	
   /* public List<Join> queryJoin(String startpointaddr,String endpointaddr);*/
	
	public List<Map<String,Object>> getStartPointName();
	
	public List<Map<String,Object>> getEndPointNames(Integer startpointid);
	
	public List<Map<String,Object>> getJoinInfo();
	
	public List<Map<String,Object>> getClassIds();
	
	public List<Map<String,Object>> getOrderIds();
	
	public void insertBindInfos(Integer joinid,Integer classid,Integer orderid);
	
	public List<Integer> getOrderByJoinIds();
	
	public Map<String,Object> getJoinInfoNew(Integer joinid);
	
	public void deleteJoinOrderId(Integer joinid,Integer orderid);
}
