<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Admin Info</title>
</head>
<body>

				
			<table>
							<tr>
							<td><a href="AddNewTechTalk.jsp"><button>Add TechTalk</button></a></td>
							<td><a href="AdminController?op=5"><button>View Requests For TechTalk</button></a></td>							
							<td><a href="AdminController?op=7"><button>Log Out</button></a></td>			
							</tr>

							<tr>
							<td>Tid</td>
							<td>Title</td>
							<td>Description</td>
							<td>Speaker</td>
							<td>Date</td>
							<td>Time</td>
							<td>Delete</td>
							<td>Edit</td>
							<td>Registered Employees</td>
							</tr>
							
							<tr>
							<c:forEach items="${sessionScope.adminDataListObject}" var="item">
							<td>${item.tid}</td>
							<td>${item.title}</td>
							<td>${item.description}</td>
							<td>${item.speaker}</td>
							<td>${item.date}</td>
							<td>${item.time}</td>
							 <td><a href="AdminController?op=1&deleteable=${item.tid}">Delete</a>
							 <td><a href="AdminController?op=2&editable=${item.tid}">Edit</a>
							 <td><a href="AdminController?op=6&tid=${item.tid}">Resgistered Users</a></tr>
							</c:forEach></td>
							</tr>
																	
			
			</table>
</body>
</html>