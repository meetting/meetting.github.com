package com.teamtwo.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.teamtwo.pojo.Automobile;
import com.teamtwo.service.AutoMobileService;

/**
 * 车辆信息管理
 * @author stars_admin
 *
 */
@Controller
public class AutoMobileController {

	@Autowired
	private AutoMobileService automobileService;
	
	/**
	 * 响应增加车辆页面
	 * @param automobile
	 * @return String
	 */
	@RequestMapping(value="/transportcapacity_add_vehicle",method=RequestMethod.GET)
	public String addMobile(){
		return "transport_capacity/transportcapacity_add_vehicle";
	}
	
	/**
	 * 增加车辆
	 * @param automobile
	 * @return String
	 */
	@RequestMapping(value="/transportcapacity_add_vehicle",method=RequestMethod.POST)
	public String addMobile(Automobile automobile){
		automobileService.addAutomobile(automobile);
		return "redirect:queryvehicle";
	}
	
	/**
	 * 查询车辆信息
	 * @param session
	 * @return String
	 */
	@RequestMapping(value="/queryvehicle")
	public String queryClass(HttpSession session){
		
		List<Automobile> resultset=automobileService.queryAutomobile();
		session.setAttribute("queryMobileresult", resultset);
		return "transport_capacity/transportcapacity_vehicle_list";
		
	}
	
	
	/**
	 * 修改运力信息
	 * @param Class
	 * @return String
	 */
	@RequestMapping(value="/modifytransportcapacity_vehicle",method=RequestMethod.GET)
	public String updateMobile(Integer automobileid,Model model)
	{
		Automobile automobile=automobileService.queryMobileById(automobileid);
		model.addAttribute("automobile",automobile);
		return "transport_capacity/transportcapacity_modify_vehicle";
	}
	
	
	/**
	 * 修改运力信息
	 * @param Class
	 * @return String
	 */
	@RequestMapping(value="/modifytransportcapacity_vehicle",method=RequestMethod.POST)
	public String updateClass(Automobile automobile)
	{
		automobileService.modifyAutomobile(automobile);
		return "redirect:queryvehicle";
	}
}
