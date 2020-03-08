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
			connection = DriverManager.getConnection("jdbc:mysql://54.180.142.10:3306/hmmteresting?characterEncoding=utf8", "root", "1234");
			String sql = "SELECT grade.*, student.studentName, exam.examDate, exam.examCode, "
					+ "modifyrequest.state , modifyrequest.modifyNo " 
					+"FROM hmmteresting.grade, student, modifyrequest, exam "
					+"WHERE grade.studentNo = student.studentNo  "
					+"AND student.studentNo = modifyrequest.studentNo "
					+"AND grade.examNo = exam.examNo "
					+"AND modifyrequest.state is not null   "
					+"AND exam.examNo = modifyrequest.examNo "
					+"ORDER BY  modifyrequest.state DESC , modifyrequest.modifyNo ASC";
			
			System.out.println("updateCheck : "+sql);
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
				UpdateCheck.setModifyNo(resultset.getInt(14));
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

	public UpdateCheck updateThisUser(String getstudentNo, String modifyNo) {

		Connection connection = null;
		PreparedStatement pstmt = null;
		ResultSet resultset = null;

		UpdateCheck UpdateThisUser = null;

		try {
			connection = DriverManager.getConnection("jdbc:mysql://54.180.142.10:3306/hmmteresting?characterEncoding=utf8", "root", "1234");
			
			String sql =  " SELECT grade.*, student.studentName, modifyrequest.content,"
					+ " modifyrequest.state , modifyrequest.modifyNo "
					+" from grade, student, exam, modifyrequest"
					+" WHERE  grade.studentNo=student.studentNo "
					+" AND exam.examNo=grade.examNo"
					+" AND grade.studentNo = modifyrequest.studentNo"
					+" AND exam.examNo = modifyrequest.examNo"
					+" AND grade.studentNo= ? "
					+" AND modifyrequest.modifyNo = ? "
					+ "ORDER BY  modifyrequest.state DESC , modifyrequest.modifyNo ASC";
			
			
			System.out.println("updateThisUser : "+sql);
			pstmt = connection.prepareStatement(sql);
			pstmt.setString(1, getstudentNo);
			pstmt.setString(2, modifyNo);
			
			resultset = pstmt.executeQuery();
			while (resultset.next()) {
				UpdateThisUser = new UpdateCheck();

				UpdateThisUser.setStudentNo(resultset.getString(1));
				UpdateThisUser.setExamNo(resultset.getInt(2));
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
				UpdateThisUser.setModifyNo(resultset.getInt(13));
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
