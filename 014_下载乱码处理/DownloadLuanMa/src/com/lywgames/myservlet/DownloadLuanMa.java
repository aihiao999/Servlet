package com.lywgames.myservlet;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sun.misc.BASE64Encoder;

public class DownloadLuanMa extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public static String base64EncodeFileName(String fileName) {
		BASE64Encoder base64Encoder = new BASE64Encoder();
		try {
			return "=?UTF-8?B?" + new String(base64Encoder.encode(fileName.getBytes("UTF-8"))) + "?=";
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 获取文件名字
		String filename = new String(req.getParameter("filename").getBytes("ISO8859-1"), "UTF-8");
		// 获取来访的客户端类型
		String clientType = req.getHeader("User-Agent");
		// 让浏览器收到这份资源的时候, 以下载的方式提醒用户, 而不是直接展示。 
		if(clientType.contains("Firefox")){
			resp.setHeader("Content-Disposition", "attachment; filename="+base64EncodeFileName(filename));
		}else{
			resp.setHeader("Content-Disposition", "attachment; filename="+URLEncoder.encode(filename, "UTF-8"));
		}
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
