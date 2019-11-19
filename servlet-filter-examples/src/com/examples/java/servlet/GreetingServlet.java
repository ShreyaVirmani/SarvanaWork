package com.examples.java.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class GreetingServlet extends HttpServlet {
	
	public void init()
	{
		System.out.println("Greeting Servlet Initialized...");
	}
	
	public void doGet(HttpServletRequest request,  HttpServletResponse response) throws IOException
	{
		this.doPost(request, response);
	}	
	
	public void doPost(HttpServletRequest request,  HttpServletResponse response) throws IOException
	{
		response.setContentType("text/html");

		// Output stream to write data into HTTP response
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE html>");
		out.println("<html><body>");
		out.println("<h1>Hello World Servlet</h1>");
		out.println("<h2>Current Date: " + LocalDateTime.now()+"</h2>");
		out.println("</body></html>");		
	}	
	
	public void destroy()
	{
		System.out.println("Greeting Servlet Destroyed...");
	}
}
