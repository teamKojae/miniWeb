package hmmteresting.jiyoon.model;


public class StudentDTO {
	
	String studentName;
	String studentNo;
	String juminNo;
	int schoolNo;
	String schoolName;
	String locationName;
	
	
	public StudentDTO() {
		
	}
	

	public StudentDTO(String studentName, String studentNo, String juminNo, int schoolNo, String schoolName,
			String locationName) {
		super();
		this.studentName = studentName;
		this.studentNo = studentNo;
		this.juminNo = juminNo;
		this.schoolNo = schoolNo;
		this.schoolName = schoolName;
		this.locationName = locationName;
	}

	public String getSchoolName() {
		return schoolName;
	}


	public void setSchoolName(String schoolName) {
		this.schoolName = schoolName;
	}

	public String getLocationName() {
		return locationName;
	}


	public void setLocationName(String locationName) {
		this.locationName = locationName;
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
