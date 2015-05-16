package com.yeyunlin.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yeyunlin.dao.RegisterDao;
import com.yeyunlin.dao.TestDao;
import com.yeyunlin.entity.User;
import com.yeyunlin.impl.RegisterDaoImp;
import com.yeyunlin.impl.TestDaoImp;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		response.setHeader("Content-type", "text/html;charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		RegisterDao dao = new RegisterDaoImp();
		
		String name = new String(request.getParameter("name").getBytes("ISO-8859-1"),"UTF-8");
		String account = request.getParameter("account");
		String password = request.getParameter("password");
		int integral = Integer.parseInt(request.getParameter("integral"));
		String icon = request.getParameter("icon");
		
		User user = new User();
		user.setName(name);
		user.setAccount(account);
		user.setPassword(password);
		user.setIntegral(integral);
		user.setIcon(icon);
		
		dao.register(user);
		
		out.print("ok");
		out.flush();
		out.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
