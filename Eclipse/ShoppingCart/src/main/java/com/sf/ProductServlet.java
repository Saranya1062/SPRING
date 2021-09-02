package com.sf;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class ProductServlet extends HttpServlet{
	
	public void service(HttpServletRequest req,HttpServletResponse res) throws IOException {
		 Connection con=null;
	     PreparedStatement prepare;
	     PrintWriter out=res.getWriter();
		  
	      String NUM="select * from items";
     
             try {
	 	        Class.forName("org.postgresql.Driver");
	 	        con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/cart","postgres","Saran@10");

	 	    	prepare = con.prepareStatement(NUM); 
	 	    	ResultSet result=prepare.executeQuery();  
	 	    	
	 	    out.println("<html>");
	 	    out.println("<head>");
	 	    out.println("</head>");
	 	    out.println("<body>");
	 	   	out.print("<table width=40% border=1>");  
			out.print("<caption>Result:</caption>"); 
			out.print("<tr>");
			out.print("<td>Number</td>");
			out.print("<td>Item</td>");
			out.print("<td>Price</td>");
			out.print("<td>Click</td>");
			out.print("</tr>");
			
			List<Customer> list=new ArrayList<Customer>();
			
			int i=1;
	 	    	
	 	    	while(result.next()) {
	 	    		int n1=result.getInt("id");
		 	    	String k1=result.getString("pname");
		            int k2=result.getInt("price");
		            String k="myCheck"+i;
		            
		            StringBuffer sa=new StringBuffer();
		            sa.append(k1);
		            sa.append("-");
		            sa.append(k2);
		            String m=sa.toString();
		          
	 	    		
	 	    		out.println("<tr><td>"+n1 +"</td><td>"+k1+"</td><td>"+k2+
	 	    				"</td><td>"+"<input type='checkbox' id=k name='pl' value="+m+">"+ "Add to cart"+ "</td></tr>");
	 	    		
	 	    		
	 	    		Customer c=new Customer();
	 	    		c.setId(n1);
	 	    		c.setName(k1);
	 	    		c.setPrice(n1);
	 	    		list.add(c);
	 	    		
	 	    		i++;

	 	    	}
	 	    	out.println("</table>");
	 	    	out.println("<button id='btn'>Submit</button> <br>");
	 	    	out.println("<script>");
	 	    	out.println("var arr;");
	 	    	out.println("document.getElementById('btn').onclick = function() { ");
	 	    	out.println("var markedCheckbox = document.getElementsByName('pl');");
	 	    	out.println("for (var checkbox of markedCheckbox) {");
	 	    	out.println("if (checkbox.checked)");
	 			out.println("document.body.append(checkbox.value+ '    ');");
	 	    	out.println("}");
	 	        out.println("}");
	 	        out.println("</script>");
	 	    	out.println("</body>");
	 	    	out.println("</html>");

             }catch(SQLException e) {
            	 e.printStackTrace();
             } catch (ClassNotFoundException e) {

				e.printStackTrace();
			}
	}
}
