<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>

    <title>Game</title>

</head>
<body>

<c:set var="step" value="${step}"/>
<c:choose>
    <c:when test="${step == 1}">
        <h2>Hello ${playerName}</h2>
    </c:when>
</c:choose>

<h2> ${question} </h2>

<form action="servlet" method="post">
    <input type="text" name="questionId" value="${questionId}" hidden>

    <input type="radio" name="answer" value="${firstAnswer}"/> ${firstAnswer}
    <br> <br>
    <input type="radio" name="answer" value="${secondAnswer}"/> ${secondAnswer}
    <br> <br>
    <input type="submit" value="Answer">
</form>

<br> <br> <br> <br>
<%@include file="statistic.jsp" %>

</body>
</html>
