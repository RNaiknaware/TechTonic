<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>User Info</title>
</head>
<body>
						<table>
									<tr>
										<td> <a href="RegisterTechTalk.jsp"><button>Request For TechTalk</button></a> <td>
										<td> <a href="UserOprnController?op=3"><button>Log Out</button></a></td>									
									</tr>
						
									<tr>
									<td>Tid</td>  <td>Title</td>
									<td>Description</td>
									<td>Speaker</td>
									<td>Date</td>
									<td>Time</td>
									<td>Register</td>
									</tr>
							
							
									<tr>
											<c:forEach items="${sessionScope.userDataListObject}" var="item">
									<td>${item.tid}</td>
									<td>${item.title}</td>
									<td>${item.description}</td>
									<td>${item.speaker}</td>
									<td>${item.date}</td>
									<td>${item.time}</td>
									<td><a href="UserOprnController?op=1&tid=${item.tid}">Register</a></tr>
									</c:forEach>
									
									
									</tr>
						
						</table>
						

</body>
</html>