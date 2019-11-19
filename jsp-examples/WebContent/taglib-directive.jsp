<%@page import="java.util.Arrays"%>
<%@page import="java.util.List"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<html>
<body>
	<h2>Taglib Directive Demo</h2>

	<%!List<String> countries = Arrays.asList("India", "UK", "China");%>

	<c:if test="${empty username}">
		<c:out value="testing" />
	</c:if>

	<c:set property="countries" var="countries" />

	<c:forEach var="i" begin="1" end="5">
         Item <c:out value="${i}" />
		<p>
	</c:forEach>

</body>
</html>
