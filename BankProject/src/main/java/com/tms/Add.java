package com.tms;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Add extends HttpServlet{
	public void service(HttpServletRequest req,HttpServletResponse res) throws IOException {
		String name=req.getParameter("uname");
		String phone=req.getParameter("phne");
		String accountType=req.getParameter("accType");
	
		try {
			Class.forName("org.postgresql.Driver");
			Connection con=DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres","postgres","Tms@2002");
			PreparedStatement stmt=con.prepareStatement("insert into bank_db (uname,phone_no,acctype) values (?,?,?);");
			stmt.setString(1, name);
			stmt.setString(2, phone);
			stmt.setString(3, accountType);
			stmt.executeUpdate();
			PrintWriter out=res.getWriter(); 
			out.print("Account Details are added successfully..");
			res.sendRedirect("index.jsp");

		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}
