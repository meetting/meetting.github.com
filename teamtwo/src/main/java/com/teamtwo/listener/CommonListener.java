package com.teamtwo.listener;


import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class CommonListener implements ServletContextListener {
	

	public CommonListener() {}

	public void contextDestroyed(ServletContextEvent sce) {}


	public void contextInitialized(ServletContextEvent sce) {

		ServletContext servletContext = sce.getServletContext();
		String root = servletContext.getContextPath();
		servletContext.setAttribute("teamtwo", root);
		servletContext.setAttribute("include", root + "/resources/include");
		servletContext.setAttribute("css", root + "/resources/css");
		servletContext.setAttribute("images", root + "/resources/images");
		servletContext.setAttribute("dt", root + "/resources/My97DatePicker");
		servletContext.setAttribute("js", root + "/resources/include/js");


	}
}
