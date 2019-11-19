<%@page import="java.util.List,java.util.ArrayList,java.util.Arrays"%>

<html>
<body>
	<h2>Hello World!</h2>
	<%
		List<String> countries = Arrays.asList("India", "USA", "China");
		out.println(countries);
		
	%>
</body>
</html>
