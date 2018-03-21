<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Matching - List Reference</title>
</head>
<body>



	<c:choose>
		<c:when
			test="${not empty requestScope.initializedaoerror && not empty requestScope.listReferenceError}">
			<c:out value="${requestScope.initializedaoerror }" />
			<c:out value="${requestScope.listReferenceError }" />
		</c:when>
		<c:otherwise>
		<table>
		<tr>
				
				<th> Id </td>
				<th> Title </td>
				<th> Brand </td>
				<th> Model </td>
				<th> Action </td>
				</tr>
			<c:forEach items="${requestScope.references }" var="item">
				<tr>
				
				<td> <c:out value="${item.id }" /> </td>
				<td> <c:out value="${item.title }" /> </td>
				<td> <c:out value="${item.brand }" /> </td>
				<td> <c:out value="${item.model }" /> </td>
				<td> <form method="post" action="deletereference"> <input type="submit" value="delete"/> <input type="hidden" value="${item.id }" name="referenceid"/></form></td>
				</tr>
			</c:forEach>
			</table>
		</c:otherwise>
	</c:choose>


	<%-- <c:out value ="${requestScope.listReferenceError }"/> --%>

	<!-- private static final String LIST_REFERENCE_ERROR = "listReferenceError"; -->
	<!-- 	private static final String REFERENCES = "references"; -->
	<!-- 	public static final String DAOFACTORY_ERROR_KEY = "initializedaoerror"; -->
</body>
</html>