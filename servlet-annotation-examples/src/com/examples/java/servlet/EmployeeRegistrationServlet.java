package com.examples.java.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Employee Registration Servlet
 */
@WebServlet(value = "/register.do", initParams = {
		@WebInitParam(name="message1", value="Registration1"),
		@WebInitParam(name="message2", value="Registration2")})
public class EmployeeRegistrationServlet extends HttpServlet {
	
	/* 
	 * Called when getting loaded into web container
	 * We can specify the initialization logic here.
	 */
	public void init(ServletConfig config)
	{
		System.out.println("EmployeeRegistration Servlet Initialized...");
		
		// Display Servlet Config parameters
		//ServletConfig config = getServletConfig();
		System.out.println("Servlet Config Parameters.....");
		Enumeration<String> paramNames = config.getInitParameterNames();
		while(paramNames.hasMoreElements())
		{
			String paramName = paramNames.nextElement();
			System.out.println(paramName + ": " + config.getInitParameter(paramName));
		}
		
		// Display Servlet context parameters		
		ServletContext context = config.getServletContext();
		System.out.println("Servlet Context Parameters.....");
		Enumeration<String> ctxParamNames = context.getInitParameterNames();
		while(ctxParamNames.hasMoreElements())
		{
			String ctxParamName = ctxParamNames.nextElement();
			System.out.println(ctxParamName + ": " + context.getInitParameter(ctxParamName));
		}		
	}
	
	public void doGet(HttpServletRequest request,  HttpServletResponse response) throws IOException
	{
		System.out.println("Calling GET method");
		this.doPost(request, response);
	}
	
	/*
	 * Called for every HTTP request
	 */
	public void doPost(HttpServletRequest request,  HttpServletResponse response) throws IOException
	{
		
		HttpSession session = request.getSession();
		
		// Add custom cookie
		Cookie custom = new Cookie("name","test");
		custom.setMaxAge(300);
		
		response.addCookie(custom);
		
		System.out.println("Session ID: " + session.getId());
		
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		
		session.setAttribute("userName", userName);
		session.setAttribute("password", password);

		response.setContentType("text/html");
				
		// Output stream to write data into HTTP response
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE html>");
		out.println("<html><body>");
		out.print("<p>Registration Successful.</p>");
		out.println("<p>UserName: " + userName + "</p>");
		out.println("<a href='index.html'>home</a>");
		out.println("</body></html>");
	}
	
	/* 
	 * Called when getting unloaded from web container
	 * We can specify the clean up logic here.
	 */	
	public void destroy()
	{
		System.out.println("EmployeeRegistration Servlet Destroyed...");		
	}

}