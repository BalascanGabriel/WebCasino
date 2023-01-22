package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import model.ActivityEntry;

public class DaoActivity implements IDao<ActivityEntry>{

	static {
		// asta se executa cand DaoUser e loaded into memory JUST ONCE
		System.out.println("SALUT");
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public DaoActivity() {
	}

	
	@Override
	public List<ActivityEntry> findAll() {
		List<ActivityEntry> result = new ArrayList<>();
		try {

			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3307/blackjack", "root", "1234");
			Statement stmt = conn.createStatement();
			ResultSet rezultate = stmt.executeQuery("SELECT * FROM user_activity_log");
			while (rezultate.next()) {
//				System.out.println("NAME: " + rezultate.getString("Name"));
				ActivityEntry activity = new ActivityEntry();
				activity.setId(rezultate.getInt("id"));
				Date dateLogin = new Date(rezultate.getDate("last_login").getTime());
				activity.setLastLogin(dateLogin);
				activity.setUserId(rezultate.getInt("user_id"));
				activity.setIp(rezultate.getString("user_ip"));
				result.add(activity);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	

//create table user_activity_log(
//	id int primary key auto_increment,
//    user_id int,
//    last_login datetime,
//    user_ip varchar(200),
//    foreign key(user_id) references users(id)
//);
	
	@Override
	public void save(ActivityEntry o) {
		try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3307/blackjack", "root", "1234");
				PreparedStatement pst = con
						.prepareStatement("INSERT INTO user_activity_log (user_id, last_login, user_ip) VALUES (?, ? , ?)")) {

			pst.setInt(1, o.getUserId());
			java.sql.Date dateLogin = new java.sql.Date(o.getLastLogin().getTime());
			pst.setDate(2, dateLogin);
			pst.setString(3, o.getIp());
			pst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
