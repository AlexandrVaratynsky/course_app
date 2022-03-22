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
            <c:set var="answerID" value="${requestScope.get('whoAnswersID')}"/>
            <c:set var="askID" value="${requestScope.get('whoAsksID')}"/>



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
                        <input type="number" value="${param.get('bonus-'.concat(currentID))}"
                               step="0.1" min=0 max=5 name=bonus-${currentID}>
                    </c:if>
                    <c:if test="${not param.get(currentID).equals('checked')}">
                        <input type="number" disabled value="${param.get('bonus-'.concat(currentID))}"
                               step="0.1" min=0 max=5 name=bonus-${currentID}>
                        <input type="hidden" value="${param.get('bonus-'.concat(currentID))}"
                               step="0.1" min=0 max=5 name=bonus-${currentID}>
                    </c:if>
                </td>
                <td>
                    <c:if test="${(param.get(currentID).equals('checked'))&&
                    (askID.equals(currentID))}">
                        <input type="number" value="${param.get('question-'.concat(currentID))}"
                               min=0 max=5 step="0.1" name=question-${currentID}>
                    </c:if>
                    <c:if test="${not ((param.get(currentID).equals('checked'))&&
                    (askID.equals(currentID)))}">
                        <input type="number" disabled value="${param.get('question-'.concat(currentID))}"
                               min=0 max=5 step="0.1"
                               name=question-${currentID}>
                        <input type="hidden" value="${param.get('question-'.concat(currentID))}"
                               min=0 max=5 step="0.1"
                               name=question-${currentID}>
                    </c:if>
                </td>
                <td>
                    <c:if test="${(param.get(currentID).equals('checked'))&&
                    (answerID.equals(currentID))}">
                        <input type="number" value="${param.get('answer-'.concat(currentID))}"
                               min=0 max=5 step="0.1" name=answer-${currentID}>
                    </c:if>
                    <c:if test="${not ((param.get(currentID).equals('checked'))&&
                    (answerID.equals(currentID)))}">
                        <input type="number" disabled value="${param.get('answer-'.concat(currentID))}"
                               min=0 max=5 step="0.1" name=answer-${currentID}>
                        <input type="hidden" value="${param.get('answer-'.concat(currentID))}"
                               min=0 max=5 step="0.1" name=answer-${currentID}>
                    </c:if>
                </td>
                <td>
                    <c:if test="${answerID.equals(currentID)}">answer</c:if>
                    <c:if test="${askID.equals(currentID)}">ask</c:if>


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




<%--<c:forEach var="p" items="${requestScope.keySet()}">--%>

whoAnswersID--<c:out value="${requestScope.get('whoAnswersID')}"/><br>
whoAsksID--<c:out value="${requestScope.get('whoAsksID')}"/><br>
end--<c:out value="${requestScope.get('end')}"/><br>
<%--</c:forEach>--%>

<%--<c:forEach var="p" items="${requestScope.entrySet()}">--%>
<%--    <c:out value="${p.key}"/>--%>
<%--    <c:forEach var="a" items="${p.value}">--%>
<%--        ---<c:out value="${a}"/>--%>
<%--    </c:forEach><br>--%>
<%--</c:forEach>--%>


</body>
</html>