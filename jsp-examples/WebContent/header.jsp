<%@page import="java.util.Arrays"%>
<%@page import="java.util.List"%>

<title>Include Directive Demo</title>

<%
	List<String> countries = Arrays.asList("India", "USA", "China");
	out.println(countries);
%>
