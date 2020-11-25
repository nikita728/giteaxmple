<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Data Inserted</title>
</head>
<body>
<div align="center">
<table border="0">
<tr>
<td colspan="2" align="center"><h2>Data of name entered</h2></td>
</tr>
<tr>

</tr>
<tr>
<td>First Name:</td>
<td>${employee.firstName}</td>
</tr>
<tr>
<td>Last Name:</td>
<td>${employee.lastName}</td>
</tr>
<tr>
<td>Department:</td>
<td>${employee.departement}</td>
</tr>

</table>
</div>
</body>
</html>