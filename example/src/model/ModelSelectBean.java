package model;

public class ModelSelectBean {

	private String examDate;//시험일자
	private String examCode;//시험회차
	private String locationName;//지역
	
	private String schoolName;//학교
	private String studentName;//학생이름
	private String studentNo;//수험번호
	public String getExamDate() {
		return examDate;
	}
	public void setExamDate(String examDate) {
		this.examDate = examDate;
	}
	public String getExamCode() {
		return examCode;
	}
	public void setExamCode(String examCode) {
		this.examCode = examCode;
	}
	public String getLocationName() {
		return locationName;
	}
	public void setLocationName(String locationName) {
		this.locationName = locationName;
	}
	public String getSchoolName() {
		return schoolName;
	}
	public void setSchoolName(String schoolName) {
		this.schoolName = schoolName;
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
		studentNo = studentNo;
	}
	@Override
	public String toString() {
		return "ModelSelectBean [examDate=" + examDate + ", examCode=" + examCode + ", locationName=" + locationName
				+ ", schoolName=" + schoolName + ", studentName=" + studentName + ", StudentNo=" + studentNo + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((studentNo == null) ? 0 : studentNo.hashCode());
		result = prime * result + ((examCode == null) ? 0 : examCode.hashCode());
		result = prime * result + ((examDate == null) ? 0 : examDate.hashCode());
		result = prime * result + ((locationName == null) ? 0 : locationName.hashCode());
		result = prime * result + ((schoolName == null) ? 0 : schoolName.hashCode());
		result = prime * result + ((studentName == null) ? 0 : studentName.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ModelSelectBean other = (ModelSelectBean) obj;
		if (studentNo == null) {
			if (other.studentNo != null)
				return false;
		} else if (!studentNo.equals(other.studentNo))
			return false;
		if (examCode == null) {
			if (other.examCode != null)
				return false;
		} else if (!examCode.equals(other.examCode))
			return false;
		if (examDate == null) {
			if (other.examDate != null)
				return false;
		} else if (!examDate.equals(other.examDate))
			return false;
		if (locationName == null) {
			if (other.locationName != null)
				return false;
		} else if (!locationName.equals(other.locationName))
			return false;
		if (schoolName == null) {
			if (other.schoolName != null)
				return false;
		} else if (!schoolName.equals(other.schoolName))
			return false;
		if (studentName == null) {
			if (other.studentName != null)
				return false;
		} else if (!studentName.equals(other.studentName))
			return false;
		return true;
	}
	
	
	
	
}
