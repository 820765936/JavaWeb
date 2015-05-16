package com.yeyunlin.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yeyunlin.dao.OrderDao;
import com.yeyunlin.entity.Order;
import com.yeyunlin.impl.OrderDaoImp;

/**
 * Servlet implementation class OrderServlet
 */
@WebServlet("/OrderServlet")
public class OrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OrderServlet() {
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
		OrderDao dao = new OrderDaoImp();
		
		String orderId = request.getParameter("orderId");
		String userName = new String(request.getParameter("userName").getBytes("ISO-8859-1"),"UTF-8");
		String foodId = request.getParameter("foodId");
		String deskId = request.getParameter("deskId");
		String time = new String(request.getParameter("time").getBytes("ISO-8859-1"),"UTF-8");
		String paytype = request.getParameter("paytype");
		
		Order order = new Order();
		order.setOrderId(orderId);
		order.setUsername(userName);
		order.setFoodid(Integer.parseInt(foodId));
		order.setDeskid(Integer.parseInt(deskId));
		order.setTime(time);
		order.setPaytype(paytype);
		
		dao.insertOrder(order);
		
		out.print(userName+"  "+foodId);
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
