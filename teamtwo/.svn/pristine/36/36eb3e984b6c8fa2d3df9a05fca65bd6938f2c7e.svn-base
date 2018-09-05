package com.teamtwo.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.teamtwo.service.CheckOrderService;



//ctrl+shift+o自动导入包
//订单审核管理
@Controller
public class CheckOrderController {

	@Autowired
	private CheckOrderService checkorderservice;
	
	/**
	 * 查询订单信息
	 * @param 
	 * @return String
	 */
	@RequestMapping(value="/querycheckorderinfo",method=RequestMethod.GET)
	public String queryCheckOrderInfo(HttpSession session){
		List<Map<String,Object>> resultset=checkorderservice.queryCheckOrderInfo();
		session.setAttribute("queryCheckOrderResult", resultset);
		return "check/check_order";
		
	}
	
	/**
	 * 设置订单审核状态为通过
	 * @param 
	 * @return String
	 */
	@RequestMapping(value="/modifycheckorderinfotopass")
	public String modifyCheckOrderInfoToPass(Integer orderid){
		checkorderservice.modifyCheckOrderInfoToPass(orderid);
		return "redirect:querycheckorderinfo";
		
	}
	
	/**
	 * 设置订单审核状态为通过
	 * @param 
	 * @return String
	 */
	@RequestMapping(value="/modifycheckorderinfotonopass")
	public String modifyCheckOrderInfoToNopass(Integer orderid){
		checkorderservice.modifyCheckOrderInfoToNopass(orderid);
		return "redirect:querycheckorderinfo";
		
	}
}
