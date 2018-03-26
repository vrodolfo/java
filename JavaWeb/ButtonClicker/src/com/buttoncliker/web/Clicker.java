package com.buttoncliker.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Clicker
 */
@WebServlet("/Clicker")
public class Clicker extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */


	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		int count = 0;
		if (session.getAttribute("count") != null) {
			count = (int) session.getAttribute("count");
		}
		request.setAttribute("count", count);
		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/Clicker.jsp");
        view.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		int count = 0;
		if (session.getAttribute("count") == null) {
			session.setAttribute("count", count);
		}
		else {
			count = (int) session.getAttribute("count");
			count++;
			session.setAttribute("count", count);
		}
		request.setAttribute("count", count);
		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/Clicker.jsp");
        view.forward(request, response);
	}

}
