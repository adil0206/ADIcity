package com.nt.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public final class ConnectionProvider {
	
	static Connection conn=null;
	private ConnectionProvider() {
		
	}
	public static Connection getConn()
	{
		try {
			if(conn==null) {
			Class.forName("com.mysql.jdbc.Driver");
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/adildb","admin","admin");
			return conn;
			}
			else
			return conn;
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return conn;
	}

}
