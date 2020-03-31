<%@ page language="java" contentType="text/html; charset=BIG5" pageEncoding="BIG5"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="BIG5">
<title>file upload</title>
</head>
<body>
<form action="<c:url value='/uploadFile.controller'></c:url>" method="post" enctype="multipart/form-data">
<h1>please upload your file</h1>
<input type="file" name="files" multiple="multiple">
<input type="submit" value="Upload">
</form>
</body>
</html>