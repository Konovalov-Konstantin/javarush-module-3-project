<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Start page</title>
</head>
<body>
<h1> Welcome to quest. </h1>

<h2><% out.print("<p>Please, enter your name.</p>"); %></h2>

<form
        action="servlet" method="get">
    <input type="text" name="playerName"/>
    <br> <br>
    <input type="submit" value="Play">
</form>

</body>
</html>