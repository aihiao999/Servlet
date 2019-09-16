package com.lywgames.myservlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class GetOutputStreamLuanMa extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		StringBuilder sb = new StringBuilder();
		sb.append("<!DOCTYPE html>").append("\r\n");
		sb.append("<html>").append("\r\n");
		sb.append("<head>").append("\r\n");
		sb.append("<meta charset='UTF-8'>").append("\r\n");
		sb.append("<title>HttpServletResponse 字节流相应中文乱码</title>").append("\r\n");
		sb.append("</head>").append("\r\n");
		sb.append("<body>").append("\r\n");
		sb.append("<h1>HttpServletResponse 字节流相应中文乱码</h1>").append("\r\n");
		sb.append("</body>").append("\r\n");
		sb.append("</html>");
		
		// 字节流, 默认字符编码是UTF-8
		resp.getOutputStream().write(sb.toString().getBytes());
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
