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

import com.teamroster.models.Player;
import com.teamroster.models.Team;

/**
 * Servlet implementation class PlayersAdd
 */
@WebServlet("/PlayersAdd")
public class PlayersAdd extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = (String) request.getParameter("name");
		request.setAttribute("name", name);
		
		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/PlayersAdd.jsp");
        view.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String name = (String) request.getParameter("name");
		Team team = new Team();
		ArrayList<Team> teams = new ArrayList<>();
		String firstName = (String) request.getParameter("firstName");
		String lastName = (String) request.getParameter("lastName");
		int age = Integer.parseInt(request.getParameter("age"));
		Player player = new Player(firstName, lastName, age);
		
		if(session.getAttribute("teams") != null) {
			teams = (ArrayList<Team>) session.getAttribute("teams");
//			Iterator<Team> it = teams.iterator();
//            while (it.hasNext()) {
//                Team temp = it.next();
//                if (temp.getName().equals(name)) {
//                	System.out.println("ifffffffff: " );
//                	temp.addPlayer(player);
//                }
//            }
			for(int i = 0 ; i < teams.size(); i++ ) {
				if(teams.get(i).getName().equals(name)) {
					teams.get(i).addPlayer(player);
				}
			}
		}
		session.setAttribute("teams", teams);
		response.sendRedirect("/TeamRoster/PlayersList?name="+name);
		return;
	}

}
