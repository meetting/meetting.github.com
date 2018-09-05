package com.teamtwo.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.teamtwo.pojo.Road;
import com.teamtwo.service.RoadService;

/**
 * ·路线信息管理
 * @author stars_admin
 *
 */
@Controller
public class RoadController {

	@Autowired
	public RoadService roadservice;
	
	/**
	 * 响应增加路线页面
	 * @param road
	 * @return String
	 */
	@RequestMapping(value="/addtransportcapacityline",method=RequestMethod.GET)
	public String addRoad(){
		return "transport_capacity/transportcapacity_add_line";
	}
	
	/**
	 * 增加路线
	 * @param road
	 * @return String
	 */
	@RequestMapping(value="/addtransportcapacityline",method=RequestMethod.POST)
	public String addRoad(Road road){
	    roadservice.addRoad(road);
		return "redirect:findtransportcapacityline";
	}
	
	/**
	 * 查询路线信息
	 * @param road
	 * @return void
	 */
	@RequestMapping(value="/findtransportcapacityline")
	public String queryRoad(HttpSession session){
		
		List<Road> resultset= roadservice.queryRoad();
		session.setAttribute("queryRoadresult",resultset);
		return "transport_capacity/transportcapacity_find_line";
	}
	
	/**
	 *修改路线信息
	 * @param road
	 * @return String
	 */
	@RequestMapping(value="/modifytransportcapacityline",method=RequestMethod.GET)
	public String modifyRoad(Integer roadid,Model model){
		Road road=roadservice.queryRoadById(roadid);
		model.addAttribute("road",road);
		return "transport_capacity/transportcapacity_modify_line";
	}
	
	/**
	 *修改路线信息
	 * @param road
	 * @return String
	 */
	@RequestMapping(value="/modifytransportcapacityline",method=RequestMethod.POST)
	public String modifyRoad(Road road){
		roadservice.modifyRoad(road);
		return "redirect:findtransportcapacityline";
	}
	
	/**
	 *响应寻找路线信息页面
	 * @param road
	 * @return String
	 */
	@RequestMapping(value="/seektransportcapacityline",method=RequestMethod.GET)
	public String seekRoad(){
		return "transport_capacity/transportcapacity_seek_line";
	}
	
	/**
	 *通过路线id寻找路线信息
	 * @param road
	 * @return String
	 */
	@RequestMapping(value="/seektransportcapacitylinebyid")
	public String seekRoadById(@Param("roadid")Integer roadid,Model model){
		List<Map<String,Object>> info=roadservice.seekRoadById(roadid);
		model.addAttribute("seeklineinfo",info);
		return "transport_capacity/transportcapacity_seek_line";
	}
	
	/**
	 *通过起始配送点寻找路线信息
	 * @param road
	 * @return Map<String,Object>
	 */
	@RequestMapping(value="/seektransportcapacitylinebystartpointname")
	public String seekRoadByStartPoint(@Param("startpointname")String startpointname,Model model){
		List<Map<String,Object>> info=roadservice.seekRoadByStartPoint(startpointname);
		model.addAttribute("seeklineinfo",info);
		return "transport_capacity/transportcapacity_seek_line";
	}
	
	/**
	 *通过目标配送点寻找路线信息
	 * @param road
	 * @return Map<String,Object>
	 */
	@RequestMapping(value="/seektransportcapacitylinebyendpointname")
	public String seekRoadByEndPoint(@Param("endpointname")String endpointname,Model model){
		List<Map<String,Object>> info=roadservice.seekRoadByEndPoint(endpointname);
		model.addAttribute("seeklineinfo",info);
		return "transport_capacity/transportcapacity_seek_line";
	}
	
	/**
	 *通过路径寻找路线信息
	 * @param road
	 * @return Map<String,Object>
	 */
	@RequestMapping(value="/seektransportcapacitylinebyroadlength")
	public String seekRoadByRoadLength(@Param("roadlength")Float roadlength,Model model){
		List<Map<String,Object>> info=roadservice.seekRoadByRoadLength(roadlength);
		model.addAttribute("seeklineinfo",info);
		return "transport_capacity/transportcapacity_seek_line";
	}
}
