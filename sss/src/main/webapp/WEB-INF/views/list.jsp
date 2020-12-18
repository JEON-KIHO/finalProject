<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
   <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script src="http://code.jquery.com/jquery-3.1.1.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login</title>
</head>
<body>
   <h1>Login List</h1>
   <a href="insert">User Register</a>
   <c:if test="${adminId==null }">
   <button onClick="location.href='login'">Login</button>
   
   </c:if>
   <c:if test="${adminId!=null }">
   <button onClick="location.href='logOut'">LogOut</button>
   <span>welcome ${adminId }!!!!!!!</span>
   </c:if>
    <table border=1>
    <tr>
    <td width=100>ID</td>
    <td width=100>Name</td>
    </tr>
    <c:forEach items="${list }" var="vo">
    <tr>
    <td width=100><a href="read?adminId=${vo.adminId }">${vo.adminId }</a></td>
    <td width=100>${vo.companyName }</td>
    </tr>
    </c:forEach>
    </table>
</body>
</html>