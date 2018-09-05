package com.teamtwo.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Objects;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.teamtwo.pojo.Point;
import com.teamtwo.pojo.Role;
import com.teamtwo.service.PointSeekRangeService;
import com.teamtwo.service.PointService;

@Controller
public class PointSeekRangeController {
	
	@Autowired
	private PointService pointService;
	@Autowired
	private PointSeekRangeService pointSeekRangeService;
	
	//进入配送范围查看界面
	@RequestMapping(value="/point_seek_range",method=RequestMethod.GET)
	public String psr(Model model)
	{
		List<Point> points = pointService.getPointListNoPage();
		model.addAttribute("points", points);
		return "point/point_seek_range";
	}
	
	
	//根据传入的point查询配送范围
	@RequestMapping(value="/sbpointid",method=RequestMethod.POST,produces = {"application/json;charset=UTF-8;"})
	@ResponseBody
	public List<HashMap<String,Object>> selectbyyear(HttpServletRequest request,HttpServletResponse response)
	{
		//通过时间字符串来查询信息
		int pointid = Integer.parseInt(request.getParameter("pointid"));
		List<HashMap<String,Object>> Results = pointSeekRangeService.sbpointid(pointid);
		if(!Objects.isNull(Results))
		{
			return Results;
		}
		return null;
	}
}
