package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nt.jdbc.ConnectionProvider;

/**
 * Servlet implementation class Registration
 */
public class Registration extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		String uname=null,upass=null,uemail=null,uphone=null;
				uname=request.getParameter("name");		 
				upass=request.getParameter("pass");		 
				uemail=request.getParameter("email"); 
				uphone=request.getParameter("uphone");
		
		//System.out.println(uname+" "+uemail+" "+upass+" "+uphone);
		//response.getWriter().println(ConnectionProvider.getConn());
		//Connection connection=ConnectionProvider.getConn();
		Connection con=ConnectionProvider.getConn();
		 try {
			 PreparedStatement ps=con.prepareStatement("insert into login values(?,?,?,?)");
			ps.setString(1, uname);
			ps.setString(2, upass);
			ps.setString(3, uemail);
			ps.setString(4, uphone);
			
			int i=ps.executeUpdate(); 
			if(i>0) {
				response.getWriter().println("Data Inserted");
				response.getWriter().println("<a href='index.html'>Go To</a>");
			}
			else
				response.getWriter().println("Data Not Inserted");
			
		} 
		 catch (Exception e) {
			e.printStackTrace();
		}
		 
	}//main

}//class
