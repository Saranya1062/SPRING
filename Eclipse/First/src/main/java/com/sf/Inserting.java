package com.sf;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class Inserting extends HttpServlet {

	public void service(HttpServletRequest req, HttpServletResponse res) throws IOException {

		String n1 = req.getParameter("op1");
		String n2 = req.getParameter("op2");

		PrintWriter out = res.getWriter();

		DataSource datasource = new DataSource();

		try {
			if (!datasource.open()) {
				System.out.println("Couldn't open the datasource");
				return;
			}
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			if (datasource.insert(n1, n2)) {
				out.println("Inserted ");
			} else {
				out.println("Not Inserted");
			}
		} finally {
			datasource.close();
		}
	}
}