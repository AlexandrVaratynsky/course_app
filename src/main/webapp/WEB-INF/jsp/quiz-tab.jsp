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

<form:form id="meet" action="/quiz" modelAttribute="participants">


    <table>
        <tr>
            <th> Firstname</th>
            <th> Lastname</th>
            <th> Active</th>
            <th> Team</th>
            <th> Bonus</th>
            <th> Q</th>
            <th> A</th>

        </tr>
        <c:forEach var="stud" items="${participants}">
            <H3>${'active-'.concat(stud.participantID)}</H3>
            <c:if test="${'active-'.concat(stud.participantID) eq 'checked'}">
                <tr>
                    <td>${stud.firstName}</td>
                    <td>${stud.lastName}</td>


                    <td>

                        <input type="checkbox" disabled  value="true" name=active-${stud.participantID} >
                        <input type='hidden' value="0" name=active-${stud.participantID}>
                    </td>

                    <td>
                        <input type="number" readonly disabled value=${stud.team.teamNumber} min=0 max=50
                               name=team-${stud.team.teamID}>

                    </td>
                    <td>
                        <input type="number" value=0 step="0.1" min=0 max=5 name=bonus-${stat.bonusScore}>

                    </td>

                    <td>
                        <input type="number" value=0 min=0 max=5 step="0.1" name=answer-${stat.answerScore}>

                    </td>
                    <td>
                        <input type="number" value=0 min=0 max=5 step="0.1" name=question-${stat.questionScore}>

                    </td>


                </tr>
            </c:if>
        </c:forEach>


    </table>
    <br>
    <br>

    <c:if test="${quizIsActive eq 'false'}">
        <input type="hidden" name="courseID" value="${param.get("courseID")}">
        <input type="text" name="isActive" value="true">
        <input type="submit" value="falseNEXT">

    </c:if>

    <c:if test="${quizIsActive eq 'true'}">
        <input type="hidden" name="courseID" value="${param.get("courseID")}">
        <input type="text" name="isActive" value="true">
        <input type="submit" value="trueNEXT"
               onclick="window.location.href = 'forward:/quiz'">

    </c:if>


</form:form>
<form name="save" action="open" method="post">
    <input type="hidden" name="courseID" value="${param.get("courseID")}">
    <input type="submit" value="FINISH">
</form>


<%--<c:set var="time" value='jsp to java'/>--%>
<%--<% String date_input =(pageContext.getAttribute("time", PageContext.PAGE_SCOPE)).toString(); %>--%>

<%--<% String javaVal = "java to jsp";%>--%>
<%--${javaVal}--%>

<%--<c:out value="${date_input}"/>--%>
<c:forEach var="p" items="${participants}">
    <input type="text" value=${p}><br>
</c:forEach>


</body>
</html>
