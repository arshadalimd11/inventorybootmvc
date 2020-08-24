<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<title>Computer Registration</title>
</head>
<body>

<h1>Computer Registration submits get request</h1>

<form method="get" action="/processAddComputer">

<div>

<label>Name</label>
<input type="text"  name="computername">

</div>
<div>

<label>deskSpace</label>
<input type="text"  name="deskSpace">

</div>

<input type="submit" value="Create Computer">

</form>

</body>
</html>