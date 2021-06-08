<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.util.*,model.User,model.QuestionInfo,dao.oracleJavaDAO,model.GetQuestionInfoLogic" %>
    <%
    String chapter=(String) request.getAttribute("chapter");
    String textbook =(String)request.getAttribute("textbook");
    GetQuestionInfoLogic gqil=new GetQuestionInfoLogic();

    List<QuestionInfo>questionList=gqil.execute(textbook,chapter);
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>回答チェック</title>
</head>
<body>
<form action="/oracleJava/AnswerCheck" method="post">
周回数:<select name="times">
<option value=1>1周目</option>
<option value=2>2周目</option>
<option value=3>3周目</option>
<option value=4>4周目</option>
</select><br>
<%for(QuestionInfo question:questionList){ %>
問題<%= question.getChapter()+"-"+question.getNumber() %>
回答:<input type="text" name="answer"><br>
<%} %>

<input type="submit" value="回答を送信">
</form>
</body>
</html>