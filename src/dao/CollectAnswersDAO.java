package dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CollectAnswersDAO {
	private final String JDBC_URL="jdbc:h2:tcp://localhost/~/oracleJava";
	private final String DB_USER="sa";
	private final String DB_PASS="";

	public List<String> collectAnswers(String textbook,String chapter){
		List<String> collectAnswers=new ArrayList<>();
		try(Connection conn=DriverManager.getConnection(JDBC_URL,DB_USER,DB_PASS)){
			String sql="SELECT ANSWER FROM "+textbook+"ANSWERS WHERE CHAPTER="+chapter;
			PreparedStatement pStmt=conn.prepareStatement(sql);
			ResultSet rs=pStmt.executeQuery();

			while(rs.next()) {
				String answer=rs.getString("ANSWER");
				collectAnswers.add(answer);
			}
		}catch(SQLException e) {
			e.printStackTrace();
			return null;
		}
		return collectAnswers;
	}
}
