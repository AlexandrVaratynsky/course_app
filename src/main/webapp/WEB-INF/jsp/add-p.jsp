<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE HTML>
<HTML>
<head>
    <title>Insert title here</title>
</head>
<body>
<H2>add-p</H2>
<br>

<form:form action="save-p" modelAttribute="participant">
    <form:hidden path="participantID"/>
    <form:hidden path="active"/>
    <form:hidden path="course.courseID"/>

    Firstname:<form:input path="firstName" />
    <br>
    Lastname:<form:input path="lastName" />
<%--    Subgroup:<form:input path="team.teamID" />--%>
    <br>
    <br>
    <input type="submit" value=" OK ">
</form:form>

</body>
</html>