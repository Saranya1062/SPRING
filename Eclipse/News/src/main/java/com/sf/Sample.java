package com.sf;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.URL;
import java.net.URLConnection;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class Sample extends HttpServlet {

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		URL url = new URL("https://www.javatpoint.com");
		URLConnection con = url.openConnection();
		con.setDoOutput(true);
		con.connect();

		BufferedReader inputstream = new BufferedReader(new InputStreamReader(url.openStream()));
		PrintWriter writer = res.getWriter();

		String op = "";

		while (op != null) {
			op = inputstream.readLine();
			writer.println(op);
		}

	}
}