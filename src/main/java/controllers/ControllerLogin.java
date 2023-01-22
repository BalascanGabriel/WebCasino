package controllers;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.DaoActivity;
import dao.DaoUser;
import model.ActivityEntry;
import model.User;


@WebServlet("/ControllerLogin")
public class ControllerLogin extends HttpServlet {

	private DaoUser dao = new DaoUser();
	private DaoActivity daoActivity = new DaoActivity();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

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
			
			ActivityEntry activity = new ActivityEntry();
			activity.setIp(request.getRemoteAddr());
			activity.setLastLogin(new Date());
			activity.setUserId(userGasit.getId());
			daoActivity.save(activity);
			
			response.sendRedirect("/BlackjackWeb/ControllerGamePage");
		}else {
			HttpSession sesiunea = request.getSession(true);
			System.out.println("LOGIN FAILED");
			sesiunea.setAttribute("UTILIZATORUL", null);
			sesiunea.setAttribute("LOGIN_STATUS", "failed");
			response.sendRedirect("ControllerLogin"); // ?eroare=da
		}
		
	}

}
