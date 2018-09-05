package com.teamtwo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class PageController {

		//主界面入口
		@RequestMapping(value="/index",method=RequestMethod.GET)
		public String index()
		{
			return "index";
		}
		

		//显示登陆界面
		@RequestMapping(value="/frame",method=RequestMethod.GET)
		public String frame()
		{				
			return "frame";
		}
		
		//显示页面头
		@RequestMapping(value="/header",method=RequestMethod.GET)
		public String header()
		{				
			return "header";
		}
		
	
		//显示菜单
		@RequestMapping(value="/menu",method=RequestMethod.GET)
		public String menu()
		{				
			return "menu";
		}
		

		//显示frameindex
		@RequestMapping(value="/frameindex",method=RequestMethod.GET)
		private String frameindex()
		{				
			return "frameindex";
		}
		

		//显示页面尾
		@RequestMapping(value="/footer",method=RequestMethod.GET)
		public String footer()
		{				
			return "footer";
		}
		
		
		
	
}
