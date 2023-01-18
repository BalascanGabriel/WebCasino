package controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DaoUser;
import model.User;

@WebServlet("/ControllerServletOtherUsers")
public class ControllerServletOtherUsers extends HttpServlet {
       
	private DaoUser dao = new DaoUser();

    public ControllerServletOtherUsers() {
     
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
		request.setAttribute("MesajdinServlet", "Salut din servlet");
		
		List<User> userii = dao.testSelect();
		request.setAttribute("Users", userii);
		

		request.getRequestDispatcher("otherUsers.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//Din jsp la form se trimite in post un id cu numele userId
		if(request.getParameter("userId") != null) {
			//Luam acest parametru
			Integer userIdDinUrl = Integer.valueOf(request.getParameter("userId"));
			System.out.println("PARAMETRU DIN URL PENTRU USER ID: " + userIdDinUrl);
			//stergem
			dao.deleteUser(userIdDinUrl);
			//dam un fel de refresh
			response.sendRedirect("/BlackjackWeb/ControllerServletOtherUsers");
		}
		
		}

}
