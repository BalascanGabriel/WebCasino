package controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DaoActivity;
import model.ActivityEntry;

/**
 * Servlet implementation class ControllerRestActivity
 */
@WebServlet("/ControllerRestActivity")
public class ControllerRestActivity extends HttpServlet {
	
	private DaoActivity daoActivity = new DaoActivity();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<ActivityEntry> result = daoActivity.findAll();
//		response.getWriter().append(""+ result);
		String jsonResult = "[";
		
//		{
//			"id" : 1,
//			"user_id" : 1,
//			"last_login" : "1999-10-10 00:00:00",
//			"user_ip" : "192.1356.156"
//		},
		
		for(ActivityEntry a : result) {
			jsonResult += "{\"id\" : "+a.getId()+", \"user_id\" : "+a.getUserId()+", \"last_login\" : \""+a.getLastLogin()+"\", \"user_ip\" : \""+a.getIp()+"\"}";
			if(!(result.indexOf(a) == result.size() - 1)) {
				jsonResult += ",";
			}
		}
		jsonResult += "]";
		response.getWriter().append(jsonResult);
	}

	

}
