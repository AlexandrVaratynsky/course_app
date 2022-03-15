<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Meeting</title>
</head>
<body>
<H2>Meeting</H2>
<form:form action="/save-config" modelAttribute="Participants">


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
        <c:forEach var="stud" items="${Participants}">

            <tr>
                <td>${stud.firstName}</td>
                <td>${stud.lastName}</td>


                <td>

                    <input type="checkbox" checked value="1" name=active-${stud.participantID} >
                    <input type='hidden' value="0" name=active-${stud.participantID}>
                </td>

                <td>
                    <input type="number" readonly value=${stud.team.teamNumber} min=0 max=50 name=team-${stud.participantID}>

                </td>
                <td>
                    <input type="number" value=0 step="0.1" min=0 max=5 name=${stud.participantID}>

                </td>

                <td>
                    <input type="number" value=0 min=0 max=5 step="0.1" name=${stud.participantID}>

                </td>
                <td>
                    <input type="number" value=0 min=0 max=5 step="0.1" name=${stud.participantID}>

                </td>


            </tr>

        </c:forEach>


    </table>
    <br>
    <br>
    <input type="submit" value=" SAVE "
           onclick="window.location.href = 'redirect:/open?courseID=${param.get("courseID")}'">
    <input type="submit" value=" QUIZ "
           onclick="window.location.href = '/open?courseID=${param.get("courseID")}'">
</form:form>


</body>
</html>
