<%@ page import="entity.Student" %>
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

    Student student =(Student) request.getAttribute("editStudentInfor");
    if (student == null){
        student = new Student();
    }

    ArrayList<Integer> valueIntStatus = new ArrayList<>();
    valueIntStatus.add(1);
    valueIntStatus.add(2);
    valueIntStatus.add(0);

%>

<body>
<h1> Edit </h1>
<div>
    <form action="/edit" method="post">
        <div>
            <input type="hidden" value="<%=student.getRollnumber()%>" name="rollNumber">
        </div>
        <div>
            FullName <input type="text" name="fullname" value="<%=student.getFullname()%>">
        </div>
        <div>
            Email <input type="email" name="email" value="<%=student.getEmail()%>">
        </div>
        <div>
            Date of Birth <input type="date" name="dob" value="<%=student.getDob()%>">
        </div>
        <div>
            PhoneNumber <input type="text" name="phonenumber" value="<%=student.getPhonenumber()%>">
        </div>
        <div>
            idCard <input type="text" name="idcard" value="<%=student.getIdCard()%>">
        </div>
        <div>
            Address <input type="text" name="address" value="<%=student.getAddress()%>">
        </div>
        <div>
            <%
                String checkedRadioStatus = "";
                String valueStringRadioStatus = "";


                for (int value:
                        valueIntStatus) {
                    if (value == 1){
                        valueStringRadioStatus = "STUDYING";
                    }
                    if (value == 0){
                        valueStringRadioStatus = "I QUIT SCHOOL";
                    }
                    if (value == 2){
                        valueStringRadioStatus = "PLEASE SAVE";
                    }
                    if (value == student.getStatus()){
                        checkedRadioStatus = "checked";
                        System.out.println("VVCC" + value);
                    }else{
                        checkedRadioStatus = "";
                    }%>
            <input type="radio" name="status" value="<%=value%>" <%=checkedRadioStatus%>><%=valueStringRadioStatus%>- <%=value%>
            <%
                }
            %>
            <%=student.getStatus()%>

        </div>

        <div>
            <%=student.getGender()%>
            <%
                String checkedGender = "";
                String valueStringGender = "";

                for (int valuegender:
                        valueIntStatus) {
                    System.out.println(valuegender + "_");
                    if (valuegender == 0){
                        valueStringGender = "Male";
                    }
                    if (valuegender == 1){
                        valueStringGender = "FeMale";
                    }

                    if (valuegender == 2){
                        valueStringGender = "Other";
                    }
                    if (valuegender == student.getGender()){
                        checkedGender = "checked";
                    }else{
                        checkedGender = "";
                    }
                    System.out.println(valueStringGender + ":" + checkedGender);
            %>

            <input type="radio" name="gender" value="<%=valuegender%>" <%=checkedGender%> > <%=valueStringGender%>
            <%
                }
            %>

        </div>
        Medium Score <input type="text" name="medium" value="<%=student.getMediumScore()%>">
        <input type="submit" value="Edit">

    </form>
    <a href="/index.jsp">back to list .</a>

</div>



</body>
</html>
