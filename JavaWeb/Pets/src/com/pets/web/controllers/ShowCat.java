package com.pets.web.controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pets.web.models.Cat;

/**
 * Servlet implementation class ShowCat
 */
@WebServlet("/ShowCat")
public class ShowCat extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int weight = Integer.parseInt(request.getParameter("weight"));
        String name = request.getParameter("name");
        String breed = request.getParameter("breed");
        // Create model
        Cat cat = new Cat(name, breed, weight);
        // Set Model for view
        request.setAttribute("cat", cat);
        // Let view handle the request
        RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/ShowCat.jsp");
        view.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int weight = Integer.parseInt(request.getParameter("weight"));
        String name = request.getParameter("name");
        String breed = request.getParameter("breed");
        // Create model
        Cat cat = new Cat(name, breed, weight);
        // Set Model for view
        request.setAttribute("cat", cat);
        // Let view handle the request
        RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/ShowCat.jsp");
        view.forward(request, response);
	}

}
