package hmmteresting.soobin.model;

import java.util.Date;

public class ModelExamBean {

	private String examCode;
	private String examDate;
	public String getExamCode() {
		return examCode;
	}
	public void setExamCode(String examCode) {
		this.examCode = examCode;
	}
	public String getExamDate() {
		return examDate;
	}
	public void setExamDate(String examDate) {
		this.examDate = examDate;
	}
	@Override
	public String toString() {
		return "ModelExamBean [examCode=" + examCode + ", examDate=" + examDate + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((examCode == null) ? 0 : examCode.hashCode());
		result = prime * result + ((examDate == null) ? 0 : examDate.hashCode());
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
		ModelExamBean other = (ModelExamBean) obj;
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
		return true;
	}

	
	
	
	
	
}
