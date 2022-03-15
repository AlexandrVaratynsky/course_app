<%@ page import="java.util.ArrayList" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Insert title here</title>
</head>
<body>
<h2>Show all students</h2>


<table>
    <tr>
        <th> Firstname</th>
        <th> Lastname</th>

        <th>
            <c:url var="addButton" value="/add-new-participant">
                <c:param name="courseID" value='${currentCourseID}'/>
            </c:url>
            <input type="button" value="ADD"
                   onclick="window.location.href = '${addButton}'">
        </th>
        <c:if test="${not empty Participants}">
        <br>
    </tr>

    <c:forEach var="stud" items="${Participants}">
        <c:url var="updateButton" value="/add-participant">
            <c:param name="participantID" value="${stud.participantID}"/>
            <c:param name="courseID" value="${stud.course.courseID}"/>
        </c:url>


        <c:url var="deleteButton" value="/delete-participant">
            <c:param name="participantID" value="${stud.participantID}"/>
        </c:url>

        <tr>
            <td>${stud.firstName}</td>
            <td>${stud.lastName}</td>


            <td>
                <input type="button" value="Update"
                       onclick="window.location.href = '${updateButton}'">

                <input type="button" value="Delete"
                       onclick="window.location.href = '${deleteButton}'">
            </td>
        </tr>

    </c:forEach>
    </c:if>
</table>

<c:if test="${empty Participants}">
    <br>no Participants
</c:if>

<br>
<br>
<input type="button" value="all courses"
       onclick="window.location.href = '/show-courses'">
<c:if test="${not empty Participants}">
    <input type="button" value="config teams"
           onclick="window.location.href = '/teamconfig?courseID=${param.get("courseID")}'">
    <input type="button" value="meeting"
           onclick="window.location.href = '/meeting?courseID=${param.get("courseID")}'">
</c:if>


</body>
</html>