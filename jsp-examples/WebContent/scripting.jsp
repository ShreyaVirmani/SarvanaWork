<html>
<body>
	<h2>Hello World!</h2>
	<!-- Declaration tag -->
	<%!
		int a = 10;
		int b = 20;
	%>
	<!-- Scriptlet tag -->
	<p> Scriptlet: <% out.println(a+b); %> </p>
	
	<!--  Expressoin tag -->
	<p> Expression: <%= (a+b)*10/b %> </p>
</body>
</html>
