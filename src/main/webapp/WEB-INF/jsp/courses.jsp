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

            <tr>
                <td>${course.name}</td>

                <td>${course.startDate}</td>

                <td>
                    <form name="f${course.courseID}" action="open" method="post">
                        <input type="hidden" name="courseID" value="${course.courseID}">
                        <input type="hidden" name="${course_data.courseID}" value="${course.courseID}">
                        <input type="submit" value="OPEN">
                    </form>
                </td>

                <td>
                    <form name="d${course.courseID}" action="delete" method="post">
                        <input type="hidden" name="courseID" value="${course.courseID}">
                        <input type="submit" value="DELETE">
                    </form>
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
