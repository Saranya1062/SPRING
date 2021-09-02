//package com.sf;
//
//import java.io.PrintWriter;
//
//import jakarta.servlet.http.HttpServlet;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import jakarta.servlet.http.HttpSession;
//
//public class Display extends HttpServlet{
//	public void doGet(HttpServletRequest request, HttpServletResponse response){
//		  try{
//		      response.setContentType("text/html");
//		      PrintWriter out = response.getWriter();
//		      HttpSession session=request.getSession(false);
//		      List<Customer> list1= (List<Customer>) session.getAttribute("id");
//		      
//		      for(Customer li: list1) {
//		    	  int n1=li.getId();
//		    	  String n2=li.getName();
//		    	  int n3=li.getPrice();
//		    	  out.println("id  : "+n1+" Item Name : "+n2+" Price: "+n3+"\n");
//		    	  out.println(" ");
//  
//		      }
//		     out.close();
//		  }catch(Exception exp){
//		      System.out.println(exp);
//		   }
//	}
//}  
