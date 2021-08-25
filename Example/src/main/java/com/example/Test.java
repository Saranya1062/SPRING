package com.example;

import java.sql.*;

public class Test {
    public static void main(String[] args) throws Exception {
        System.out.println("HelloWorld!");
        invokeDB();
    }

    public static void invokeDB() throws Exception {
        Connection conn = null;
        ResultSet rset = null;
        Statement stmt = null;
        try {
            Class.forName("org.postgresql.Driver");
            conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/emp", "postgres", "Saran@10");
            stmt = conn.createStatement();
            rset = stmt.executeQuery("SELECT * from employee");
            while (rset.next()) {
                String num=rset.getString("eno");
                String name=rset.getString("ename");

                System.out.println("Empno-" +num+" | "+"Ename-"+name);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            rset.close();
            stmt.close();
            conn.close();
        }
    }
}
