package com.lywgames.myservlet;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class OutLoginCount extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 获取ServletContext对象
		ServletContext servletContext = getServletContext();
		int loginCount =  (int)servletContext.getAttribute("loginCount");
		
		StringBuilder sb = new StringBuilder();
		sb.append("<!DOCTYPE html>").append("\r\n");
		sb.append("<html>").append("\r\n");
		sb.append("<head>").append("\r\n");
		// 网页编码UTF-8
		sb.append("<meta charset='UTF-8'>").append("\r\n");
		sb.append("<title>登录次数</title>").append("\r\n");
		sb.append("</head>").append("\r\n");
		sb.append("<body>").append("\r\n");
		sb.append("<h1>登录次数:").append(loginCount).append("</h1>").append("\r\n");
		sb.append("</body>").append("\r\n");
		sb.append("</html>");

		// 相应客户端的内容类型是text/html 编码是UTF-8(包含字符编码和网页编码)
		resp.setContentType("text/html;charset=UTF-8");
		// 字符流响应客户端
		resp.getWriter().println(sb.toString());
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}