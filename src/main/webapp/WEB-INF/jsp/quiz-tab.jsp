<%@ page import="com.andersen.course.app.quiz.QuizMeetingData" %>
<%@ page import="java.util.Map" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Quiz</title>
</head>
<body>
<H2>Quiz</H2>

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
            <c:set var="currentID" value="${''.concat(stud.participantID)}"/>
            <c:set var="currentID" value="${''.concat(stud.participantID)}"/>

            <tr>
                <td>${stud.firstName}</td>
                <td>${stud.lastName}</td>
                <td>
<%--                    checked true--%>
                    <c:if test="${param.containsKey(currentID)}">
                        <c:if test="${param.get(currentID).equals('checked')}">

                            <input type="checkbox" disabled checked value="checked" name=${stud.participantID}>
                            <input type='hidden' value="checked" name=${stud.participantID}>
                        </c:if>

                    </c:if>
<%--                    checked false--%>
                    <c:if test="${param.containsKey(currentID)}">
                        <c:if test="${not param.get(currentID).equals('checked')}">

                            <input type="checkbox" disabled value="" name=${stud.participantID}>
                            <input type='hidden' value="" name=${stud.participantID}>

                        </c:if>
                    </c:if>
<%--                    not checked--%>
                    <c:if test="${not param.containsKey(currentID)}">
                            <input type="checkbox" disabled value="" name=${stud.participantID}>
                            <input type='hidden' value="" name=${stud.participantID}>
                    </c:if>

                </td>

                <td>
                    <input type="number" readonly disabled value=${stud.team.teamNumber} min=0 max=50
                           name=team-${stud.team.teamID}>

                </td>
                <td>
                    <c:if test="${param.get(currentID).equals('checked')}">
                        <input type="number" value="${param.get('bonus-'.concat(currentID))}" step="0.1" min=0 max=5 name=bonus-${currentID}>
                    </c:if>
                    <c:if test="${not param.get(currentID).equals('checked')}">
                        <input type="number" disabled value="${param.get('bonus-'.concat(currentID))}" step="0.1" min=0 max=5 name=bonus-${currentID}>
                    </c:if>
                </td>
                <td>
                    <c:if test="${param.get(currentID).equals('checked')}">
                        <input type="number" value="${param.get('answer-'.concat(currentID))}" min=0 max=5 step="0.1" name=answer-${currentID}>
                    </c:if>
                    <c:if test="${not param.get(currentID).equals('checked')}">
                        <input type="number" disabled value="${param.get('answer-'.concat(currentID))}" min=0 max=5 step="0.1" name=answer-${currentID}>
                    </c:if>
                </td>
                <td>
                    <c:if test="${param.get(currentID).equals('checked')}">
                        <input type="number" value="${param.get('answer-'.concat(currentID))}" min=0 max=5 step="0.1" name=question-${currentID}>
                    </c:if>
                    <c:if test="${not param.get(currentID).equals('checked')}">
                        <input type="number" disabled value="${param.get('answer-'.concat(currentID))}" min=0 max=5 step="0.1"
                               name=question-${currentID}>
                    </c:if>
                </td>
            </tr>

        </c:forEach>


    </table>
    <br>
    <br>

    <c:if test="${quizIsActive eq 'false'}">
        <input type="hidden" name="courseID" value="${param.get("courseID")}">
        <input type="hidden" name="isActive" value="true">
        <input type="submit" value="falseNEXT">

    </c:if>

    <c:if test="${quizIsActive eq 'true'}">
        <input type="hidden" name="courseID" value="${param.get("courseID")}">
        <input type="hidden" name="isActive" value="true">
        <input type="submit" value="NEXT"
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
<c:forEach var="p" items="pre">

    <c:out value="${p}"/>---<br>
</c:forEach>

<%--<c:forEach var="p" items="${param.values()}">--%>

<%--    <c:out value="${p}"/>---<c:out value="${param.get(p)}"/><br>--%>
<%--</c:forEach>--%>

<c:forEach var="p" items="${param}">
    <c:out value="${p.key}"/>
    <c:forEach var="a" items="${p.value}">
        ---<c:out value="${a}"/>
    </c:forEach><br>
</c:forEach>


</body>
</html>
