<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<H2>Add-course</H2>
<body>
<form:form action="save" modelAttribute="course">

    <form:hidden path="courseID"/>
    <form:hidden path="active"/>
    <%--    <form:input type="datetime-local" path="startDate" />--%>
    <br>
    <br>
    Course name:<form:input path="name"/>
    <br>
    <br>
    <input type="submit" value=" OK ">
</form:form>
</body>
</html>
