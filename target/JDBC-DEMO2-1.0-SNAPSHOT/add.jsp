<%-- 
    Document   : add
    Created on : Mar 23, 2023, 2:50:37 AM
    Author     : ACER
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>ADD NEW a category</h1>
        <h3 style="color:red">${error}</h3>
        <form action="add" method="get">
            enter ID: <input type="number" name="id" /></br>
            enter name: <input type="text" name="name" /></br>
            enter describe: <input type="text" name="describe" /></br>
            <input type="submit" value="SAVE" />

        </form>
</body>
</html>
