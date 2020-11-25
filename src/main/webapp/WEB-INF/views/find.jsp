<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h2>Find Employee details</h2>
<form:form method="post" modelAttribute="find" action="find">
<table>
<tr>
<td><form:label path="firstName">First Name</form:label></td>
<td><form:input path="firstName" /></td>
</tr>
<tr>
<td colspan="2"><input type="submit" value="submit">
</tr>
</table>
</form:form>
</body>
</html>