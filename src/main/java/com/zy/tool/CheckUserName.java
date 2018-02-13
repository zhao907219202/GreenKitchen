package com.zy.tool;

import com.zy.dto.User;
import com.zy.interfaces.UserServiceInter;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


public class CheckUserName extends HttpServlet {

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		response.setHeader("Cache-control", "no-cache");
		String name=request.getParameter("name");
		String name_zh =  new String(name.getBytes("iso8859-1"), "utf-8");
		WebApplicationContext ctx = WebApplicationContextUtils.getWebApplicationContext(this.getServletContext());
		UserServiceInter userService=(UserServiceInter) ctx.getBean("userService");
		User user=null;
		user=userService.findUserByName(name_zh);
		if(user!=null)
			out.write("false");
		else
			out.write("true");
		out.close();
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doGet(request, response);
	}

}
