<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page isErrorPage="true" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>Welcome <c:out value="${user.firstName}" /></h1>

<a href="/project/new">New Project</a> 
All Projects
<table>
  <tr>
    <th>Project</th>
    <th>Team Lead</th>
    <th>Due Date</th> 
    <th>Actions</th>
  </tr>
<c:forEach  var="project" items="${ projects }">
  <tr>
    <td><a href="/projects/${project.id}"><c:out value="${project.title}"></c:out></a> </td> 

	<td><c:out value="${project.user.firstName}"></c:out></td>
	
		<td><fmt:formatDate value="${project.dueDate}" pattern="MMMM dd"/></td>
	<td>	<a href="/">Join Team</a></td>
	 
	
  </tr>
 </c:forEach>
</table>

<a href="/logout">Logout</a>

</body>
</html>