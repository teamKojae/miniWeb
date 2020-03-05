package hmmteresting.jiyoon.model;

public class StudentDTO {
	
	String studentName;
	String studentNo;
	String juminNo;
	int schoolNo;
	
	public StudentDTO() {
	}

	
	
	public StudentDTO(String studentName, String studentNo, String juminNo, int schoolNo) {
		super();
		this.studentName = studentName;
		this.studentNo = studentNo;
		this.juminNo = juminNo;
		this.schoolNo = schoolNo;
	}

	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public String getStudentNo() {
		return studentNo;
	}
	public void setStudentNo(String studentNo) {
		this.studentNo = studentNo;
	}
	public String getJuminNo() {
		return juminNo;
	}
	public void setJuminNo(String juminNo) {
		this.juminNo = juminNo;
	}
	public int getSchoolNo() {
		return schoolNo;
	}
	public void setSchoolNo(int schoolNo) {
		this.schoolNo = schoolNo;
	}
	
	

}
