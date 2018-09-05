package com.teamtwo.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.druid.mock.MockParameterMetaData.Parameter;
import com.teamtwo.mapper.PointDao;
import com.teamtwo.pojo.Point;
import com.teamtwo.pojo.Role;
import com.teamtwo.pojo.Tuser;
import com.teamtwo.service.PointService;
import com.teamtwo.service.RoleService;
import com.teamtwo.service.TuserService;
import com.teamtwo.util.ReturnMsg;

@Controller
public class UserController {
	
	@Autowired
	private TuserService tuserService;
	@Autowired
	private RoleService roleService;
	@Autowired
	private PointService pointService;

	//退出系统
	@RequestMapping(value="/loginout")
	public String logout(HttpSession session){
		session.invalidate();
		return "redirect:login";
	}
	
	//进入登陆界面
	@RequestMapping(value="/login",method=RequestMethod.GET)
	public String login()
	{
		return "login";
	}

	//登录检测
	@RequestMapping(value="/login",method=RequestMethod.POST)
	public String TuserLogin(Tuser tuser,HttpSession session,Model model)
	{
		
		Map<String,Object> returnTuser = tuserService.checkTuser(tuser);
		//如果有该用户则进入系统
		if(!Objects.isNull(returnTuser))
		{
			session.setAttribute("returnTuser", returnTuser);
			session.setAttribute("userid", returnTuser.get("userid"));
			return "redirect:index";
		}
				
		//返回提示信息
		ReturnMsg msg = new ReturnMsg(-1,"账号或密码错误");	
		model.addAttribute("info",msg);
		return "login";
	}
	
	//进入查询用户界面
	@RequestMapping(value="/userfind")
	public String userfind_do(Model model)
	{
		//获取所有用户信息
		List<HashMap<String,Object>> alltusers= tuserService.selectAllTuser();
		List<Role> roles = roleService.selectAll();
		
		model.addAttribute("alltusers",alltusers);
		model.addAttribute("roles",roles);
		return "user/user_find";
	}
	
	
	//进入增加用户页面
		@RequestMapping(value="/useradd",method=RequestMethod.GET)
		public String userAdd(Model model)
		{
			List<Role> roles = roleService.selectAll();
			List<Point> points = pointService.getPointListNoPage();
			model.addAttribute("roles",roles);
			model.addAttribute("points", points);
			return "user/user_add";
		}
		
	
	//增加用户
	@RequestMapping(value="/doaddtuser",method=RequestMethod.POST,produces = {"application/json;charset=UTF-8;"})
	@ResponseBody
	public ReturnMsg adduser_do(HttpServletRequest request,HttpServletResponse response)
	{
		//接收ajax传来的值
		Tuser tuser = new Tuser();
		tuser.setUsername(request.getParameter("username"));
		tuser.setPassword(request.getParameter("password"));
		tuser.setPointid(Integer.parseInt(request.getParameter("pointid")));
		tuser.setTel(request.getParameter("tel"));
		tuser.setAddr(request.getParameter("addr"));
		tuser.setRoleid(Integer.parseInt(request.getParameter("roleid")));
		tuser.setRealname(request.getParameter("realname"));
		
		//返回增加用户情况
		ReturnMsg info = tuserService.addTuser(tuser);
		
		//model.addAttribute("info",info);
		
		return info;
	}
	
	//进入修改个人信息页面，并加载个人信息
	@RequestMapping(value="/usermodify",method=RequestMethod.GET)
	public String usermodify(HttpSession session,Model model)
	{
		//获取自己的id
		int myid = Integer.parseInt(session.getAttribute("userid").toString());
		Map<String,Object> myInfo= tuserService.lookOneTuser(myid);
		model.addAttribute("myInfo",myInfo);
	
		List<Point> points = pointService.getPointListNoPage();
		model.addAttribute("points", points);
		
		return "user/user_modify";
	}
	
	
		
	//修改用户信息
	@RequestMapping(value="/doModifyTuser",method=RequestMethod.POST,produces = {"application/json;charset=UTF-8;"})
	@ResponseBody
	public ReturnMsg modifyuser_do(HttpSession session,HttpServletRequest request,HttpServletResponse response,Model model)
	{
		//接收ajax传来的值
		Tuser tuser = new Tuser();
		
		//获取自己的id
		int myid = Integer.parseInt(session.getAttribute("userid").toString());
		tuser.setUserid(myid);
		tuser.setUsername(request.getParameter("username"));
		tuser.setPassword(request.getParameter("password"));
		tuser.setPointid(Integer.parseInt(request.getParameter("pointid")));
		tuser.setTel(request.getParameter("tel"));
		tuser.setAddr(request.getParameter("addr"));
		tuser.setRealname(request.getParameter("realname"));
		//用户类型只能由总公司管理员修改，用户本身只能查看
		//tuser.setRoleid(Integer.parseInt(request.getParameter("roleid")));
		
		//更新情况
		ReturnMsg info = tuserService.updateTuser(tuser);
		
		if(info.getStatus()>1)
		{
			Map<String,Object> my = tuserService.lookOneTuser(tuser.getUserid());
			model.addAttribute("myinfo",my);
		}
		
		return info;
	}
	
	//通过userid修改对应的roleid
	@RequestMapping(value="/doModifyroleid",method=RequestMethod.POST,produces = {"application/json;charset=UTF-8;"})
	@ResponseBody
	public ReturnMsg doModifyroleid(HttpServletRequest request,HttpServletResponse response)
	{
		//接收ajax传来的值
		Tuser tuser = new Tuser();
		tuser.setUserid(Integer.parseInt(request.getParameter("userid")));
		tuser.setRoleid(Integer.parseInt(request.getParameter("roleid")));

		//更新情况
		ReturnMsg info = tuserService.modifyroleid(tuser);
		
		return info;
	}
	
	//通过userid删除用户
	@RequestMapping(value="/doDelTuser",method=RequestMethod.POST,produces = {"application/json;charset=UTF-8;"})
	@ResponseBody
	public ReturnMsg doDelTuser(HttpServletRequest request,HttpServletResponse response)
	{
		//接收ajax传来的值
		int userid = Integer.parseInt(request.getParameter("userid"));

		//更新情况
		ReturnMsg info = tuserService.delTuser(userid);
		
		return info;
	}

	//查询用户名是否可用
	@RequestMapping(value="/checkun",method=RequestMethod.POST,produces = {"application/json;charset=UTF-8;"})
	@ResponseBody
	public ReturnMsg checkun(HttpServletRequest request,HttpServletResponse response)
	{
		//接收ajax传来的值
		String username = request.getParameter("username");
		
		//更新情况
		ReturnMsg checkinfo = tuserService.checkun(username);
		
		return checkinfo;
	}
	
}
