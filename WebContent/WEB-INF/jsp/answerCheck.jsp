<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="model.DBTable,java.util.*" %>
    <%
    DBTable dbTable=(DBTable)session.getAttribute("dbTable");
    String chapter=dbTable.getChapter();
    List<Integer>numberList=dbTable.getNumber();
    String[] answers=dbTable.getAnswers();
    List<String> judgeList=dbTable.getJudge();
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>回答チェック</title>
</head>
<body>
<%int count=0; %>
<%for(int i=0;i<answers.length;i++){
	if(judgeList.get(i).equals("正解")){count+=1;}
%>
例題<%=chapter %>-<%=numberList.get(i) %>  回答:<%=answers[i] %>  判定:<%=judgeList.get(i) %><br>
<%} %>
<%double result= (double)count/(double)answers.length;%>
正解率<%= result*100 %>%
<a href="/oracleJava/Login">ログイン画面へ</a>
</body>
</html>