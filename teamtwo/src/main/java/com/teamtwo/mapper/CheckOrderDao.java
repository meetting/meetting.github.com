package com.teamtwo.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface CheckOrderDao {

	public List<Map<String,Object>> queryCheckOrderInfo();
	
	public void modifyCheckOrderInfoToPass(@Param("orderid")Integer orderid);
	
	public void modifyCheckOrderInfoToNopass(@Param("orderid")Integer orderid);
}
