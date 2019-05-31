<%@ page import="entity.Student" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.util.Calendar" %><%--
  Created by IntelliJ IDEA.
  User: Hp
  Date: 5/17/2019
  Time: 7:00 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Title</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

  <!-- Bootstrap CSS -->
  <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

  <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
  <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
</head>

<%

  ArrayList<Student> listStudent =(ArrayList<Student>) session.getAttribute("ListStudent") ;
  if (listStudent == null || listStudent.size() == 0){
    listStudent = new ArrayList<>();
  }
%>
<body>

<h1>List of Student</h1>

<table class="table table-sm" width="80%" >

  <thead>
  <tr>
    <th scope="col">RollNumber |</th>
    <th scope="col">Fullname |</th>
    <th scope="col">Email |</th>
    <th scope="col">Gender |</th>
    <th scope="col">Status |</th>
    <th scope="col"># |</th>
  </tr>
  </thead>
  <tbody>

  <%
    for (Student st:
            listStudent) {%>
  <tr>
    <th scope="row">
      <%=st.getRollnumber()%>
    </th>
    <th scope="row">
      <%=st.getFullname()%>
    </th>
    <th scope="row">
      <%
        String gender;
        if (st.getGender() == 0){
          gender = "Male";
        }else if (st.getGender() == 1){
          gender = "FeMale";
        }else{
          gender = "other";
        }
      %>
      <%=gender%>
    </th>
    <th scope="row">
      <%=st.getEmail()%>
    </th>
    <th scope="row">
      <%
        String status;
        if (st.getStatus() == 0){
          status = "I quit school";
        }else if (st.getStatus() == 1){
          status = "Studying";
        }else{
            status = "Please save";
        }
      %>
      <%=status%>
    </th>
    <th scope="row">
      <span>
      <form action="/edit" method="get">
        <input type="hidden" value="<%=st.getRollnumber()%>" name="editRollNumber">
        <input type="submit" value="Edit">
      </form>

      <form action="/details" method="get">
        <input type="hidden" value="<%=st.getRollnumber()%>" name="detailsRollNumber">
        <input type="submit" value="Details">
      </form>
        <%
            if (st.getStatus() != 0){
                %>
        <form action="/delete" method="get" >
            <input type="hidden" value="<%=st.getRollnumber()%>" name="deleteRollNumber">
            <input type="submit" value="Delete">
        </form>
        <%
            }
        %>
      </span>
    </th>


  </tr>
  <%}
  %>

</table>

</body>
</html>
