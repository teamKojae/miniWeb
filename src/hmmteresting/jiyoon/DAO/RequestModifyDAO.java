package hmmteresting.jiyoon.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import hmmteresting.jiyoon.model.RequestModifyDTO;
import hmmteresting.jiyoon.model.StudentDTO;


public class RequestModifyDAO {
	
	private Connection conn;
	private ResultSet rs;
	
	//dao객체 생성시 db 커넥트
	public RequestModifyDAO(){
		try {
			String dbURL = "jdbc:mysql://localhost/hmmteresting";
			String dbID = "root";
			String dbPassword = "1234";
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(dbURL, dbID, dbPassword);
			System.out.println("DB연결 성공");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//수정요청 정보 DB에 insert
	public void insertModify(String studentNo, String modifyContent ) {
		
		String SQL = "INSERT INTO `hmmteresting`.`modifyrequest` "
				+ "(`studentNo`, `content`) VALUES (?, ?)";
		try {
			PreparedStatement pstmt = conn.prepareStatement(SQL);
			pstmt.setString(1, studentNo);
			pstmt.setString(2, modifyContent);
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
			PreparedStatement pstmt = conn.prepareStatement(SQL);
			pstmt.setString(1, studentNo);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				RequestModifyDTO student = new RequestModifyDTO();
				student.setModifyNo(rs.getInt(1));
				student.setStudentNO(rs.getString(2));
				student.setContent(rs.getString(3));
				student.setState(rs.getInt(4));
				list.add(student);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	public StudentDTO login(String name, String studentNo, String juminNo ) {
		
		String SQL = "SELECT * FROM hmmteresting.student "
				+ "where studentName = ? and studentNo= ? and juminNo=?";
		
		//studentDTO 생성
		StudentDTO student = new StudentDTO();
		
		try {
			PreparedStatement pstmt = conn.prepareStatement(SQL);
			pstmt.setString(1, name);
			pstmt.setString(2, studentNo);
			pstmt.setString(3, juminNo);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
			student.setStudentNo(rs.getString(1));	
			student.setStudentName(rs.getString(2));
			student.setJuminNo(rs.getString(3));
			student.setSchoolNo(rs.getInt(4));
			}	
			else {
				return null;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return student;
	}
	
}
