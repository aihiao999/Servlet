package com.lywgames.myservlet;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UseServletConfig extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// ServletConfig: 可以获取servlet的一些配置信息。
		
		//1. 得到servlet配置对象, 专门用于获取配置在servlet的信息
		ServletConfig servletConfig = getServletConfig();
		//2. 获取到的是配置servlet里面servlet-name的文本内容
		String servletName = servletConfig.getServletName();
		System.out.println("servletName = " + servletName);
		
		//3. 可以获取具体的某一个参数。
		String address = servletConfig.getInitParameter("address");
		System.out.println("address = " + address);
				
		//4. 获取所有的参数名称
		Enumeration<String> names = servletConfig.getInitParameterNames();
		//5. 遍历取出所有的参数名称
		while (names.hasMoreElements()) {
			String key = (String) names.nextElement();
			String value = servletConfig.getInitParameter(key);
			System.out.println("key = " + key + ", value = "+value);
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
