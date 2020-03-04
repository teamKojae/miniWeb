package hmmteresting.hyeonjun.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class selectModifyThisUser {

	public selectModifyThisUser() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	

	public void update(String studentNo, int koreanScore, int englishScore, int mathScore, int scienceScore, int historyScore) {
		int totalScore = koreanScore + englishScore + mathScore + scienceScore + historyScore;
		int averageSocre = totalScore/5;
		
		
		Connection connection = null;
		PreparedStatement pstmt = null;

		try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost/hmmteresting?", "root", "1234");
			
			String sql = "update hmmteresting.grade set "
					+ "koreanScore ='?' "
					+ "englishScore = '?' "
					+ "mathScore = '?' "
					+ "scienceScore = '?' "
					+ "historyScore = '?' "
					+ "totalScore = '?' "
					+ "averageSocre = '?' "
					+ "updateCheck = '1' "
					+ "where studentNo='?'";
			
			pstmt = connection.prepareStatement(sql);
			pstmt.setInt(1, koreanScore);
			pstmt.setInt(2, englishScore);
			pstmt.setInt(3, mathScore);
			pstmt.setInt(4, scienceScore);
			pstmt.setInt(5, historyScore);
			pstmt.setInt(6, totalScore);
			pstmt.setInt(7, averageSocre);
			pstmt.setString(8, studentNo);
			
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
