<%@ page import="java.util.ArrayList" %>
<%@ page import="entity.subject.SubjectInfor" %><%--
  Created by IntelliJ IDEA.
  User: Hp
  Date: 6/1/2019
  Time: 11:52 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<%
    ArrayList<SubjectInfor> arrayList =(ArrayList<SubjectInfor>) session.getAttribute("list_subject");
%>
<body>
<table>
    <tr>
        <td>Id</td>
        <td>Name</td>
        <td>Status</td>
    </tr>
    <%
        for (SubjectInfor sj:
             arrayList) {
            %>
        <tr>
            <td>
                <%=sj.getId()%>
            </td>
            <td>
                <%=sj.getName()%>
            </td>
            <td>
                <%
                    String status;
                    if (sj.getStatus() == 0){
                        status = "COURSE";
                    }else if (sj.getStatus() == 1){
                        status = "USING";
                    }else{
                        status = "";
                    }
                %>
                <%=status%>
            </td>
            <td>
                <form action="/subject/edit" method="get">
                    <input type="hidden" name="subject_id" value="<%=sj.getId()%>">
                    <input type="submit"  value="Edit">
                </form>

                <%
                    if (sj.getStatus() != 0){
                        %>
                <form action="/subject/delete" method="get">
                    <input type="hidden" name="subject_id" value="<%=sj.getId()%>">
                    <input type="submit"  value="Delete">
                </form>
                <%
                    }
                %>

            </td>
        </tr>
    <%
        }
    %>
</table>
</body>
</html>
