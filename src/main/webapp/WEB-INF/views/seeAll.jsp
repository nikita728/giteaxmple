  <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
   <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
  
<h1>Employees List</h1>  
<table border="2" width="70%" cellpadding="2">  
<tr><th>Name</th><th>LastName</th><th>Departement</th></tr>  
   <c:forEach var="emp" items="${list}">   
   <tr>  
   <td>${emp.firstName}</td>  
   <td>${emp.lastName}</td>  
   <td>${emp.departement}</td>  
   
   </c:forEach>  
   </table>  
   <br/>  
    