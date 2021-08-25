package com.sf;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

public class Test extends HttpServlet{
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
        Connection conn = null;
        ResultSet rset = null;
        Statement stmt = null;
        try {
            Class.forName("org.postgresql.Driver");
            conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/emp", "postgres", "Saran@10");
            stmt = conn.createStatement();
            rset = stmt.executeQuery("SELECT * from employee");
            PrintWriter out=res.getWriter();
            while (rset.next()) {
                String num=rset.getString("eno");
                String name=rset.getString("ename");

                out.println("Empno-" +num+" | "+"Ename-"+name);
                System.out.println("Empno-" +num+" | "+"Ename-"+name);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                rset.close();
                stmt.close();
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}