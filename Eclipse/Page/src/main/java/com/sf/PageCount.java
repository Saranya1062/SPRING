package com.sf;

import java.io.*;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;


public class PageCount extends HttpServlet{
  public void doGet(HttpServletRequest request, 
  HttpServletResponse response)
  throws ServletException, IOException {
  HttpSession session = request.getSession(true);
  response.setContentType("text/html");
  PrintWriter out = response.getWriter();
  Integer count =0;
  String head;
  if (session.isNew()) {
  head = "This is the New Session";
  } else {
  head = "This is the old Session";
  Integer oldcount =(Integer)session.getValue("count"); 
  if (oldcount != null) {
  count = new Integer(oldcount.intValue() + 1);
  }
  }
  session.putValue("count", count);
  out.println("<HTML><BODY BGCOLOR=\"#FDF5E6\">\n" +
  "<H2 ALIGN=\"CENTER\">" + head + "</H2>\n" + 
  "<TABLE BORDER=1 ALIGN=CENTER>\n"
  + "<TR BGCOLOR=\"#FFAD00\">\n" 
  +"  <TH>Information Type<TH>Session Count\n" 
  +"<TR>\n" +" <TD>Total Session Accesses\n" +
  "<TD>" + count + "\n" +
  "</TABLE>\n" 
  +"</BODY></HTML>" );
  }
}