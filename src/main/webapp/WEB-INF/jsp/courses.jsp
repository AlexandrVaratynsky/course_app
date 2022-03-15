<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Courses</title>
</head>
<body>
<H2>Courses</H2>

<c:if test="${not empty all}">
    <table>

        <c:forEach var="course" items="${all}">

            <c:url var="openButton" value="/open">
                <c:param name="courseID" value="${course.courseID}"/>
            </c:url>

            <c:url var="deleteButton" value="/delete">
                <c:param name="courseID" value="${course.courseID}"/>
            </c:url>
            <tr>
                <td>${course.name}</td>
                <td>${course.startDate}</td>
                    <%--            <td>${course.active}</td>--%>
                <td>
                    <input type="button" value="OPEN"
                           onclick="window.location.href = '${openButton}'">

                    <input type="button" value="Delete"
                           onclick="window.location.href = '${deleteButton}'">
                </td>
            </tr>
        </c:forEach>

    </table>
</c:if>
<c:if test="${empty all}">
    <br>no courses
    <br>
</c:if>
<br>
<br>
<input type="button" value="Add course"
       onclick="window.location.href = '/add-course'">

</body>
</html>
