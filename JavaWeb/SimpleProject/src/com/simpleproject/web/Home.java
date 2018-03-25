package com.simpleproject.web;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Home
 */
@WebServlet("/Home")
public class Home extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */


	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String language = request.getParameter("language");
		String town = request.getParameter("town");
		if(firstName == null || firstName == "") {
			firstName = "unknown";
		}
		if(lastName == null || lastName == "") {
			lastName = "unknown";
		}
		if(town == null || town == "") {
			town = "unknown";
		}
		if(language == null || language == "") {
			language = "unknown";
		}
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.write("<h1>Welcome " + firstName+" "+ lastName + "</h1>");
        out.write("<h2>Favorite Lang " + language + "</h2>");
        out.write("<h3>From " + town + "</h3>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
