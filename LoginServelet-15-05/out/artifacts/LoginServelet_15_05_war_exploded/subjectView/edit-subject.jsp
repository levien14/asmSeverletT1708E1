<%@ page import="entity.subject.SubjectInfor" %><%--
  Created by IntelliJ IDEA.
  User: Hp
  Date: 6/2/2019
  Time: 1:43 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<%
    SubjectInfor subjectInfor = (SubjectInfor) session.getAttribute("subject_edit");

%>
<body>
<div>
    <h1>Edit subject</h1>
    <form action="/subject/edit" method="post">
        Id : <input type="hidden" name="id_subject" value="<%=subjectInfor.getId()%>">
        Name : <input type="text" name="name_subject" value="<%=subjectInfor.getName()%>">

        <input type="radio" name="status_subject" value="<%=SubjectInfor.SubjectStatus.COURSE.getValue()%>" checked>Course
        <input type="radio" name="status_subject" value="<%=SubjectInfor.SubjectStatus.USING.getValue()%>" >Using
        <input type="submit" value="Edit">
    </form>
</div>

</body>
</html>
