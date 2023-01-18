package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.User;

public class DaoUser {

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

	public DaoUser() {
		System.out.println("SALUT DAO DAO DAO");
	}

	// SELECT * FROM users
//	CREATE TABLE `users` (
//			  `Id` int NOT NULL AUTO_INCREMENT,
//			  `Name` varchar(255) DEFAULT NULL,
//			  `Password` varchar(255) DEFAULT NULL,
//			  `Email` varchar(255) DEFAULT NULL,
//			  `Balance` int DEFAULT NULL,
//			  PRIMARY KEY (`Id`)
//			) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

	public User findByUsernameAndPassword(String username, String password) {
		User userGasit = null;
		try {
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3307/blackjack", "root", "1234");
			Statement stmt = conn.createStatement();
			ResultSet rezultate = stmt.executeQuery("SELECT * FROM users WHERE Name = '"+username+"' and Password = '"+password+"'");
			while(rezultate.next()) {
				User user = new User(); // fiecare rand e un User instance
				user.setId(rezultate.getInt("Id"));
				user.setEmail(rezultate.getString("Email"));
				user.setName(rezultate.getString("Name"));
				user.setBalance(rezultate.getInt("Balance"));
				userGasit = user;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return userGasit;
	}

	public List<User> testSelect() {

		List<User> userii = new ArrayList<>();
		try {

			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3307/blackjack", "root", "1234");
			Statement stmt = conn.createStatement();
			ResultSet rezultate = stmt.executeQuery("SELECT * FROM users");
			while (rezultate.next()) {
//				System.out.println("NAME: " + rezultate.getString("Name"));
				User user = new User(); // fiecare rand e un User instance
				user.setId(rezultate.getInt("Id"));
				user.setEmail(rezultate.getString("Email"));
				user.setName(rezultate.getString("Name"));
				user.setBalance(rezultate.getInt("Balance"));
				userii.add(user);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return userii;
	}

	public void deleteUser(int id) {
		try {
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3307/blackjack", "root", "1234");
			Statement stmt = conn.createStatement();
			stmt.executeUpdate("DELETE FROM users where Id = " + id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void saveUser(User user) {
		// TODO: insert into...
		try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3307/blackjack", "root", "1234");
				PreparedStatement pst = con
						.prepareStatement("INSERT INTO users (name, password, email, balance) VALUES (?, ? , ?, ?)")) {

			pst.setString(1, user.getName());
			pst.setString(2, user.getPassword());
			pst.setString(3, user.getEmail());
			pst.setDouble(4, user.getBalance());
			pst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void registerUser(User user) {
		try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3307/blackjack", "root", "1234");
				PreparedStatement pst = con
						.prepareStatement("INSERT INTO users (name, password, email) VALUES (?, ? , ?)")) {

			pst.setString(1, user.getName());
			pst.setString(2, user.getPassword());
			pst.setString(3, user.getEmail());
			pst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public boolean checkLogin(String name, String password) {
		return true;

	}

	public void updateUser() {
		// TODO: make update method
	}

	public static void main(String[] args) {
		DaoUser dao = new DaoUser();
		// dao.testSelect();
		// dao.deleteUser(24);
		User user = new User();
		user.setEmail("joe@gmail.com");
		user.setPassword("password");
		user.setBalance(300);
		user.setName("Joe");
		dao.saveUser(user);
	}

	// INSERT INTO users ...

	// DELETE FROM users WHERE id = ?

	// UPDATE users set ...
}
