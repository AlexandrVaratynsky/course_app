<%@ page import="java.util.ArrayList" %>
<%@ page import="com.andersen.course.app.entity.Team" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<H2>team config</H2>

<form:form action="/save-config" modelAttribute="Participants">


    <table>
        <tr>
            <th> Firstname</th>
            <th> Lastname</th>
            <th> Active</th>
            <th> Team</th>
            <th> Captain</th>
        </tr>
        <c:forEach var="stud" items="${Participants}">

            <tr>
                <td>${stud.firstName}</td>
                <td>${stud.lastName}</td>


                <td>

                    <input type="checkbox" checked value="1" name=active-${stud.participantID} >
                    <input type='hidden' value="0" name=active-${stud.participantID}>
                </td>
                <td>
                    <input type="number" value="${stud.team.teamNumber}" min=0 max=50 name=team-${stud.participantID}>

                </td>

                <td>
                    <input type="radio" value="1" name=captain-${stud.participantID}>
                    <input type='hidden' value="0" name=captain-${stud.participantID}>
                </td>
            </tr>

        </c:forEach>


    </table>
    <br>
    <br>
    <input type="hidden" name="courseID" value="${param.get("courseID")}">
    <input type="submit" value=" OK " formmethod="post">
</form:form>

</body>
</html>
