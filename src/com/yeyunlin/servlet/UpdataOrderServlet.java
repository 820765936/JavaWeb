package com.yeyunlin.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yeyunlin.dao.FindDeskDao;
import com.yeyunlin.dao.UpdateOrderDao;
import com.yeyunlin.impl.DeskDaoImp;
import com.yeyunlin.impl.UpdateDaoImp;

/**
 * Servlet implementation class UpdataOrderServlet
 */
@WebServlet("/UpdataOrderServlet")
public class UpdataOrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdataOrderServlet() {
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
		UpdateOrderDao updateOrderDao = new UpdateDaoImp();
		FindDeskDao deskDao = new DeskDaoImp();
		
		String paytype = "1";
		String orderId = request.getParameter("orderId");
		String deskId = request.getParameter("deskId");
		
		updateOrderDao.updateOrder(paytype, orderId);
		deskDao.setDeskType(1,Integer.parseInt(deskId));
		out.print("支付成功！");
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
