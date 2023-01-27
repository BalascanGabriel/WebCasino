package controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONObject;

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
//		String jsonResult = "[";
		
		JSONArray resultArray = new JSONArray();
		
		for(ActivityEntry a : result) {
			JSONObject activityJson = new JSONObject();
			activityJson.put("id", a.getId());
			activityJson.put("user_id", a.getUserId());
			activityJson.put("last_login", a.getLastLogin());
			activityJson.put("user_ip", a.getIp());
			resultArray.put(activityJson);
//			jsonResult += "{\"id\" : "+a.getId()+", \"user_id\" : "+a.getUserId()+", \"last_login\" : \""+a.getLastLogin()+"\", \"user_ip\" : \""+a.getIp()+"\"}";
//			if(!(result.indexOf(a) == result.size() - 1)) {
//				jsonResult += ",";
//			}
		}
//		jsonResult += "]";
		response.getWriter().append(resultArray.toString());
	}

	

}
