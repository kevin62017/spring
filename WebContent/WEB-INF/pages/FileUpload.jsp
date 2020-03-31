<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>FileUpload</title>
</head>
<body>
<form action="<c:url value='/uploadFile.controller'></c:url>" method="post" enctype="multipart/form-data">
    Please Select Image to upload:<br/>
    <input type="file" name="myFiles" multiple="multiple"/>
    <input type="submit" value="Upload"/>
</form>
</body>
</html>