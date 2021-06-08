package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CollectAnswerCreateDAO {
	public static void main(String []args) {
		String[] answers= {"D","C","A,E","A,C,D","A","A","C","B","C","A","F","F","D","A,D","B","C","A"};
		CollectAnswerCreateDAO dao=new CollectAnswerCreateDAO();
		dao.createAnswer(7,17,answers);
	}
	private final String JDBC_URL="jdbc:h2:tcp://localhost/~/oracleJava";
	private final String DB_USER="sa";
	private final String DB_PASS="";

	public void createAnswer(int chapter,int number,String[] answers) {
		try(Connection conn=DriverManager.getConnection(JDBC_URL,DB_USER,DB_PASS)){
			String sql="INSERT INTO  JAVASILVERSE8ANSWERS(CHAPTER,NUMBER,ANSWER) VALUES(?,?,?)";
			PreparedStatement pStmt=conn.prepareStatement(sql);
			for(int i=1;i<=number;i++) {
				pStmt.setInt(1,chapter);
				pStmt.setInt(2, i);
				pStmt.setString(3, answers[i-1]);
				pStmt.executeUpdate();
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
}
