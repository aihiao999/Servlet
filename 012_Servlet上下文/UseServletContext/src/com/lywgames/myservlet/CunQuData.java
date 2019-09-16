package com.lywgames.myservlet;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CunQuData extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 获取ServletContext对象
		ServletContext servletContext = getServletContext();
		
		Object loginCount =  servletContext.getAttribute("loginCount");
		if(loginCount != null){
			servletContext.setAttribute("loginCount", (((int)loginCount) + 1));
		}else{
			servletContext.setAttribute("loginCount", 1);
		}
		
		resp.sendRedirect("OutLoginCount.action");
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}