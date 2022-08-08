<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table rules="all">
    <tr>
        <th> Firstname</th>
        <th> Lastname</th>
        <c:forEach var="meeting" items="${meetingDates}">
            <th style="writing-mode: vertical-rl">
                ${meeting}
            </th>
        </c:forEach>
        <th> Total score</th>
    </tr>
    <c:forEach var="stud" items="${outputData}">
        <tr>
            <c:forEach var="studField" items="${stud}">
            <td>
                                        <c:out value="${studField}"/>
            </td>
            </c:forEach>
        </tr>
    </c:forEach>
</table>


<%--******************************************************************--%>
<br>
<form id="open" action="/open" method="post">
    <input type="hidden" name="meetingID" value="${param.get("meetingID")}">
    <input type="hidden" name="courseID" value="${param.get("courseID")}">
    <input type="submit" value="<-- return">
</body>
</html>
