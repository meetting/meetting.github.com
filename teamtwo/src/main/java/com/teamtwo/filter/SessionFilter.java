package com.teamtwo.filter;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.filter.OncePerRequestFilter;

public class SessionFilter extends OncePerRequestFilter{

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		// 请求的uri
		 String uri = request.getRequestURI();
		 String url = request.getContextPath();
		 String loginPage = url + "/login";
		 if(!uri.endsWith("teamtwo/")){
			 if (uri.indexOf("login") == -1 && uri.indexOf("loginout") == -1 && uri.indexOf(".jpg") == -1) {
				 Object obj = request.getSession().getAttribute("returnTuser");
				 if (null == obj) {
	                 request.setCharacterEncoding("UTF-8");  
	                 response.setContentType("text/html;charset=UTF-8");
					 PrintWriter out = response.getWriter();
					 StringBuilder builder = new StringBuilder();  
	                 builder.append("<script type=\"text/javascript\">");
	                 builder.append("window.top.location.href='");  
	                 builder.append(loginPage);  
	                 builder.append("';");
	                 builder.append("alert('登录超时，请重新登录');");
	                 builder.append("</script>");  
	                 out.print(builder.toString());
				 }else{
					 filterChain.doFilter(request, response);
				 }
			 }else{
				 filterChain.doFilter(request, response);
			 }
		 }else{
			 filterChain.doFilter(request, response);
		 }
	}

}
