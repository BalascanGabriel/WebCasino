package controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.DaoUser;
import model.User;


@WebServlet("/ControllerLogin")
public class ControllerLogin extends HttpServlet {

	private DaoUser dao = new DaoUser();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		if(request.getRemoteAddr().contains("192")) {
//			response.sendRedirect(");
//		}
		
	
		
		request.getRequestDispatcher("login.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		User userGasit = dao.findByUsernameAndPassword(username, password);
		
		if(userGasit != null) {
			System.out.println("LOGIN SUCCESS");
			// ar trebui sa ii spunem sesiunii ca login
			HttpSession sesiunea = request.getSession(true);
			sesiunea.setAttribute("UTILIZATORUL", userGasit);
			response.sendRedirect("/BlackjackWeb/ControllerGamePage");
		}else {
			System.out.println("LOGIN FAILED");
			response.sendRedirect("ControllerLogin"); // ?eroare=da
		}
		
	}

}
