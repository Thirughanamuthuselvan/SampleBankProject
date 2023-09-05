package com.tms;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
	public static Connection con=null;
	static {
		try {
			Class.forName("org.postgresql.Driver");
			con=DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres","postgres","Tms@2002");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

	public static Connection getCon() {
		return con;
	}
}