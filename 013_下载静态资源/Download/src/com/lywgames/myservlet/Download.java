package com.lywgames.myservlet;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Download extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 获取文件名字
		String filename = req.getParameter("filename");
		// 让浏览器收到这份资源的时候, 以下载的方式提醒用户, 而不是直接展示。 
		resp.setHeader("Content-Disposition", "attachment; filename="+filename);
		// 获取这个文件在Tomcat里面的绝对路径地址
		String path = getServletContext().getRealPath("Download/" + filename);
		
		InputStream is = new FileInputStream(path);
		OutputStream os = resp.getOutputStream();
		int len = 0 ;
		byte[] buffer = new byte[1024];
		while((len = is.read(buffer)) != -1){
			os.write(buffer, 0, len);
		}
		os.close();
		is.close();
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
