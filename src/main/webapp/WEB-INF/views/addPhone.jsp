<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<title>Phone Registration</title>
</head>
<body>

<h1>Phone Registration submits get request</h1>

<form method="get" action="/processAddPhone">

<div>

<label>Name</label>
<input type="text"  name="phonename">

</div>
<div>

<label>storageMemory</label>
<input type="text"  name="storageMemory">

</div>

<input type="submit" value="Create Phone">

</form>

</body>
</html>