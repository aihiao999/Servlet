package com.lywgames.myservlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class GWSetCharacterEncodingGB2312 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		StringBuilder sb = new StringBuilder();
		sb.append("<!DOCTYPE html>").append("\r\n");
		sb.append("<html>").append("\r\n");
		sb.append("<head>").append("\r\n");
		sb.append("<meta>").append("\r\n");
		sb.append("<title>HttpServletResponse 字符流相应中文乱码</title>").append("\r\n");
		sb.append("</head>").append("\r\n");
		sb.append("<body>").append("\r\n");
		sb.append("<h1>HttpServletResponse 字符流相应中文乱码</h1>").append("\r\n");
		sb.append("</body>").append("\r\n");
		sb.append("</html>");
		
		// 相应给客户端的字符编码GB2312
		resp.setCharacterEncoding("GB2312");
		// 字符流响应客户端
		resp.getWriter().println(sb.toString());
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
