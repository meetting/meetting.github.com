package com.teamtwo.mapper;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface JoinDao {

	//由于对应xml文件中的插入语句没有设置parameterType，所以这里必须使用@Param
	public void insertJoin(@Param("startpointid")Integer startpointid,@Param("endpointid")Integer endpointid,@Param("jointime")Date jointime,@Param("automobileid")Integer automobileid);
	
	/*public List<Join> queryJoin(@Param("startpointaddr")String startpointaddr,@Param("endpointaddr")String endpointaddr);*/
	
	public List<Map<String,Object>> getStartPointName();
	
	public List<Map<String,Object>> getEndPointNames(Integer startpointid);
	
	public List<Map<String,Object>> getJoinInfo();
	
	public List<Map<String,Object>> getClassIds();
	
	public List<Map<String,Object>> getOrderIds();
	
	public void insertBindInfos(@Param("orderid")Integer orderid,@Param("joinid")Integer joinid,@Param("classid")Integer classid);
	
	public List<Integer> getOrderByJoinIds();
	
	public Map<String,Object> getJoinInfoNew(@Param("joinid")Integer joinid);
	
	public void deleteJoinOrderId(@Param("joinid")Integer joinid,@Param("orderid")Integer orderid);
}
