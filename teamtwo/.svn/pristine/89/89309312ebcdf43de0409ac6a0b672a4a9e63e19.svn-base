package com.teamtwo.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.teamtwo.mapper.CheckOrderDao;
import com.teamtwo.service.CheckOrderService;

@Service
public class CheckOrderServiceImpl implements CheckOrderService {

	@Autowired
	private CheckOrderDao checkorderdao;
	
	@Override
	public List<Map<String, Object>> queryCheckOrderInfo() {
		
		return checkorderdao.queryCheckOrderInfo();
	}
	
	@Override
    public void modifyCheckOrderInfoToPass(Integer orderid){
	    checkorderdao.modifyCheckOrderInfoToPass(orderid);
	}
	
	@Override
	public void modifyCheckOrderInfoToNopass(Integer orderid){
		checkorderdao.modifyCheckOrderInfoToNopass(orderid);
	}

}
