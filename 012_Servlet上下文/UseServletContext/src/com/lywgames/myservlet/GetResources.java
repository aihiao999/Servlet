package com.lywgames.myservlet;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class GetResources  extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void getRealPath() throws ServletException, IOException {
		// 获取ServletContext对象
		ServletContext servletContext = getServletContext();
		/* servletContext.getRealPath("/"): 工程在tomcat里面的根目录。
		 * C:\Users\lywgames\Desktop\software\apache-tomcat-7.0.52\wtpwebapps\UseServletContext\
		 */
		// 获取给定的文件在服务器上面的绝对路径
		String realPath = servletContext.getRealPath("file/config.properties");
		Properties properties = new Properties();
		properties.load(new FileInputStream(realPath));
		System.out.println("name = " + properties.getProperty("name"));
	}
	
	public void getResourceAsStream() throws ServletException, IOException {
		// 获取ServletContext对象
		ServletContext servletContext = getServletContext();
		// servletContext.getResourceAsStream使用工程在tomcat里面的根目录。
		InputStream is = servletContext.getResourceAsStream("file/config.properties");
		Properties properties = new Properties();
		properties.load(is);
		System.out.println("name = " + properties.getProperty("name"));
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 类路径相对于classes路径:C:\Users\lywgames\Desktop\software\apache-tomcat-7.0.52\wtpwebapps\UseServletContext\WEB-INF\classes
		InputStream is = this.getClass().getClassLoader().getResourceAsStream("../../file/config.properties");
		Properties properties = new Properties();
		properties.load(is);
		System.out.println("name = " + properties.getProperty("name"));
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}