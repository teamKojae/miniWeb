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
	
	

	public void update(String studentNo, int koreanScore, int englishScore, int mathScore, int scienceScore, int historyScore, int examNo) {
		int totalScore = koreanScore + englishScore + mathScore + scienceScore + historyScore;
		int averageScore = totalScore/5;
		
		Connection connection = null;
		PreparedStatement pstmt = null;

		try {
			connection = DriverManager.getConnection("jdbc:mysql://54.180.142.10:3306/hmmteresting?characterEncoding=utf8", "root", "1234");
			
			String sql = "update hmmteresting.grade set "
					+ "koreanScore =?, "
					+ "englishScore =?, "
					+ "mathScore =?, "
					+ "scienceScore =?, "
					+ "historyScore =?, "
					+ "totalScore =?, "
					+ "averageScore =? "
					+ "where grade.studentNo=?"
					+ " and grade.examNo = ?";
			String updatesql = "update hmmteresting.modifyrequest set state = '0' "
					+"where modifyrequest.studentNo=?";
					
			
			pstmt = connection.prepareStatement(sql);
			System.out.println("update"+pstmt);
			
			pstmt.setInt(1, koreanScore);
			pstmt.setInt(2, englishScore);
			pstmt.setInt(3, mathScore);
			pstmt.setInt(4, scienceScore);
			pstmt.setInt(5, historyScore);
			pstmt.setInt(6, totalScore);
			pstmt.setInt(7, averageScore);
			pstmt.setString(8, studentNo);
			pstmt.setInt(9, examNo);
			System.out.println(pstmt);
			
			pstmt.executeUpdate();
			pstmt = connection.prepareStatement(updatesql);
			pstmt.setString(1, studentNo);
			
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
