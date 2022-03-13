<%@ page import="java.util.ArrayList" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
 <meta charset="ISO-8859-1">
 <title>Insert title here</title>
</head>
<body>
<h2>ShowAll</h2>

<c:if test="${not empty Participants}">
<table>
    <tr>
        <th> Firstname </th>
        <th> Lastname </th>
    </tr>

    <c:forEach var="stud"  items="${Participants}">
<%--        <c:if test="${stud.course.courseID == currentCourseID}">--%>
        <c:url var = "updateButton" value="/add-participant">
            <c:param name="participantID" value="${stud.participantID}"/>
            <c:param name="courseID" value="${stud.course.courseID}"/>
        </c:url>

        <c:url var = "deleteButton" value="/delete-participant">
            <c:param name="participantID" value="${stud.participantID}"/>
        </c:url>
        <tr>
            <td>${stud.firstName}</td>
            <td>${stud.lastName}</td>
<%--            <td>${stud.active}</td>--%>
            <td>
                <input type="button" value="Update"
                       onclick="window.location.href = '${updateButton}'">

                <input type="button" value="Delete"
                       onclick="window.location.href = '${deleteButton}'">
            </td>
        </tr>
<%--        </c:if>--%>
    </c:forEach>

</table>
</c:if>
<c:if test="${empty Participants}">
    <br>no Participants
</c:if>
<c:url var = "addButton" value="/add-new-participant">
    <c:param name="courseID" value='${currentCourseID}'/>
</c:url>
<input type="button" value="ADD"
            onclick="window.location.href = '${addButton}'">
<input type="button" value="all courses"
       onclick="window.location.href = '/show-courses'">

</body>
</html>