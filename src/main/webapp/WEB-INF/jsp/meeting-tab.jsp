<%@ page import="com.andersen.course.app.quiz.QuizMeetingData" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Meeting</title>
</head>
<body>
<H2>Meeting</H2>


<form:form id="meeting" action="/quiz" modelAttribute="participants">


    <table>
        <tr>
            <th> Firstname</th>
            <th> Lastname</th>
            <th> Attend</th>
            <th> Team</th>
            <th> Bonus</th>
            <th> Q</th>
            <th> A</th>

        </tr>
        <c:forEach var="stud" items="${participants}">

            <tr>
                <td>${stud.firstName}</td>
                <td>${stud.lastName}</td>


                <td>

                    <input type="checkbox" checked="" value="checked" name=${stud.participantID}>
                    ${ranrom}
                </td>

                <td>
                    <input type="number" disabled readonly value=${stud.team.teamNumber} min=0 max=50
                           name=team-${stud.participantID}>
                </td>

                <td>
                    <input type="number" disabled value="" step="0.1" min=0 max=5 name=bonus-${stud.participantID}>
                    <input type="hidden" value="0" name="bonus-${stud.participantID}">
                </td>

                <td>
                    <input type="number" disabled value="" min=0 max=5 step="0.1" name=question-${stud.participantID}>
                    <input type="hidden" value="0" name="question-${stud.participantID}">
                </td>

                <td>
                    <input type="number" disabled value="" min=0 max=5 step="0.1" name=answer-${stud.participantID}>
                    <input type="hidden" value="0" name="answer-${stud.participantID}">
                </td>


            </tr>

        </c:forEach>


    </table>
    <br>
    <br>

    <input type="hidden" name="courseID" value="${param.get('courseID')}">
    <input type="hidden" name="meetingID" value="${meetingID}">
    <input type="submit" value="START">

</form:form>
<form name="save" action="open" method="post">
    <input type="hidden" name="courseID" value="${param.get('courseID')}">
    <input type="submit" value="<-- return">
</form>
</body>
</html>
