<%@ page errorPage="error.jsp" %>
<html>
<body>
	<h2>Hello World!</h2>
	<%! String empName = "Saravana"; %>
	<jsp:useBean id="emp" class="com.examples.servlet.jsp.bean.EmployeeBean" scope="session"/>
	
	<jsp:setProperty name="emp" property="name" value="<%=empName%>"/>
	<%--Sets all property values mapping incoming request parameters --%>
	<jsp:setProperty name="emp" property="*"/>
	
	<jsp:getProperty name="emp" property="name"/>
	<jsp:getProperty name="emp" property="age"/>
</body>
</html>
