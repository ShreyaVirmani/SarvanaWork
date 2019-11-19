package com.examples.java.servlet.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.ServletRequestListener;
import javax.servlet.SessionCookieConfig;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionIdListener;
import javax.servlet.http.HttpSessionListener;

public class SessionListener implements HttpSessionListener {

	private static int currentUsers = 0;
	private static int totalUsers = 0;
	
	@Override
	public void sessionCreated(HttpSessionEvent se) {
		
		ServletContext context = se.getSession().getServletContext();
		//currentUsers = Integer.parseInt((String)context.getAttribute("currentUsers"));
		context.setAttribute("currentUsers", currentUsers++);
		context.setAttribute("totalUsers", totalUsers++);
		System.out.println("Session created: " + currentUsers);
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent se) {
		ServletContext context = se.getSession().getServletContext();
		//currentUsers = Integer.parseInt((String)context.getAttribute("currentUsers"));
		context.setAttribute("currentUsers", currentUsers--);
		System.out.println("Session destroyed: " + currentUsers );
	}
}
