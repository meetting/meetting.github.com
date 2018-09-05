package com.teamtwo.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.teamtwo.service.JoinService;

/**
 * 交接单信息管理
 * @author stars_admin
 *
 */
@Controller
public class JoinController {

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
	 * 响应生成交接单页面
	 * @param 
	 * @return String
	 */
	@RequestMapping(value="/addjiaojiebiao",method=RequestMethod.GET)
	public String addJoin(Model model){
		List<Map<String,Object>> startpointnames=joinservice.getStartPointName();
		model.addAttribute("startpointnames", startpointnames);
		List<Map<String,Object>> result=joinservice.getJoinInfo();
		model.addAttribute("joinlist", result);
		return "jiaojiebiao/jiaojiebiao_add";
	}
	
	/**
	 * 根据已选择的起始配送点id获取目标配送点名-范围列表
	 * @param startpointid,model
	 * @return List<Map<String,Object>
	 */
	@RequestMapping(value="/getendpointnames",method=RequestMethod.POST,produces = {"application/json;charset=UTF-8;"})
	@ResponseBody
	public List<Map<String,Object>> getEndPointNames(Integer startpointid,Model model){
		List<Map<String,Object>> endpointnames=joinservice.getEndPointNames(startpointid);
		return endpointnames;
	}

	/**
	 * 增加/生成交接单
	 * @param 
	 * @return String
	 */
	@RequestMapping(value="/jiaojiebiao_add",method=RequestMethod.POST)
	public String addJoin(Integer startpointid,Integer endpointid,Date jointime,Integer automobileid){
		joinservice.insertJoin(startpointid,endpointid,jointime,automobileid);
		return "redirect:addjiaojiebiao";
	}
	
	/**
	 * 为绑定交接单而获取班次id列表
	 * @param 
	 * @return String
	 */
	@RequestMapping(value="/getclassids",method=RequestMethod.POST,produces = {"application/json;charset=UTF-8;"})	
	@ResponseBody
	public List<Map<String,Object>> getclassids(){
		List<Map<String,Object>> classids=joinservice.getClassIds();
		return classids;
	}
	
	/**
	 * 为绑定交接单而获取订单id列表
	 * @param 
	 * @return String
	 */
	@RequestMapping(value="/getorderids",method=RequestMethod.POST,produces = {"application/json;charset=UTF-8;"})	
	@ResponseBody
	public List<Map<String,Object>> getorderids(){
		List<Map<String,Object>> orderids=joinservice.getOrderIds();
		return orderids;
	}
	
	/**
	 * 使用交接单号获取交接单信息和绑定信息
	 * @param 
	 * @return 
	 */
	@RequestMapping(value="/getjoininfo",method=RequestMethod.POST,produces = {"application/json;charset=UTF-8;"})	
	@ResponseBody
	public Map<String,Object> getJoinInfoNew(Integer joinid){
		Map<String,Object> joininfo=joinservice.getJoinInfoNew(joinid);
		return joininfo;
	}
	
	/**
	 * 使用joinid删除其绑定的订单id,即找到orderbyjoin中的orderbyjoinid在删除该项，但这里其实有数据可能不唯一的bug
	 * @param 
	 * @return 
	 */
	@RequestMapping(value="/deletejoinorderid",method=RequestMethod.POST,produces = {"application/json;charset=UTF-8;"})	
	@ResponseBody
	public void deleteJoinOrderId(Integer joinid,Integer orderid){
		joinservice.deleteJoinOrderId(joinid, orderid);
		return ;
	}
	
	
	/**
	 * 插入绑定交接单的信息
	 * @param
	 * @return
	 */
	//使用ajax传入数据始终存在问题，目前暂时使用当前方法可用，但后面还需要改，这里不止后端有问题
	@RequestMapping(value="/insertbindinfos",method=RequestMethod.POST)	
	public void insertBindInfos(HttpServletRequest request, HttpServletResponse response){
		String joinid1=request.getParameter("joinid");
		String classid1=request.getParameter("classid");
		String orderid1=request.getParameter("orderid");
		if(joinid1!=null&&classid1!=null&&orderid1!=null){
			Integer joinid=Integer.parseInt(joinid1);
			Integer classid=Integer.parseInt(classid1);
			Integer orderid=Integer.parseInt(orderid1);
			joinservice.insertBindInfos(joinid,classid,orderid);
		}
		return;
	}
	
	
	/**
	 *响应查询交接单页面
	 * @param 
	 * @return 
	 */
	@RequestMapping(value="/findjiaojiebiao",method=RequestMethod.GET)
	public String queryJoin(Model model){
		model.addAttribute("OrderByJoinIds", joinservice.getOrderByJoinIds());
		return "/jiaojiebiao/jiaojiebiao_find";
	}
	
	/**
	 * 查询交接单
	 * @param Class
	 * @return void
	 *//*
	//未能测试通过，测试程序一直运行无结果
	@RequestMapping(value="/findjiaojiebiao")
	public List<Join> queryJoin(String startpointaddr,String endpointaddr){
		return joinservice.queryJoin(startpointaddr,endpointaddr);
	}*/
}
