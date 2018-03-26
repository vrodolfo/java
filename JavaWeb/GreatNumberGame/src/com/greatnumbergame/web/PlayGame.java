package com.greatnumbergame.web;

import java.io.IOException;
import java.util.Date;
import java.util.Random;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class PlayGame
 */
@WebServlet("/PlayGame")
public class PlayGame extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */


	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();

		boolean newGame = true;
		boolean won = false;
		boolean tooLow = false;
		boolean tooHigh = false;
		int numberPlayed = 0;
		int numberWinning = 0;

		//if (session.getAttribute("numberWinning") == null) {
			Random rand = new Random();
			//int randomNum = rand.nextInt((max - min) + 1) + min;
			numberWinning = rand.nextInt((100 - 1) + 1) + 1;
			session.setAttribute("numberWinning", numberWinning);
			
			
			
		//}
		
		request.setAttribute("numberWinning", numberWinning);
		request.setAttribute("numberPlayed", numberPlayed);
		request.setAttribute("newGame", newGame);
		request.setAttribute("won", won);
		request.setAttribute("tooLow", tooLow);
		request.setAttribute("tooHigh", tooHigh);
		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/Index.jsp");
        view.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		int numberPlayed = Integer.parseInt(request.getParameter("number"));
		int numberWinning = (int) session.getAttribute("numberWinning");
		boolean playAgain = Boolean.parseBoolean(request.getParameter("playAgain"));
		boolean newGame = false;
		boolean won = false;
		boolean tooLow = false;
		boolean tooHigh = false;
		
		
		if(playAgain) {
			response.sendRedirect("/GreatNumberGame/PlayGame");
			return;
		}
		
		if(numberPlayed == numberWinning) {
			won = true;
			
		}
		else if(numberPlayed > numberWinning) {
			tooHigh = true;
		}
		else {
			tooLow = true;
		}
		
		request.setAttribute("numberWinning", numberWinning);
		request.setAttribute("numberPlayed", numberPlayed);
		request.setAttribute("newGame", newGame);
		request.setAttribute("won", won);
		request.setAttribute("tooLow", tooLow);
		request.setAttribute("tooHigh", tooHigh);
		
		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/Index.jsp");
        view.forward(request, response);
	}

}
