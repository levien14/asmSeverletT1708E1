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
</head>
<body>
<h1>
    Register
</h1>
<div>
    <form action="/register" method="post">
        <div>
            RollNumber : <input type="text" name="rollnumber">
        </div>
        <div>
            Fullname : <input type="text" name="fullname">
        </div>
        <div>
            Email : <input type="email" name="email">
        </div>
        <div>
            DOB : <input type="date" name="dob">
        </div>
        <div>
            Id Card : <input type="text" name="idCard">
        </div>
        <div>
            PhoneNumber : <input type="text" name="phoneNumber">
        </div>
        <div>
            <select name="gender" >
                <option value="0">Male</option>
                <option value="1">Female</option>
                <option value="2">OTher</option>
            </select>

        </div>
        <div>
            <select name="status" >
                <option value="0">I quit school</option>
                <option value="1">STUDYING</option>
                <option value="2">PLEASE_SAVE</option>
            </select>

        </div>
          <div>
            Address : <input type="text" name="address">
        </div>



        <input type="submit" value="Dang Ki">
    </form>
</div>

</body>
</html>
