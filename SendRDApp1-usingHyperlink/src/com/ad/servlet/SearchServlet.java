package com.ad.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/searchurl")
public class SearchServlet extends HttpServlet {

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	
		PrintWriter pw=null;
		String ss=null;
		pw=res.getWriter();
		res.setContentType("text/html");
		//read form data
		ss=req.getParameter("ss");
		pw.println("<br><a href='https://www.google.com/search?q="+ss+"'>Go to google</a>");
		
		//close stream
		pw.close();
	}

	
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	
		doGet(req, res);
	}

}





