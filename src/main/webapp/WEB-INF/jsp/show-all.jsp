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
${course_data.courseID}

<table>
    <tr>
        <th> Firstname</th>
        <th> Lastname</th>

        <th>
            <form action="add-new-participant" method="post">
                <input type="hidden" name="courseID" value="${currentCourseID}">
                <input type="submit" value="ADD">
            </form>
        </th>
        <c:if test="${not empty Participants}">
        <br>
    </tr>

    <c:forEach var="stud" items="${Participants}">

        <tr>
            <td>${stud.firstName}</td>
            <td>${stud.lastName}</td>


            <td>
                <form id="conf" name="conf" action="add-participant" method="post">
                    <input type="hidden" name="courseID" value="${stud.course.courseID}">
                    <input type="hidden" name="participantID" value="${stud.participantID}">
                    <input type="submit" value="update">
                </form>
            </td>
            <td>
                <form name="del" action="delete-participant" method="post">
                    <input type="hidden" name="courseID" value="${stud.course.courseID}">
                    <input type="hidden" name="participantID" value="${stud.participantID}">
                    <input type="submit" value="delete">
                </form>

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
<c:if test="${not empty Participants}">

    <form name="conf" action="teamconfig" method="post">
        <input type="hidden" name="courseID" value="${currentCourseID}">
        <input type="submit" value="config teams">
    </form>

    <form name="courses" action="show-courses" method="get">
        <input type="hidden" name="courseID" value="${currentCourseID}">
        <input type="submit" value="all courses">
    </form>

    <form name="meeting" action="meeting" method="post">
        <input type="hidden" name="courseID" value="${currentCourseID}">
        <input type="submit" value="meeting">
    </form>

    <form name="meeting" action="stat" method="post">
        <input type="hidden" name="courseID" value="${currentCourseID}">
        <input type="submit" value="stat">
    </form>

</c:if>


</body>
</html>