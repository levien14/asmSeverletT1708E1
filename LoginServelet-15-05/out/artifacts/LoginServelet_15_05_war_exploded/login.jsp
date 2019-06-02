<%--
  Created by IntelliJ IDEA.
  User: Hp
  Date: 5/17/2019
  Time: 7:07 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" type="text/css" href="/css/login.css">

</head>
<body>

<div class="wrap-form-login">
    <div class="wrap-title">
        <h3 class="title">Login</h3>
    </div>
    <form action="/login" method="post">
        <div>
            Username : <input type="text" name="username">
        </div>
        <div>
            Password : <input type="password" name="password">
        </div>
        <input type="submit" value="Dang Nhap">
    </form>
</div>

</body>
</html>
