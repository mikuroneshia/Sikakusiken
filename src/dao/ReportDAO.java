package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import model.DBTable;
public class ReportDAO {
	private final String JDBC_URL="jdbc:h2:tcp://localhost/~/oracleJava";
	private final String DB_USER="sa";
	private final String DB_PASS="";

	public void report(DBTable dbTable,String textbook,String times) {
		try(Connection conn=DriverManager.getConnection(JDBC_URL,DB_USER,DB_PASS)){
			String sql="INSERT INTO "+textbook+"(NAME,CHAPTER,NUMBER,ANSWER,JUDGE,TIMES) VALUES(?,?,?,?,?,?)";
			PreparedStatement pStmt=conn.prepareStatement(sql);
			List<Integer>numberList=dbTable.getNumber();
			String[] answers=dbTable.getAnswers();
			List<String>judge=dbTable.getJudge();
			for(int i=0;i<numberList.size();i++) {
				pStmt.setString(1,dbTable.getName());
				pStmt.setString(2,dbTable.getChapter());
				pStmt.setInt(3,numberList.get(i));
				pStmt.setString(4, answers[i]);
				pStmt.setString(5,judge.get(i));
				pStmt.setString(6, times);
				pStmt.executeUpdate();
			}

		}catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
