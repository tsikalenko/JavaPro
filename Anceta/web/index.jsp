<%--
  Created by IntelliJ IDEA.
  User: Никита
  Date: 13.12.2017
  Time: 10:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Anceta</title>
</head>
<body>
<form action="/question" method="POST">

    Question 1 <br/>
    <input type="radio" name="question1" value="yes"/> Yes<br/>
    <input type="radio" name="question1" value="no"/> No<br/>

    Question 2 <br/>
    <input type="radio" name="question2" value="yes"/> Yes<br/>
    <input type="radio" name="question2" value="no"/> No<br/>
    <br/>
    login:<br/>
    <input type="text" name="login"/><br/>
    Age:<br/>
    <input type="number" name="age"/><br/>
    Sex <br/>
    <input type="radio" name="sex" value="male"/> male<br/>
    <input type="radio" name="sex" value="female"/> female<br/>
    <br/>

    <input type="submit"/>
</form>
</body>
</html>
