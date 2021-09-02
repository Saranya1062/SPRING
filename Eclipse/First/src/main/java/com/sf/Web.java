package com.sf;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class Web extends HttpServlet {

	public void service(HttpServletRequest req, HttpServletResponse res) throws IOException {

		String n1 = req.getParameter("num1");
		String n2 = req.getParameter("num2");

		PrintWriter out = res.getWriter();

		DataSource db = new DataSource();
		try {
			if (!db.open()) {
				System.out.println("Couldn't open the datasource");
				return;
			}
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			if (db.check(n1, n2)) {
				out.println("Welcome");
			} else {
				out.println("Invlaid User");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			db.close();
		}
	}
}