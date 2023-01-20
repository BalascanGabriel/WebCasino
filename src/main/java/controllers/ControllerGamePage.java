package controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/ControllerGamePage")
public class ControllerGamePage extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/game_page.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String choice = request.getParameter("game");
		System.out.println("Chosen game : " + choice);
		
		if(choice != null && choice.contains("coinflip")) {
			response.sendRedirect("/BlackjackWeb/ControllerCoinflip");
		}
		else if(choice != null && choice.contains("blackjack")) {
			response.sendRedirect("/BlackjackWeb/ControllerGamePage");
		}
		else if(choice != null && choice.contains("roulette")) {
			response.sendRedirect("/BlackjackWeb/ControllerGamePage");
		}
		else if(choice != null && choice.contains("slots")) {
			response.sendRedirect("/BlackjackWeb/ControllerGamePage");
		}
		else {
			response.sendRedirect("/BlackjackWeb/ControllerGamePage");
		}
	

}}
