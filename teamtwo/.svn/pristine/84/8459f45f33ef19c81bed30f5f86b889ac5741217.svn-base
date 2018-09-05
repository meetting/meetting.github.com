package com.teamtwo.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Objects;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.teamtwo.service.JournalingService;
import com.teamtwo.util.ReturnMsg;

@Controller
public class JournalingController {

	@Autowired
	private JournalingService journalingService;
	
	//报表显示
	@RequestMapping(value="/JournalingShow",method=RequestMethod.GET)
	public String Journalingshow()
	{
		return "journaling/journaling_show";
	}
	
	
	//根据月份查询报表
	@RequestMapping(value="/selectbymonth",method=RequestMethod.POST,produces = {"application/json;charset=UTF-8;"})
	@ResponseBody
	public List<HashMap<String,Object>> selectbymonth(HttpServletRequest request,HttpServletResponse response)
	{
		//通过时间字符串来查询信息
		String startMonth = request.getParameter("startMonth");
		List<HashMap<String,Object>> jourResults = journalingService.selectByMonth(startMonth);
		if(!Objects.isNull(jourResults))
		{
			return jourResults;
		}
		return null;
	}
	
	//根据季度查询报表
	@RequestMapping(value="/selectbyquarter",method=RequestMethod.POST,produces = {"application/json;charset=UTF-8;"})
	@ResponseBody
	public List<HashMap<String,Object>> selectbyquarter(HttpServletRequest request,HttpServletResponse response)
	{
		//通过时间字符串来查询信息
		String startt = request.getParameter("startt");
		String endt = request.getParameter("endt");
		
		List<HashMap<String,Object>> jourResults = journalingService.selectByQuarter(startt, endt);
		if(!Objects.isNull(jourResults))
		{
			return jourResults;
		}
		return null;
	}
	
	//根据年份查询报表
	@RequestMapping(value="/selectbyyear",method=RequestMethod.POST,produces = {"application/json;charset=UTF-8;"})
	@ResponseBody
	public List<HashMap<String,Object>> selectbyyear(HttpServletRequest request,HttpServletResponse response)
	{
		//通过时间字符串来查询信息
		String startYear = request.getParameter("startYear");
		List<HashMap<String,Object>> jourResults = journalingService.selectByYear(startYear);
		if(!Objects.isNull(jourResults))
		{
			return jourResults;
		}
		return null;
	}
}
