<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<head>
    <title>Game</title>
</head>

    <body>
    <br>
    <h2> ${question} </h2>
    <input type="button" value="Play again" onclick="window.location.href = '/' ">

    <br> <br> <br> <br>
    <%@include file="statistic.jsp" %>

    </body>

</html>
