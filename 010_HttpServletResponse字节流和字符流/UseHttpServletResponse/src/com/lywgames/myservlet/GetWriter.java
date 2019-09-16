package com.lywgames.myservlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class GetWriter extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		StringBuilder sb = new StringBuilder();
		sb.append("<!DOCTYPE html>").append("\r\n");
		sb.append("<html>").append("\r\n");
		sb.append("<head>").append("\r\n");
		sb.append("<meta charset='UTF-8'>").append("\r\n");
		sb.append("<title>HttpServletResponse GetWriter</title>").append("\r\n");
		sb.append("</head>").append("\r\n");
		sb.append("<body>").append("\r\n");
		sb.append("<h1>HttpServletResponse GetWriter</h1>").append("\r\n");
		sb.append("</body>").append("\r\n");
		sb.append("</html>");

		// HttpServletResponse的getWriter()方法, 向客户端输出字符流
		resp.getWriter().println(sb.toString());
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
