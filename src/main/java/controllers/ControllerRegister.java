package controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DaoUser;
import model.User;

@WebServlet("/ControllerRegister")
public class ControllerRegister extends HttpServlet {
	
	private DaoUser dao = new DaoUser();

    public ControllerRegister() {
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("register.jsp").forward(request, response);

	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Everything from register.jsp form is POST so it goes here
		//Verificam daca primit parametrii
		if(request.getParameter("username") != null) {
			User user = new User();
			user.setName(request.getParameter("username"));
    		user.setEmail(request.getParameter("email"));
    		user.setPassword(request.getParameter("password"));
    		dao.registerUser(user);
			response.sendRedirect("/BlackjackWeb/ControllerRegister");

		}
	}

}
