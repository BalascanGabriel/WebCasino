package controllers;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DaoUser;
import model.User;

@WebServlet("/ControllerServletUsers")
public class ControllerServletUsers extends HttpServlet {

	private DaoUser dao = new DaoUser();

	public ControllerServletUsers() {
		System.out.println("CONSTRUCTOR CONTROLLER");
	}

	// se ocupa de SELECT => 0 consequences
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		
		List<User> userii = dao.testSelect();
		if (request.getParameter("sort") != null) {
			if (request.getParameter("element").equals("id")) {
				// am dat click pe link => ar trebui sa sortam userii dupa id desc
				Collections.sort(userii, (u1, u2) -> u2.getId() - u1.getId());
			} else if (request.getParameter("element").equals("name")) {
				Collections.sort(userii, (u1, u2) -> u2.getName().toUpperCase().compareTo(u1.getName().toUpperCase()));
			}
		}

		request.setAttribute("USERII", userii);
		request.setAttribute("MESAJ", "SALUT DIN SERVLET");
		request.getRequestDispatcher("WEB-INF/users.jsp").forward(request, response);

	}

	// orice modifica "state"-ul aplicatiei goes here
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		if(request.getParameter("userId")!= null){
			// am dat click pe link-ul de delete
			Integer userIdDinUrl = Integer.valueOf(request.getParameter("userId"));
			System.out.println("PARAMETRU DIN URL PENTRU USER ID: " + userIdDinUrl);
			 dao.deleteUser(userIdDinUrl);
			 response.sendRedirect("/BlackjackWeb/ControllerServletUsers");
		}
		
		if (request.getParameter("new-username") != null) {
			// TODO: call DAO
			User user = new User();
			user.setEmail(request.getParameter("new-useremail"));
			user.setBalance(Integer.valueOf(request.getParameter("new-userbalance")));
			user.setName(request.getParameter("new-username"));
			dao.saveUser(user);
			
			response.sendRedirect("/BlackjackWeb/ControllerServletUsers");
		}
	}

}
