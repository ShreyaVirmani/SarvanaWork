package com.examples.java.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Employee Registration Servlet
 */
@WebServlet("/authenticate.do")
public class EmployeeAuthenticateServlet extends HttpServlet {
	
	/* 
	 * Called when getting loaded into web container
	 * We can specify the initialization logic here.
	 */
	public void init()
	{
		System.out.println("EmployeeAuthenticate Servlet Initialized..");
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
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		
		Cookie[] cookies = request.getCookies();
		
		for(Cookie cookie: cookies) {
			System.out.println(cookie.getName() + " " + cookie.getValue());
		}
		
		HttpSession session = request.getSession();
		
		System.out.println("Session ID: " + session.getId());
		
		String userName1 = (String) session.getAttribute("userName");
		String password1 = (String) session.getAttribute("password");

		response.setContentType("text/html");
		
		// Output stream to write data into HTTP response
		PrintWriter out = response.getWriter();
		
		out.println("<!DOCTYPE html>");
		out.println("<html><body>");		
		// Authentication check
		if(userName.equals(userName1) && password.equals(password1))
		{

			out.print("<p>Login Successful.</p>");
			
			// Forwards the request to employee list servlet
//			 RequestDispatcher rd = request.getRequestDispatcher("home.do");
//			 rd.forward(request, response);
			
			// OPTION #1: Redirecting to employee management home page
			//response.sendRedirect("http://localhost:8080/servlet-annotation-examples/home.html");	
			
			// OPTION #2: Redirecting to employee management home page
			// response.setStatus(response.SC_MOVED_TEMPORARILY);
			// response.setHeader("Location", "http://localhost:8080/servlet-annotation-examples/home.html");
		}
		else {
			out.print("<p>Login Failed.</p>");	
			
			response.sendError(500, "Login Failed");

		}
		out.println("</body></html>");		
	}
	
	/* 
	 * Called when getting unloaded from web container
	 * We can specify the clean up logic here.
	 */	
	public void destroy()
	{
		System.out.println("EmployeeAuthenticate Servlet Destroyed...");		
	}

}
