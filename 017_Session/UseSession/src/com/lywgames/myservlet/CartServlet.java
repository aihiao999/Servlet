package com.lywgames.myservlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 获取商品id
		String name = new String(req.getParameter("name").getBytes("ISO8859-1"), "UTF-8");
		// 获取session中的cartlist
		@SuppressWarnings("unchecked")
		Map<String, Integer> cartlist = (Map<String, Integer>)req.getSession().getAttribute("cartlist");
		// 如果cartlist为空, session中还没有购物车
		if(cartlist == null){
			cartlist = new HashMap<String, Integer>();
			cartlist.put(name, 1);
		}else{
			cartlist.put(name, cartlist.get(name) == null ? 1 : cartlist.get(name) + 1);
		}
		req.getSession().setAttribute("cartlist", cartlist);
		
		resp.setContentType("text/html;charset=utf-8");
		
		StringBuffer sb = new StringBuffer();
		sb.append("<!DOCTYPE html>").append("\r\n");
		sb.append("<html>").append("\r\n");
		sb.append("<head>").append("\r\n");
		sb.append("<meta charset='UTF-8'>").append("\r\n");
		sb.append("<title>购物车</title>").append("\r\n");
		sb.append("</head>").append("\r\n");
		sb.append("<body>").append("\r\n");
		for (Entry<String, Integer> kv : cartlist.entrySet()) {
			sb.append("<h3>").append(kv.getKey()).append(": ").append(kv.getValue()).append("</h3>").append("\r\n");
		}
		sb.append("<h1><a href='index.html'>继续购物</a></h1>").append("\r\n");
		sb.append("<h1><a href='ClearCartList.action'>清空购物车</a></h1>").append("\r\n");
		sb.append("</body>").append("\r\n");
		sb.append("</html>").append("\r\n");
		resp.getWriter().println(sb.toString());
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
