package com.teamroster.controllers;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.teamroster.models.Team;

/**
 * Servlet implementation class TeamsAdd
 */
@WebServlet("/TeamsAdd")
public class TeamsAdd extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/TeamsAdd.jsp");
        view.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String name = (String) request.getParameter("name");
		Team team = new Team(name);
		ArrayList<Team> teams = new ArrayList<>();
		
		if(session.getAttribute("teams") != null) {
			teams = (ArrayList<Team>) session.getAttribute("teams");
		}
		teams.add(team);
		session.setAttribute("teams", teams);
		String URL = "/Home"; 
		RequestDispatcher rd; 
		rd = getServletContext().getRequestDispatcher(URL); 
		rd.forward(request,response);
		return;
	}

}
