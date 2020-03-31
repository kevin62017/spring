<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Form</title>
<style type="text/css">
.errMsg {
	color: red;
}
</style>
</head>
<body>
	<form action="<c:url value='/hello.Controller'></c:url>" method="post">
		<table>
			<tr>
				<td>Name:</td>
				<td><input type="text" name="name"></td>
				<td class="errMsg">${errors.name}</td>
			</tr>
			<tr>
				<td><input type="submit" value="Send"></td>
			</tr>
		</table>
	</form>
</body>
</html>