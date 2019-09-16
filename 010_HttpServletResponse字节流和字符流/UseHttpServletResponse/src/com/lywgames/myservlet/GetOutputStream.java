package com.lywgames.myservlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class GetOutputStream extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		StringBuilder sb = new StringBuilder();
		sb.append("<!DOCTYPE html>").append("\r\n");
		sb.append("<html>").append("\r\n");
		sb.append("<head>").append("\r\n");
		sb.append("<meta charset='UTF-8'>").append("\r\n");
		sb.append("<title>HttpServletResponse GetOutputStream</title>").append("\r\n");
		sb.append("</head>").append("\r\n");
		sb.append("<body>").append("\r\n");
		sb.append("<h1>HttpServletResponse GetOutputStream</h1>").append("\r\n");
		sb.append("</body>").append("\r\n");
		sb.append("</html>");
		
		// HttpServletResponse的getOutputStream()方法, 向客户端输出字节流
		resp.getOutputStream().write(sb.toString().getBytes());
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
