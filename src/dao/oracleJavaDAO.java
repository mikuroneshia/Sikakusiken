package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.QuestionInfo;
import model.User;

public class oracleJavaDAO {
	private final String JDBC_URL="jdbc:h2:tcp://localhost/~/oracleJava";
	private final String DB_USER="sa";
	private final String DB_PASS="";

	public List<QuestionInfo> findChapter(String textbook,String chapterNum) {
		List<QuestionInfo> questionInfoList=new ArrayList<>();
		try(Connection conn=DriverManager.getConnection(JDBC_URL,DB_USER,DB_PASS)){
			String sql="SELECT CHAPTER,NUMBER FROM "+textbook+"ANSWERS WHERE CHAPTER="+chapterNum;
			PreparedStatement pStmt=conn.prepareStatement(sql);
			ResultSet rs=pStmt.executeQuery();
			while(rs.next()) {
				int chapter=rs.getInt("CHAPTER");
				int number=rs.getInt("NUMBER");
				QuestionInfo questionInfo=new QuestionInfo(chapter,number);
				questionInfoList.add(questionInfo);
			}
		}catch(SQLException e) {
			e.printStackTrace();
			return null;
		}
		return questionInfoList;
	}
	public boolean create(User user,List<QuestionInfo> questionInfoList) {
		try(Connection conn=DriverManager.getConnection(JDBC_URL,DB_USER,DB_PASS)){
			String sql="INSERT INTO JAVABRONZESPEEDMASTER(NAME,CHAPTER,NUMBER) VALUES(?,?,?)";
			PreparedStatement pStmt=conn.prepareStatement(sql);
			for(QuestionInfo question:questionInfoList) {
				pStmt.setString(1,user.getName());
				pStmt.setInt(2,question.getChapter());
				pStmt.setInt(3,question.getNumber());
				pStmt.executeUpdate();

			}
			}catch(SQLException e) {
				e.printStackTrace();
				return false;
			}
		return true;
	}
}
