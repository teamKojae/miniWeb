package hmmteresting.jiyoon.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import hmmteresting.jiyoon.model.GradeDTO;
import hmmteresting.jiyoon.model.RequestModifyDTO;
import hmmteresting.jiyoon.model.StudentDTO;


public class studentDAO {
	
	private Connection conn;
	private ResultSet rs;
	private PreparedStatement pstmt;
	
	//dao객체 생성시 db 커넥트
	public studentDAO(){
		try {
			String dbURL = "jdbc:mysql://54.180.142.10:3306/hmmteresting?characterEncoding=utf8";
			String dbID = "root";
			String dbPassword = "1234";
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			conn = DriverManager.getConnection(dbURL, dbID, dbPassword);
//			System.out.println("DB연결 성공");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//성적 불러오기
	public ArrayList<GradeDTO> selectGrade(String studentNo){
		
		String SQL = "SELECT grade.*, student.studentName, exam.examDate, exam.examCode\r\n" + 
				"FROM hmmteresting.grade\r\n" + 
				"inner join student on grade.studentNo = student.studentNo\r\n" + 
				"inner join exam on grade.examNo = exam.examNo\r\n" + 
				"where student.studentNo = ?";
		
		 ArrayList<GradeDTO> list = new ArrayList<GradeDTO>();
		 
		try {
			pstmt = conn.prepareStatement(SQL);
			pstmt.setString(1, studentNo);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				GradeDTO studentGrade = new GradeDTO();
				studentGrade.setStudentNo(rs.getString(1));
				studentGrade.setExamNo(rs.getInt(2));
				studentGrade.setKoreanScore(rs.getInt(3));
				studentGrade.setMathScore(rs.getInt(4));
				studentGrade.setEnglishScore(rs.getInt(5));
				studentGrade.setScienceScore(rs.getInt(6));
				studentGrade.setHistoryScore(rs.getInt(7));
				studentGrade.setTotalScore(rs.getInt(8));
				studentGrade.setAverageScore(rs.getInt(9));
				studentGrade.setStudentName(rs.getString(10));
				studentGrade.setExamDate(rs.getString(11));
				studentGrade.setExamCode(rs.getInt(12));
				list.add(studentGrade);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
		
	}

	
	
	//수정요청 정보 DB에 insert
	public void insertModify( String examNo, String studentNo,String modifyContent ) {
		
		String SQL = "INSERT INTO `hmmteresting`.`modifyrequest` "
				+ "(`examNo`,`studentNo`, `content`) VALUES (?, ?, ?)";
		try {
			pstmt = conn.prepareStatement(SQL);
			pstmt.setInt(1, Integer.parseInt(examNo));
			pstmt.setString(2, studentNo);
			pstmt.setString(3, modifyContent);
			pstmt.executeUpdate();	

		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	//학생의 수정내역 불러오기
	public ArrayList<RequestModifyDTO> selectModify(String studentNo) {
		
		String SQL = "SELECT * FROM hmmteresting.modifyrequest where studentno = ? ";
		ArrayList<RequestModifyDTO> list = new ArrayList<RequestModifyDTO>() ;
		
		try {
			pstmt = conn.prepareStatement(SQL);
			pstmt.setString(1, studentNo);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				RequestModifyDTO student = new RequestModifyDTO();
				student.setModifyNo(rs.getInt(1));
				student.setStudentNO(rs.getString(3));
				student.setContent(rs.getString(4));
				student.setState(rs.getInt(5));
				list.add(student);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	
	
		//login할때
		public StudentDTO login(String name, String studentNo, String juminNo ) {
			
		String SQL = "SELECT student.*, school.schoolName, school.locationName FROM student \r\n" + 
				"inner join school on school.schoolNo = student.schoolNo\r\n" + 
				"where studentName = ? and studentNo= ? and juminNo= ?";
		
		StudentDTO student = new StudentDTO();
		try {
			pstmt = conn.prepareStatement(SQL);
			pstmt.setString(1, name);
			pstmt.setString(2, studentNo);
			pstmt.setString(3, juminNo);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				
			student.setStudentNo(rs.getString(1));	
			student.setStudentName(rs.getString(2));
			student.setJuminNo(rs.getString(3));
			student.setSchoolNo(rs.getInt(4));
			student.setSchoolName(rs.getString(5));
			student.setLocationName(rs.getString(6));
			}	
			else {
				return null;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return student;
	}
	
	public void close() {

		try {
			if (pstmt != null)
				pstmt.close();
			if (conn != null)
				conn.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	protected void finalize() throws Throwable {
		close();
		super.finalize();
	}
	
}
