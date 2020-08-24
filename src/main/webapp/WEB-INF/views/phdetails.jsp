<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<title>Phone Details</title>
</head>
<body><center>
<h1>Phone Details </h1>
id is <c:out value="${phone.id}"  />
<br>
storage is <c:out value="${phone.storageMemory}"  />
</center>
<br>
</body>
</html>