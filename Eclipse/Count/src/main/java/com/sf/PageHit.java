package com.sf;

import java.io.*;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class PageHit extends HttpServlet {

	private int hitCount;

	public void init() {
		hitCount = 0;
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html");

		hitCount++;
		PrintWriter out = response.getWriter();

		out.println(hitCount);
	}
}
