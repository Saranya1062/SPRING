package com.sf;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class DataSource {
	private static Connection con;
	
	private static PreparedStatement prepare;

	private static final String NUM = "insert into details(username,password) values(?,?)";

	private static final String NUM2 = "select * from details";

	public boolean open() throws ClassNotFoundException {
		try {
			Class.forName("org.postgresql.Driver");
			con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/new", "postgres", "Saran@10");

			return true;

		} catch (SQLException e) {
			System.out.println("Couldn't connect to the database " + e.getMessage());
			return false;
		}
	}

	public void close() {
		try {
			if (con != null) {
				con.close();
			}
		} catch (SQLException e) {
			System.out.println("Couldn't close the datbase" + e.getMessage());
		}
	}

	public boolean insert(String s1, String s2) {
		try {
			prepare = con.prepareStatement(NUM);
			prepare.setString(1, s1);
			prepare.setString(2, s2);
			prepare.executeUpdate();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}

	}

	public boolean check(String d1, String d2) throws SQLException {

		prepare = con.prepareStatement(NUM2);
		ResultSet resultSet = prepare.executeQuery();
		while (resultSet.next()) {
			String k1 = resultSet.getString("username");
			String k2 = resultSet.getString("password");

			if (d1.equals(k1)) {
				if (d2.equals(k2)) {
					return true;

				}
			}
		}
		return false;
	}
}