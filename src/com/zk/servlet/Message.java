package com.zk.servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
                                                         
public class Message extends HttpServlet{
	
	public static Map<String, String> map = new HashMap<String, String>();
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doGet(req, resp);
	}
	 
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		map.put("admin", "adminuser");
		
		// 注册相关
		String regmess = ""; 
		String regname = req.getParameter("regname")==null?"":req.getParameter("regname"); 
		String regpass = req.getParameter("regname")==null?"":req.getParameter("regname");
		
		// 用于判断的flag
		boolean flag = false;         
		boolean regflag = true;                                                		
		
		// 登陆相关
		String message = "";
		String name = req.getParameter("username") == null?"":req.getParameter("username"); 
		String pass = req.getParameter("pass") == null?"":req.getParameter("pass");   
	
		// 判断是登陆还是注册提交
		String fs = req.getParameter("method")==null?"":req.getParameter("method");
		
		try {
			if(fs.equals("login")) {
				Set<String> keys = map.keySet();
				for(String key : keys) {                                     
					if( name.equals(key) )  flag = true;           
				}
				if(flag) {
					if( pass.equals(map.get(name)) ) {
						message = "会员" + name + "登陆成功";
						req.setAttribute("mess", message);  
						// 将页面转发到login_ok.jsp,并且携带request和response对象
						req.getRequestDispatcher("login_ok.jsp").forward(req, resp);
					} else {
						message = "登陆失败,貌似您密码不对";
						req.setAttribute("mess", message);    
						req.getRequestDispatcher("login_error.jsp").forward(req, resp);
					}
				} else {
					message = "登陆失败,貌似无" + name + "用户名,请重新输入或注册";
					req.setAttribute("mess", message);    
					req.getRequestDispatcher("login_error.jsp").forward(req, resp);
				}
			} else if(fs.equals("register")) {
				Set<String> rkey = map.keySet();
				for(String key : rkey) {                                     
					if( regname.equals(key) )  regflag = false;           
				}                                   
				if(regflag) {
					map.put(regname, regpass);
					regmess = "新会员" + regname + "注册成功！";
					req.setAttribute("regmess", regmess);
					req.getRequestDispatcher("reg_ok.jsp").forward(req, resp);
				}
			}
		} catch (Exception e) {
			message = "异常返回";
			req.setAttribute("mess", message);
			req.getRequestDispatcher("login_exception.jsp").forward(req, resp);
		}	
	}
}
