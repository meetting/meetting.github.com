package com.teamtwo.service;

import java.util.List;
import java.util.Map;

public interface CheckOrderService {

	public List<Map<String,Object>> queryCheckOrderInfo();
	
	public void modifyCheckOrderInfoToPass(Integer orderid);
	
	public void modifyCheckOrderInfoToNopass(Integer orderid);
}
