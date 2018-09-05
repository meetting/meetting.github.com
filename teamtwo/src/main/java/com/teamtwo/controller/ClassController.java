package com.teamtwo.controller;

import java.text.DateFormat;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.teamtwo.service.ClassService;

//ctrl+shift+o自动导入包
//运力信息管理
@Controller
public class ClassController {
	
	@Autowired
	private ClassService classService;
	
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
	 * 响应增加运力页面
	 * @param Class
	 * @return String
	 */
	@RequestMapping(value="/addtransportcapacity",method=RequestMethod.GET)
	public String addClass(){
		return "/transport_capacity/transportcapacity_add";
	}
	
	/**
	 * 增加运力
	 * @param Class
	 * @return String
	 */
	@RequestMapping(value="/addtransportcapacity",method=RequestMethod.POST)
	public String addClass(com.teamtwo.pojo.Class lclass){
		classService.addClass(lclass);
		return "redirect:querytransportcapacity";
	}
	
	
	/**
	 * 查询运力信息
	 * @param Class
	 * @return String
	 */
	@RequestMapping(value="/querytransportcapacity")
	public String queryClass(HttpSession session){
		
		List<com.teamtwo.pojo.Class> resultset=classService.queryClass();
		session.setAttribute("queryClassresult", resultset);
		return "transport_capacity/transportcapacity_list";
		
	}
	
	/**
	 * 修改运力信息
	 * @param Class
	 * @return String
	 */
	@RequestMapping(value="/modifytransportcapacity",method=RequestMethod.GET)
	public String updateClassget(Integer classid,Model model)
	{
		com.teamtwo.pojo.Class lclass=classService.queryClassById(classid);
		model.addAttribute("lclass",lclass);
		return "transport_capacity/transportcapacity_list_modify";
	}
	
	
	/**
	 * 修改运力信息
	 * @param Class
	 * @return String
	 */
	@RequestMapping(value="/modifytransportcapacity",method=RequestMethod.POST)
	public String updateClass(com.teamtwo.pojo.Class lclass)
	{
		classService.updateClass(lclass);
		return "redirect:querytransportcapacity";
	}
}
