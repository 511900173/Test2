package com.tedu.req;
/**模拟查询个人信息*/
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RequestDemo2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		//模拟通过jdbc访问数据库查询个人信息
		String name = "王海涛";
		String addr = "背景石景山";
		//将数据存入到request对象的map集合中
		request.setAttribute("name", name);
		request.setAttribute("addr", addr);
		//通过装分将request对象带到jsp,去除数据进行显示
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
