package com.examples.java.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Employee Home Servlet
 */
@WebServlet("/home.do")
public class EmployeeHomeServlet extends HttpServlet {
	
	/* 
	 * Called when getting loaded into web container
	 * We can specify the initialization logic here.
	 */
	public void init()
	{
		System.out.println("EmployeeHome Servlet Initialized...");
	}
	
	public void doGet(HttpServletRequest request,  HttpServletResponse response) throws IOException, ServletException
	{
		this.doPost(request, response);
	}
	
	/*
	 * Called for every HTTP request
	 */
	public void doPost(HttpServletRequest request,  HttpServletResponse response) throws IOException, ServletException
	{
		HttpSession session = request.getSession();
		
		String userName1 = (String) session.getAttribute("userName");

		response.setContentType("text/html");
		
		// Output stream to write data into HTTP response
		PrintWriter out = response.getWriter();
		
		out.println("<!DOCTYPE html>");
		out.println("<html><body>");		
		out.println("<h1>Employee Landing Page</h1>");
		out.println("</body></html>");		
	}
	
	/* 
	 * Called when getting unloaded from web container
	 * We can specify the clean up logic here.
	 */	
	public void destroy()
	{
		System.out.println("EmployeeHome Servlet Destroyed...");		
	}

}