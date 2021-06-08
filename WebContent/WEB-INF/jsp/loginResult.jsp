<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="model.User" %>
    <%
    User user=(User) session.getAttribute("user");
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>回答チェック</title>
</head>
<body>
<h1>ようこそ<%=user.getName() %>さん</h1>
<form action="/oracleJava/Checker" method="post">
問題集を選んでください<br>
<select name="textbook">
<option value="JAVABRONZESPEEDMASTER">JavaBronzeスピードマスター</option>
<option value="JAVASILVERSE8">JavaSilverSE8問題集</option>
</select>
チャプターを選んでください<br>
<select name="chapter">
<option value=1>chapter1</option>
<option value=2>chapter2</option>
<option value=3>chapter3</option>
<option value=4>chapter4</option>
<option value=5>chapter5</option>
<option value=6>chapter6</option>
<option value=7>chapter7</option>
</select>
<input type="submit" value="問題チェッカーへ">
</form>
</body>
</html>