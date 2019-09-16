package com.lywgames.myservlet;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginFilter extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Cookie getCookie(HttpServletRequest req, String name) {
		// 使用HttpServletRequest的getCookies()获取Cookie
		Cookie[] cookies = req.getCookies();
		if(cookies != null){
			for (Cookie cookie : cookies) {
				if(cookie.getName().equals(name)){
					return cookie;	
				}
			}
		}
		
		return null;
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=utf-8");
		
		String userName = req.getParameter("username");
		String password = req.getParameter("password");
		
		if("admin".equals(userName) && "123".equals(password)){
			// 获取lastLoginTime的Cookie
			Cookie lastLoginTime = getCookie(req, "last_Login_Time");
			// 如果lastLoginTime为空, 说明是第一次登录
			if(lastLoginTime == null){
				// 创建一个新的cookie
				Cookie cookie = new Cookie("last_Login_Time", String.valueOf(System.currentTimeMillis()));
				// 设置cookie有效期为30天
				cookie.setMaxAge(60 * 60 * 24 * 30); 
				// 只有访问/UseCookie/LoginFilter.action这个路径地址才会带cookie
				cookie.setPath("/UseCookie/LoginFilter.action");
				// 添加cookie, 响应给浏览器
				resp.addCookie(cookie);
				
				// 向客户端输出登录信息
				resp.getWriter().println("欢迎您, " + userName);
			}else{
				// 向客户端输出登录信息
				Date date = new Date(Long.parseLong(lastLoginTime.getValue()));

				// 更新cookie
				lastLoginTime.setValue(String.valueOf(System.currentTimeMillis()));
				resp.addCookie(lastLoginTime);
				
//				// 删除cookie, 需要关闭浏览器, 防止有缓存
//				lastLoginTime.setValue(null); // 设置cookie为空
//				lastLoginTime.setMaxAge(0); // 立即失效
//				// 如果你在创建cookie的时候加上了路径, 删除cookie的时候也要带路径
//				lastLoginTime.setPath("/UseCookie/LoginFilter.action"); 
//				// 从新添加
//				resp.addCookie(lastLoginTime);

				resp.getWriter().println("欢迎您, " + userName + ",上次登录时间是:" + date);
			}
		}else{
			// 向客户端输出登录失败
			resp.getWriter().println("登录失败");
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
