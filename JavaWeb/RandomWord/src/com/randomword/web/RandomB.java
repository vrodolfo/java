package com.randomword.web;

import java.io.IOException;
import java.util.Date;
import java.util.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class RandomB
 */
@WebServlet("/RandomB")
public class RandomB extends HttpServlet {
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
		String word ="";
		Date time = new Date();
		if (session.getAttribute("count") != null) {
			count = (int) session.getAttribute("count");
			word = (String) session.getAttribute("word");
			time = (Date) session.getAttribute("time");
		}
		else {
			session.setAttribute("count", count);
			session.setAttribute("time", time);
			session.setAttribute("word", word);
		}
		request.setAttribute("count", count);
		request.setAttribute("time", time);
		request.setAttribute("word", word);
		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/Random.jsp");
        view.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		int count = 0;
		count = (int) session.getAttribute("count");
		count++;
		String word ="";
		Date time = new Date();
		String[] letters = new String[] {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K" };
		
		Random rand = new Random();
		int num;
		//int randomNum = rand.nextInt((max - min) + 1) + min;
		for(int i=0; i <= 10; i++){
			num = rand.nextInt((9) + 1) + 0;
			word = word + letters[num];
		}
		
		session.setAttribute("count", count);
		session.setAttribute("time", time);
		session.setAttribute("word", word);
		
		request.setAttribute("count", count);
		request.setAttribute("time", time);
		request.setAttribute("word", word);
		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/Random.jsp");
        view.forward(request, response);
	}

}
