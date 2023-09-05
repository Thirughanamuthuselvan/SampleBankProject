package com.tms;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class GetInfo extends HttpServlet{
	public void service(HttpServletRequest req,HttpServletResponse res) throws IOException {
		res.setContentType("html");
		int id=Integer.parseInt(req.getParameter("id"));
		PrintWriter out=res.getWriter(); 
		try {
			Class.forName("org.postgresql.Driver");
			Connection con=DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres","postgres","Tms@2002");
			Statement stmt=con.createStatement();
			ResultSet rs=stmt.executeQuery("select * from bank_db");
			while(rs.next()) {
				if(id==rs.getInt(1)) {		
					out.println("\tAccountId:"+rs.getString(1));
					out.println("\tName:"+rs.getString(2));
					out.println("\tPhone Number:"+rs.getString(3));
					out.println("\tAccount Type:"+rs.getString(4));
				}
			}
			} catch (SQLException | ClassNotFoundException e) {
				e.printStackTrace();
			}
	}
}
