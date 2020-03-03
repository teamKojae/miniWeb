package hmmteresting.kojae.Model;

public class StudentBean {
	private String studentNo;
	private String studentName;
	private String juminNo;
	private int schoolNo;
	
	public StudentBean() {
		// TODO Auto-generated constructor stub
	}
	public StudentBean(String studentNo, String studentName, String juminNo, int schoolNo) {
		this.studentNo = studentNo;
		this.studentName = studentName;
		this.juminNo = juminNo;
		this.schoolNo = schoolNo;
	}
	public String getStudentNo() {
		return studentNo;
	}
	public void setStudentNo(String studentNo) {
		this.studentNo = studentNo;
	}
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
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
	@Override
	public String toString() {
		return "StudentBean [studentNo=" + studentNo + ", studentName=" + studentName + ", juminNo=" + juminNo
				+ ", schoolNo=" + schoolNo + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((juminNo == null) ? 0 : juminNo.hashCode());
		result = prime * result + schoolNo;
		result = prime * result + ((studentName == null) ? 0 : studentName.hashCode());
		result = prime * result + ((studentNo == null) ? 0 : studentNo.hashCode());
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
		StudentBean other = (StudentBean) obj;
		if (juminNo == null) {
			if (other.juminNo != null)
				return false;
		} else if (!juminNo.equals(other.juminNo))
			return false;
		if (schoolNo != other.schoolNo)
			return false;
		if (studentName == null) {
			if (other.studentName != null)
				return false;
		} else if (!studentName.equals(other.studentName))
			return false;
		if (studentNo == null) {
			if (other.studentNo != null)
				return false;
		} else if (!studentNo.equals(other.studentNo))
			return false;
		return true;
	}

	
	
}
