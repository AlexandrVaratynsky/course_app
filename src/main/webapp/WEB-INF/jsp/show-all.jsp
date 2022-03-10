<%@ page import="java.util.ArrayList" %>
<%@ page import="com.andersen.course.app.entity.Student" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
 <meta charset="ISO-8859-1">
 <title>Insert title here</title>
</head>
<body>
<h2>All students</h2>
<table>
    <tr>

        <th> Firstname </th>
        <th> Lastname </th>
        <th> subgroup </th>

    </tr>

    <c:forEach var="stud"  items="${allStudents}">

        <c:url var = "updateButton" value="/update">
            <c:param name="studId" value="${stud.id}"/>
        </c:url>

        <c:url var = "deleteButton" value="/delete">
            <c:param name="studId" value="${stud.id}"/>
        </c:url>
        <tr>
            <td>${stud.firstname}</td>
            <td>${stud.lastname}</td>
            <td>${stud.subgroup}</td>
            <td>
                <input type="button" value="Update"
                       onclick="window.location.href = '${updateButton}'">

                <input type="button" value="Delete"
                       onclick="window.location.href = '${deleteButton}'">
            </td>
        </tr>
    </c:forEach>

</table>
</body>
</html>