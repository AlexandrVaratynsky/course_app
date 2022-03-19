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




<form:form id="meeting" action="/quiz" modelAttribute="meetingData">


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
        <c:forEach var="stud" items="${meetingData.qParticipants}">

            <tr>
                <td>${stud.participant.firstName}</td>
                <td>${stud.participant.lastName}</td>


                <td>

                    <input type="checkbox"  checked value="checked" name=active-${stud.participant.participantID} >
<%--                    <input type='hidden' value="false" name=${stud.participant.participantID}>--%>
                </td>

                <td>
                    <input type="number" disabled readonly value=${stud.participant.team.teamNumber} min=0 max=50
                           name=team-${stud.participant.participantID}>

                </td>
                <td>
                    <input type="number" disabled value="" step="0.1" min=0 max=5 name=bonus-${stud.participant.participantID}>

                </td>

                <td>
                    <input type="number" disabled value="" min=0 max=5 step="0.1" name=question-${stud.participant.participantID}>

                </td>
                <td>
                    <input type="number" disabled value="" min=0 max=5 step="0.1" name=answer-${stud.participant.participantID}>

                </td>


            </tr>

        </c:forEach>


    </table>
    <br>
    <br>

<%--    <c:if test="${meetingData.isActive = false }">--%>
    <input type="hidden" name="courseID" value="${meetingData.courseID}">
<%--        <input type="text" name="isActive" value="true">--%>
        <input type="submit" value="START">

<%--    </c:if>--%>
    
    
    
    
    
</form:form>
<form name="save" action="open" method="post">
    <input type="hidden" name="courseID" value="${meetingData.courseID}">
    <input type="submit" value="FINISH">
</form>


<c:set var="time" value='*************'/>
<% String date_input =(pageContext.getAttribute("time", PageContext.PAGE_SCOPE)).toString(); %>
<%= date_input%>
<%--<c:out value="${date_input}"/>--%>
<c:forEach var="p" items="${param.values()}">
    <input type="text" value=${p}><br>
</c:forEach>


</body>
</html>
