package com.lywgames.myservlet;

import java.io.IOException;
import java.util.Enumeration;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UseHttpServletRequest extends HttpServlet {
	private static final long serialVersionUID = 1L;

	// 获取请求头信息
	private void getHeaders(HttpServletRequest req, HttpServletResponse resp){
		Enumeration<String> headerNames = req.getHeaderNames();
		while(headerNames.hasMoreElements()){
			String name = headerNames.nextElement();
			String header = req.getHeader(name);
			System.out.println(name + " = " + header);
		}
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		getHeaders(req, resp);
		
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		String[] hobbys = req.getParameterValues("hobby");

		StringBuffer sb = new StringBuffer();
		sb.append("[");
		for (int i = 0; i < hobbys.length; i++) {
			if(i != 0){
				sb.append(",");
			}
			sb.append(hobbys[i]);
		}
		sb.append("]");
		
		System.out.println("username = " + username + " password = " + password + " hobby = " + sb.toString());
		
		StringBuilder buffer = new StringBuilder();
		Map<String, String[]> map = req.getParameterMap();
		for (Entry<String, String[]> kv : map.entrySet()) {
			String key = kv.getKey();
			String[] values = kv.getValue();
			if(values.length <= 1){
				buffer.append(key + " = " + values[0]);
			}else{
				buffer.append(key + " = [");
				for (int i = 0; i < values.length; i++) {
					if(i != 0){
						buffer.append(",");
					}
					buffer.append(values[i]);
				}
				buffer.append("]");
			}
			buffer.append(" ");
		}
		System.out.println(buffer.toString());
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
