<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<!DOCTYPE html>
<html>
<head>
<title>Computer Details</title>
</head>
<body><center>
<h1>Computer Details </h1>
id is <c:out value="${computer.id}"  />
<br>
discSize is <c:out value="${computer.discSize}"  />
</center>
<br>

</body>
</html>