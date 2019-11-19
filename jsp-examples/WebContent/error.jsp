<%@ page isErrorPage="true"%>
<html>
<body>
	<h2>Error Occured</h2>
	<p> <% exception.printStackTrace(response.getWriter()); %> </p>
</body>
</html>
