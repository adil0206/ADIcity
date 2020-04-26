package com.nt.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nt.jdbc.ConnectionProvider;

/**
 * Servlet implementation class Login
 */
public class Login extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PreparedStatement ps=null;
		ResultSet rs=null;
		RequestDispatcher rd=null;
		String email=null,pass=null;
		
			email=request.getParameter("email");
			pass=request.getParameter("pass");
		response.setContentType("text/html");
		
		
		Connection con=ConnectionProvider.getConn();
		try {
		
			 ps=con.prepareStatement("SELECT * FROM LOGIN WHERE email=? and pass=?");
			ps.setString(1, email);
			ps.setString(2, pass);
			rs=ps.executeQuery();
			
			if(rs.next()) {
				//response.sendRedirect("welcome.html ");
				rd=request.getRequestDispatcher("welcome.html");
				//response.getWriter().println("<h4 style='color:red'>Welcome to My Page</h4>");
				rd.forward(request, response);
			}
			else
			{
				rd=request.getRequestDispatcher("index.html");
				response.getWriter().println("<h4 style='color:red'>Invalid email and password</h4>");
				rd.include(request, response);
			}
				
		}
		catch(SQLException se) {
			se.printStackTrace();
		}
	}

}
