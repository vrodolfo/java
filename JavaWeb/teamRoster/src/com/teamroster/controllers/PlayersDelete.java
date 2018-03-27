package com.teamroster.controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.teamroster.models.Team;

/**
 * Servlet implementation class PlayersDelete
 */
@WebServlet("/PlayersDelete")
public class PlayersDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String name = (String) request.getParameter("name");
		String teamName = (String) request.getParameter("team");
		ArrayList<Team> teams = new ArrayList<>();
		
		
		if(session.getAttribute("teams") != null) {
			teams = (ArrayList<Team>) session.getAttribute("teams");
            for(int i=0 ; i < teams.size(); i++ ) {
                if (teams.get(i).getName().equals(teamName)) {
                	teams.get(i).deletePlayer(name);
                    System.out.println("remove it");
                }
            }
		}
		
		
		//String url = "/PlayersList?name=" + teamName;
		session.setAttribute("teams", teams);
		response.sendRedirect("/TeamRoster/PlayersList?name=" + teamName);
		//response.sendRedirect(url);
		return;
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
