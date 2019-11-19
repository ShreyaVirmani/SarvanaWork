package com.examples.java.servlet.filter;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class AuthFilter implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {

		System.out.println("AuthFilter Initialized...");
		Enumeration<String> filterParamNames = filterConfig.getInitParameterNames();
		System.out.println("Filter Paramenters...");
		while (filterParamNames.hasMoreElements()) {
			String filterParamName = filterParamNames.nextElement();
			System.out.println(filterParamName + ": " + filterConfig.getInitParameter(filterParamName));
		}
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		String userName = (String) request.getParameter("userName");

		if (userName != null) {
			System.out.println("Request from - " + userName);
			// delegate the control further
			chain.doFilter(request, response);
		} else {
			response.setContentType("text/html");
			PrintWriter out = response.getWriter();
			out.println("<!DOCTYPE html>");
			out.println("<html><body>");
			out.println("<h1>Invalid User. Please supply userName in the request.</h1>");
			out.println("</body></html>");
		}
	}

	@Override
	public void destroy() {
		System.out.println("AuthFilter Destroyed...");
	}

}
