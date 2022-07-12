
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
<h1>Create A Project</h1>
 <form:form action="/project/new" method="post" modelAttribute="newProject">
    <div>
		<form:label path="title"> Project Title: </form:label><br />
		<form:input path="title"/>
		<form:errors path="title"/>
	</div>
    <div>
		<form:label path="description">Project Description: </form:label><br />
		<form:textarea rows="3" path="description"/>
		<form:errors path="description" />
	</div> 
	<div>
		<form:label path="dueDate">Due Date: </form:label><br />
		<form:input path="dueDate" type="date"/>
		<form:errors path="dueDate" />
		
	</div>

	
    
    <input type="submit" value="Submit"/>
    <a href="/dashboard">Cancel</a>
</form:form> 

</body>
</html>