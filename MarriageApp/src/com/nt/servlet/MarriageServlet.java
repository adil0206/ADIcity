package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Locale;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MarriageServlet extends HttpServlet {
	
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		System.out.println("MarriageServlet:: doPost(-,-)");
		PrintWriter pw=null;
		String name=null,gen=null;
		int age=0;
	   //get PrintWriter
		pw=res.getWriter();
		//set response content type
		res.setContentType("text/html");
		//read form data (req parameter values)
		name=req.getParameter("pname");
		age=Integer.parseInt(req.getParameter("page"));
		gen=req.getParameter("gender");
		
		//write b.logic /request processing logic
		if(gen.equalsIgnoreCase("M")) { //for Male
			if(age>=21) {
				pw.println("<h1 style='color:red'>Mr."+name+" u r elgible for marriage .. But think once </h1>");
			}
			else {
				pw.println("<h1>Mr."+name+" u r not elgible for marriage ..Be Happy </h1>");
			}
		}
		else {  //for Female
			if(age>=18) {
				pw.println("<h1>Miss."+name+" u r elgible for marriage .. But think Thrice </h1>");
			}
			else {
				pw.println("<h1>Miss."+name+" u r not elgible for marriage .. Be happy and keep others happy </h1>");
			}
		}
		
		//add home hyperlink as graphical hyperlink
		pw.println("<br><a href='input.html'><img src='home.png' width='50' height='50'/></a>");
		
		//close stream
		pw.close();
	}//doPost(-,-)
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		System.out.println("MarriageServlet.doGet()");
		PrintWriter pw=null;
		Locale locales[]=null;
		//get PrintWriter
		pw=res.getWriter();
		//set response content type
		res.setContentType("text/html");
		//get All the Locales of this world
		pw.println("<br> <h1>All Available Locales</h1>");
		locales=Locale.getAvailableLocales();
		for(Locale l:locales) {
			pw.println("<br><b>"+l.getDisplayLanguage()+"</b>");
		}
		
		//add home hyperlink as graphical hyperlink
		pw.println("<br><br><br><a href='input.html'><img src='home.png' width='50' height='50'/></a>");
		//close stream
		pw.close();
	}//doGet(-,-)
	
}//class
