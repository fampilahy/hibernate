<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<div>Take fun</div>

	<c:out value="balise out in jsp" />

	<c:choose>
		<c:when test="${empty name }">
			<form method="get" action="test">
				<label for="name">Name </label><input type="text" name="name"
					id="name" /> <input type="submit" value="Send" />
			</form>
		</c:when>
		<c:otherwise>
			<c:out value="${ param.name }" />
		</c:otherwise>
	</c:choose>
	aaaa
	<c:out value="${connec }" />
	<%
		out.println("ahhahhaha");
	%>


	<c:choose>
		<c:when test="${empty errors }">
			<c:out value="ERROR" />
		</c:when>
		<c:otherwise>
			<c:out value="NO" />
		</c:otherwise>
	</c:choose>



<c:forEach var="type"  items="${errors }">

<c:out value="${type }"></c:out>

</c:forEach>








</body>
</html>