<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE HTML>
<HTML>
<head>
    <title>Insert title here</title>
</head>
<body>
www
<br>
<form:form action="save" modelAttribute="student">
    Firstname:<form:input path="firstname" />
    <form:errors path="firstname"/>
    <br>
    Lastname:<form:input path="lastname" />
    <form:errors path="lastname"/>
    <br>
    Subgroup:<form:input path="subgroup" />
    <br>

<%--    <form:options items="${employee.departments}" />--%>

    <br>
<%--    <form:checkboxes items="${student.mapField}" path="chck"/>--%>
    <br>
    <input type="submit" value=" OK ">
</form:form>

</body>
</html>