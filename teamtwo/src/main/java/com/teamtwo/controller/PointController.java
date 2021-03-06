package com.teamtwo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value="pointadmin",method=RequestMethod.GET)
public class PointController {

	//1
	@RequestMapping(value="/pointadd")
	public String pointAdd(){
		return "point/point_add";
	}
	//2
	@RequestMapping(value="/pointlist")
	public String pointList(){
		return "point/point_list";
	}
//	//3
//	@RequestMapping(value="/pointlistmodify")
//	public String pointListModify(){
//		return "point/point_list_modify";
//	}
	//4
	@RequestMapping(value="/pointlistrange")
	public String pointListRange(){
		return "point/point_list_range";
	}
	//5
	@RequestMapping(value="/pointmodifyrange")
	public String pointModifyRange(){
		return "point/point_modify_range";
	}
	//6
	@RequestMapping(value="/pointseekrange")
	public String pointSeekRange(){
		return "point/point_seek_range";
	}
	//7
	@RequestMapping(value="/pointpricemaintenance")
	public String pointPriceMaintenance(){
		return "point/point_price_maintenance";
	}
	//8
	@RequestMapping(value="/pointaddprice")
	public String pointAddPrice(){
		return "point/point_add_price";
	}
	//9
	@RequestMapping(value="/pointseekprice")
	public String pointSeekPrice(){
		return "point/point_seek_price";
	}
	//10
	@RequestMapping(value="/checkorder")
	public String checkOrder(){
		return "check/check_order";
	}
	//11
	@RequestMapping(value="/checkprice")
	public String checkPrice(){
		return "check/check_price";
	}
	//12
	@RequestMapping(value="/checkpricecheck")
	public String checkPriceCheck(){
		return "check/check_price_check";
	}
	
}
