package com.teamroster.controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.teamroster.models.Team;

/**
 * Servlet implementation class TeamsDelete
 */
@WebServlet("/TeamsDelete")
public class TeamsDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String name = (String) request.getParameter("name");
		ArrayList<Team> teams = new ArrayList<>();
		
		
		if(session.getAttribute("teams") != null) {
			System.out.println("entro");
			System.out.println(name);
			teams = (ArrayList<Team>) session.getAttribute("teams");
			Iterator<Team> it = teams.iterator();
            while (it.hasNext()) {
                Team temp = it.next();
                if (temp.getName().equals(name)) {
                    it.remove();
                    System.out.println("remove it");
                }
            }
		}

		session.setAttribute("teams", teams);
		response.sendRedirect("/TeamRoster/Home");
		return;

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.sendRedirect("/TeamRoster/Home");
		return;
	}

}
