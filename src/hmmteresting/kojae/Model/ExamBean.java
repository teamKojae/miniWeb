package hmmteresting.kojae.Model;

import java.util.Date;

public class ExamBean {
	private int examNo;
	private int examCode;
	private String examDate;
	public ExamBean() {
	}
	public ExamBean(int examNo, int examCode, String examDate) {
		super();
		this.examNo = examNo;
		this.examCode = examCode;
		this.examDate = examDate;
	}
	public int getExamNo() {
		return examNo;
	}
	public void setExamNo(int examNo) {
		this.examNo = examNo;
	}
	public int getExamCode() {
		return examCode;
	}
	public void setExamCode(int examCode) {
		this.examCode = examCode;
	}
	public String getExamDate() {
		return examDate;
	}
	public void setExamDate(String examDate) {
		this.examDate = examDate;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + examCode;
		result = prime * result + ((examDate == null) ? 0 : examDate.hashCode());
		result = prime * result + examNo;
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
		ExamBean other = (ExamBean) obj;
		if (examCode != other.examCode)
			return false;
		if (examDate == null) {
			if (other.examDate != null)
				return false;
		} else if (!examDate.equals(other.examDate))
			return false;
		if (examNo != other.examNo)
			return false;
		return true;
	}
	
}
