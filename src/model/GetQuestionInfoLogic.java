package model;

import java.util.List;

import dao.oracleJavaDAO;

public class GetQuestionInfoLogic {
	public List<QuestionInfo> execute(String textbook,String chapter){
		oracleJavaDAO dao=new oracleJavaDAO();
		List<QuestionInfo>questionList=dao.findChapter(textbook,chapter);
		return questionList;
	}
}
