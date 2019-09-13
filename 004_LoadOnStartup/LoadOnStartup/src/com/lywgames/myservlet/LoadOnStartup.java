package com.lywgames.myservlet;

import java.io.IOException;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class LoadOnStartup implements Servlet {
	public LoadOnStartup(){
		System.out.println("LoadOnStartup");
	}
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		System.out.println("LoadOnStartup init");
	}
	
	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		System.out.println("LoadOnStartup service");
	}
	
	@Override
	public void destroy() {
		System.out.println("LoadOnStartup destroy");
	}

	@Override
	public ServletConfig getServletConfig() {
		return null;
	}

	@Override
	public String getServletInfo() {
		return null;
	}

}
