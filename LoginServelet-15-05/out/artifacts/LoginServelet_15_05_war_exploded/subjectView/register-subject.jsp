<%--
  Created by IntelliJ IDEA.
  User: Hp
  Date: 6/1/2019
  Time: 11:22 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/subject/register" method="post">
    ID : <input type="text" name="subjectID">
    Name : <input type="text" name="subjectName">
    <select name="subjectStatus">
        <option value="0">Course</option>
        <option value="1">Using</option>
    </select>
     <input type="submit" name="Register">
</form>

</body>
</html>
