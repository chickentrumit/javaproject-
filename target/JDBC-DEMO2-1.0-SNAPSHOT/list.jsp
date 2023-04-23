<%-- 
    Document   : list
    Created on : Mar 23, 2023, 12:49:46 AM
    Author     : ACER
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        
    </head>
    <body >
        <h1 style="width: 100%; text-align: center; ">list of category</h1>
        <h3 style="width: 100%; text-align: center"><a href="add.jsp">ADD NEW</a></h3>
        <table border="1px" width="40%" style="margin: 0 auto;"> 
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Describe</th>
                <th>ACTION</th>
            </tr>
            <c:forEach items="${data}" var="c">
                <%--<c:set var="ID" value="${c.ID}"/>--%>
                       <tr>
                           <td>${c.id}</td>
                           <td>${c.name}</td>
                           <td>${c.describe}</td>
                           <td>
                               <a href="update?id=${c.id}">Update</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                               <a href="delete?id=${c.id}" onclick="return confirm('are U sure to delete category?')" >Delete</a>
                           </td>
                       </tr>
                
            </c:forEach>
        </table>
    </body>
</html>
