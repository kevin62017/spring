<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Happy Farm</title>
</head>
<body>
	<form action="<c:url value='/myfarmer.controller'></c:url>" method="post">
		<table>
			<tr>
				<td>Farmer Name:</td>
				<td><input type="text" name="myfarmer"></td>
			</tr>
			<tr>
				<td><input type="submit" value="Send"></td>
			</tr>
		</table>
	</form>
</body>
</html>