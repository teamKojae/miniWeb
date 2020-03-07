package hmmteresting.hyeonjun.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import hmmteresting.hyeonjun.Model.UpdateCheck;

public class selectModifyUsers {

	public selectModifyUsers() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public ArrayList<UpdateCheck> updateCheck() {

		Connection connection = null;
		PreparedStatement pstmt = null;
		ResultSet resultset = null;
		ArrayList<UpdateCheck> UpdateCheckList = new ArrayList<UpdateCheck>();

		try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost/hmmteresting?", "root", "1234");
			String sql = "SELECT grade.*, student.studentName, exam.examDate, exam.examCode, modifyrequest.state "
					+ "FROM hmmteresting.grade "
					+ "inner join hmmteresting.student on grade.studentNo = student.studentNo "
					+ "inner join hmmteresting.exam on grade.examNo = exam.examNo "
					+ "inner join hmmteresting.modifyrequest on grade.studentNo = modifyrequest.studentNo "
					+ "where modifyrequest.state is not null "
					+ "order by modifyrequest.state desc";
			pstmt = connection.prepareStatement(sql);
			resultset = pstmt.executeQuery();
			
			while (resultset.next()) {
				UpdateCheck UpdateCheck = new UpdateCheck();

				UpdateCheck.setStudentNo(resultset.getString(1));
				UpdateCheck.setKoreanScore(resultset.getInt(3));
				UpdateCheck.setMathScore(resultset.getInt(4));
				UpdateCheck.setEnglishScore(resultset.getInt(5));
				UpdateCheck.setScienceScore(resultset.getInt(6));
				UpdateCheck.setHistoryScore(resultset.getInt(7));
				UpdateCheck.setTotalScore(resultset.getInt(8));
				UpdateCheck.setAverageSocre(resultset.getInt(9));
				UpdateCheck.setStudentName(resultset.getString(10));
				UpdateCheck.setExamDate(resultset.getDate(11));
				UpdateCheck.setExamCode(resultset.getInt(12));
				UpdateCheck.setState(resultset.getInt(13));

				UpdateCheckList.add(UpdateCheck);

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			connection.close();
			pstmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return UpdateCheckList;
	}

	public UpdateCheck updateThisUser(String getstudentNo) {

		Connection connection = null;
		PreparedStatement pstmt = null;
		ResultSet resultset = null;

		UpdateCheck UpdateThisUser = null;

		try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost/hmmteresting?", "root", "1234");
			String sql = "SELECT grade.*, student.studentName, modifyrequest.content, modifyrequest.state "
					+ "from hmmteresting.grade "
					+ "inner join hmmteresting.modifyrequest on grade.studentNo = modifyrequest.studentNo "
					+ "inner join hmmteresting.student on grade.studentNo=student.studentNo "
					+ "where grade.studentNo=?";
			
			pstmt = connection.prepareStatement(sql);
			pstmt.setString(1, getstudentNo);

			resultset = pstmt.executeQuery();
			while (resultset.next()) {
				UpdateThisUser = new UpdateCheck();

				UpdateThisUser.setStudentNo(resultset.getString(1));
				UpdateThisUser.setKoreanScore(resultset.getInt(3));
				UpdateThisUser.setMathScore(resultset.getInt(4));
				UpdateThisUser.setEnglishScore(resultset.getInt(5));
				UpdateThisUser.setScienceScore(resultset.getInt(6));
				UpdateThisUser.setHistoryScore(resultset.getInt(7));
				UpdateThisUser.setTotalScore(resultset.getInt(8));
				UpdateThisUser.setAverageSocre(resultset.getInt(9));
				UpdateThisUser.setStudentName(resultset.getString(10));
				UpdateThisUser.setContent(resultset.getString(11));
				UpdateThisUser.setState(resultset.getInt(12));

				System.out.println(UpdateThisUser);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			connection.close();
			pstmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return UpdateThisUser;
	}
}
