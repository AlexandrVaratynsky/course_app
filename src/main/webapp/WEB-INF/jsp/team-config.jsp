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

step param ${requestScope.TeamsConfigStep}

<c:set var="nextURL" value="/save-config"/>
<c:set var="teamFieldDisable" value=""/>
<c:set var="captainFieldDisable" value=""/>
<c:if test="${TeamsConfigStep.equals('captains')}">
    <c:set var="teamFieldDisable" value="disabled"/>
<%--    <c:set var="nextURL" value="/open"/>--%>
</c:if>

<c:if test="${TeamsConfigStep.equals('teams')}">
    <c:set var="captainFieldDisable" value="disabled"/>
<%--    <c:set var="nextURL" value="/save-config"/>--%>
</c:if>

<form:form action="${nextURL}" modelAttribute="Participants">

    <table>
        <tr>
            <th> Firstname</th>
            <th> Lastname</th>
            <th> Active</th>
            <th> Team</th>
            <th> Captain</th>
        </tr>
        <c:forEach var="stud" items="${Participants}">
            <c:set var="captainCheck" value=""/>
            <c:set var="activeCheck" value=""/>
            <tr>
                <td>${stud.firstName}</td>
                <td>${stud.lastName}</td>


                <td>
                    <c:if test="${(stud.active.equals(true))}">
                        <c:set var="activeCheck" value="checked"/>
                    </c:if>

                    <input type="checkbox" ${activeCheck} value="1" name=active-${stud.participantID} ${teamFieldDisable}>
                    <input type='hidden' value="0" name=active-${stud.participantID} ${teamFieldDisable}>
                </td>
                <td>
                    <input type="number" value="${stud.team.teamNumber}" min=0 max=50
                           name=team-${stud.participantID} ${teamFieldDisable}>

                </td>

                <c:if test="${(stud.participantID.equals(stud.team.captain.participantID))}">
                    <c:set var="captainCheck" value="checked"/>
                </c:if>

                <td>
                    <input type="radio" value=${stud.participantID} name=captain-${stud.team.teamID}
                        ${captainFieldDisable} ${captainCheck}>
                </td>
            </tr>

        </c:forEach>


    </table>

    <br><br><br>

    <input type="hidden" name="courseID" value="${param.get("courseID")}">
    <c:if test="${TeamsConfigStep.equals('teams')}">
        <input type="submit" value=" next -> " formmethod="post">

    </c:if>

    <c:if test="${TeamsConfigStep.equals('captains')}">
        <input type="submit" value=" finish -> " formmethod="post">
        <input type="hidden" name="TeamsConfigStep" value="end">
    </c:if>

</form:form>

<br>

<form id="return button" action="/open" method="post">
    <input type="hidden" name="courseID" value="${param.get("courseID")}">
    <input type="submit" value="<-- return">
</form>

</body>
</html>
