<%@ page import="entity.student.Student" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: Hp
  Date: 5/28/2019
  Time: 9:24 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<%

    Student student =(Student) request.getAttribute("detailsStudentInfor");
    if (student == null){
        student = new Student();
    }

    ArrayList<Integer> valueIntStatus = new ArrayList<>();
    valueIntStatus.add(1);
    valueIntStatus.add(2);
    valueIntStatus.add(0);

%>

<body>
<h1> Details </h1>
<div>

        <div>
            RollNumber : <%=student.getRollnumber()%>

        </div>
        <div>
            FullName : <%=student.getFullname()%>
        </div>
        <div>

            Email : <%=student.getEmail()%>
        </div>
        <div>
            Date of Birth : <%=student.getDob()%>
        </div>
        <div>
            PhoneNumber :<%=student.getPhonenumber()%>
        </div>
        <div>
            idCard : <%=student.getIdCard()%>
        </div>
        <div>
            Address : <%=student.getAddress()%>
        </div>
        <div>

            <%
                String gender;
                if (student.getGender() == 0){
                    gender = "Male";
                }else if (student.getGender() == 1){
                    gender = "FeMale";
                }else{
                    gender = "other";
                }
            %>
            Gender : <%=gender%>

        </div>
        <div>
            <%
                String status;
                if (student.getStatus() == 0){
                    status = "I quit school";
                }else if (student.getStatus() ==1){
                    status = "Studying";
                }else {
                    status = "Please save";
                }

            %>
            Status : <%=status%>

        </div>
        Medium Score : <%=student.getMediumScore()%>
    <div>
        <a href="/index.jsp">back to list .</a>
    </div>



</div>



</body>
</html>
