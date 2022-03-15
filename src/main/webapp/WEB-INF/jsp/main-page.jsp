<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<HTML>
<head>
    <title>Insert title here</title>
</head>
<body>

<br>
<br>
<form:form action="save" modelAttribute="participant">
    Firstname:<form:input path="firstName"/>
    <form:errors path="firstName"/>
    <br>
    Lastname:<form:input path="lastName"/>
    <form:errors path="lastName"/>
    <br>
    Subgroup:<form:input path="team.teamID"/>
    <br>
    <br>
    <input type="submit" value=" OK ">
</form:form>

</body>
</html>