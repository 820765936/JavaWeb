package com.yeyunlin.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yeyunlin.dao.FindDeskDao;
import com.yeyunlin.impl.DeskDaoImp;

/**
 * Servlet implementation class FindDeskServlet
 */
@WebServlet("/FindDeskServlet")
public class FindDeskServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FindDeskServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		response.setHeader("Content-type", "text/html;charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		FindDeskDao dao = new DeskDaoImp();
		
		String number = request.getParameter("deskNumber");
		int deskFlag = dao.getDeskType(Integer.parseInt(number));
		if (deskFlag == 1) {
			int type = dao.setDeskType(0,Integer.parseInt(number));
			out.print(type);
		} else {
			out.print(0);
		}
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
