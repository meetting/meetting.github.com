package com.teamtwo.controller;

import java.text.DateFormat;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.teamtwo.service.BookingService;
import com.teamtwo.service.JoinService;

//ctrl+shift+o自动导入包
//订单信息管理
@Controller
public class BookingController {

	@Autowired
	private BookingService bookingService;
	
	@Autowired
	private JoinService joinservice;
	
	/**
	 * 解决框架不能将String类型数据自动转换成Date数据类型的问题
	 */
	@InitBinder
	public void initBinder(WebDataBinder binder){
		DateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd");
		dateFormat.setLenient(true);
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat,true));
	}
	
	
	/**
	 * 响应增加订单页面
	 * @param 
	 * @return 
	 */
	@RequestMapping(value="/addbookinginfo",method=RequestMethod.GET)
	public String addBookingInfo(Model model){
		List<Map<String,Object>> startpointnames=joinservice.getStartPointName();
	    model.addAttribute("startpointnames", startpointnames);
		return "booking/add_booking";
	}
	
	/**
	 * 查询订单信息
	 * @param 
	 * @return String
	 */
	@RequestMapping(value="/querybookinginfo",method=RequestMethod.GET)
	public String queryBookingInfo(HttpSession session){
		List<Map<String,Object>> resultset=bookingService.queryBookingInfo();
		session.setAttribute("queryBookingResult", resultset);
		return "booking/find_booking";
		
	}
	
	/**
	 * 根据发货配送点Id和收货配送点Id查寻收费标准信息
	 * @param 
	 * @return String
	 */
	@RequestMapping(value="/querychargeinfo",method=RequestMethod.POST,produces = {"application/json;charset=UTF-8;"})
	@ResponseBody
	public Map<String,Object> querychargeinfo(Integer startpointid,Integer endpointid){
		Map<String,Object> resultset=bookingService.queryChargeInfo(startpointid,endpointid);
		return resultset;
		
	}
	
	/**
	 * 增加订单信息
	 * @param 
	 * @return
	 */
	@RequestMapping(value="/addbookinginfo",method=RequestMethod.POST)
	public String addBookingInfo(HttpServletRequest request,HttpServletRequest response){
		Integer customid=Integer.parseInt(request.getParameter("customid"));
		String startaddr=request.getParameter("startaddr");
		
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		ParsePosition pos = new ParsePosition(0);
	    Date sendtime = formatter.parse(request.getParameter("sendtime"), pos);

		String sendname=request.getParameter("sendname");
		String sendphone=request.getParameter("sendphone");
		String endaddr=request.getParameter("endaddr");
		String recvname=request.getParameter("recvname");
		String recvphone=request.getParameter("recvphone");
		Integer startpointid=Integer.parseInt(request.getParameter("startpointid"));
		Integer endpointid=Integer.parseInt(request.getParameter("endpointid"));
		double weight=0;
		if(request.getParameter("weight")!=null&&request.getParameter("weight")!=""){
			weight=Double.parseDouble(request.getParameter("weight"));
		}
		double volume=0;
		if(request.getParameter("volume")!=null&&request.getParameter("volume")!=""){
			volume=Double.parseDouble(request.getParameter("volume"));
		}
		
		Double cost=Double.parseDouble(request.getParameter("cost"));
		String statev=request.getParameter("statev");
		String describeo=request.getParameter("describeo");
	  /*System.out.println("1:"+startaddr+"2:"+sendtime+"3:"+sendname+"4:"+sendphone+"5:"+endaddr+"6:"+recvname+"7:"+startpointid+"8:"+weight);*/
		bookingService.addBookingInfo(customid,startaddr,sendtime,sendname,sendphone,endaddr,recvname,recvphone,startpointid,endpointid,weight,volume,cost,statev,describeo);
		return "redirect:querybookinginfo";
	}
	
	/**
	 * 修改订单信息
	 * @param 
	 * @return 
	 */
	@RequestMapping(value="/modifybookinginfo",method=RequestMethod.GET)
	public String modifyBookingInfo(Integer orderid,Model model)
	{
		List<Map<String,Object>> startpointnames=joinservice.getStartPointName();
	    model.addAttribute("startpointnames", startpointnames);
	    Map<String,Object> modifybookinginfo=bookingService.modifyBookingInfo(orderid);
		model.addAttribute("modifybookinginfo",modifybookinginfo);
		return "booking/modify_booking";
	}
	
	/**
	 * 修改订单信息
	 * @param 
	 * @return
	 */
	@RequestMapping(value="/modifybookinginfo",method=RequestMethod.POST)
	public String modifyBookingInfo(HttpServletRequest request,HttpServletRequest response){
		Integer orderid=Integer.parseInt(request.getParameter("orderid"));
		Integer customid=Integer.parseInt(request.getParameter("customid"));
		String startaddr=request.getParameter("startaddr");
		
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		ParsePosition pos = new ParsePosition(0);
	    Date sendtime = formatter.parse(request.getParameter("sendtime"), pos);

		String sendname=request.getParameter("sendname");
		String sendphone=request.getParameter("sendphone");
		String endaddr=request.getParameter("endaddr");
		String recvname=request.getParameter("recvname");
		String recvphone=request.getParameter("recvphone");
		Integer startpointid=Integer.parseInt(request.getParameter("startpointid"));
		Integer endpointid=Integer.parseInt(request.getParameter("endpointid"));
		double weight=0;
		if(request.getParameter("weight")!=null&&request.getParameter("weight")!=""){
			weight=Double.parseDouble(request.getParameter("weight"));
		}
		double volume=0;
		if(request.getParameter("volume")!=null&&request.getParameter("volume")!=""){
			volume=Double.parseDouble(request.getParameter("volume"));
		}
		
		Double cost=Double.parseDouble(request.getParameter("cost"));
		String statev=request.getParameter("statev");
		String describeo=request.getParameter("describeo");
	  /*System.out.println("1:"+startaddr+"2:"+sendtime+"3:"+sendname+"4:"+sendphone+"5:"+endaddr+"6:"+recvname+"7:"+startpointid+"8:"+weight);*/
		bookingService.updateBookingInfo(orderid,customid,startaddr,sendtime,sendname,sendphone,endaddr,recvname,recvphone,startpointid,endpointid,weight,volume,cost,statev,describeo);
		return "redirect:querybookinginfo";
	}
	
}
