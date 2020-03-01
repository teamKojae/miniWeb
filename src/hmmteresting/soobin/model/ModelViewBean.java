package hmmteresting.soobin.model;

public class ModelViewBean {

	
	private String studentNo;
	private int examNo,koreanScore,mathScore,englishScore,scienceScore
	,historyScore,totalScore;
	private Double averageScore;
	
	private String StudentName,ExamDate;

	public String getStudentNo() {
		return studentNo;
	}

	public void setStudentNo(String studentNo) {
		this.studentNo = studentNo;
	}

	public int getExamNo() {
		return examNo;
	}

	public void setExamNo(int examNo) {
		this.examNo = examNo;
	}

	public int getKoreanScore() {
		return koreanScore;
	}

	public void setKoreanScore(int koreanScore) {
		this.koreanScore = koreanScore;
	}

	public int getMathScore() {
		return mathScore;
	}

	public void setMathScore(int mathScore) {
		this.mathScore = mathScore;
	}

	public int getEnglishScore() {
		return englishScore;
	}

	public void setEnglishScore(int englishScore) {
		this.englishScore = englishScore;
	}

	public int getScienceScore() {
		return scienceScore;
	}

	public void setScienceScore(int scienceScore) {
		this.scienceScore = scienceScore;
	}

	public int getHistoryScore() {
		return historyScore;
	}

	public void setHistoryScore(int historyScore) {
		this.historyScore = historyScore;
	}

	public int getTotalScore() {
		return totalScore;
	}

	public void setTotalScore(int totalScore) {
		this.totalScore = totalScore;
	}

	public Double getAverageScore() {
		return averageScore;
	}

	public void setAverageScore(Double averageScore) {
		this.averageScore = averageScore;
	}

	public String getStudentName() {
		return StudentName;
	}

	public void setStudentName(String studentName) {
		StudentName = studentName;
	}

	public String getExamDate() {
		return ExamDate;
	}

	public void setExamDate(String examDate) {
		ExamDate = examDate;
	}

	@Override
	public String toString() {
		return "ModelViewBean [studentNo=" + studentNo + ", examNo=" + examNo + ", koreanScore=" + koreanScore
				+ ", mathScore=" + mathScore + ", englishScore=" + englishScore + ", scienceScore=" + scienceScore
				+ ", historyScore=" + historyScore + ", totalScore=" + totalScore + ", averageScore=" + averageScore
				+ ", StudentName=" + StudentName + ", ExamDate=" + ExamDate + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((ExamDate == null) ? 0 : ExamDate.hashCode());
		result = prime * result + ((StudentName == null) ? 0 : StudentName.hashCode());
		result = prime * result + ((averageScore == null) ? 0 : averageScore.hashCode());
		result = prime * result + englishScore;
		result = prime * result + examNo;
		result = prime * result + historyScore;
		result = prime * result + koreanScore;
		result = prime * result + mathScore;
		result = prime * result + scienceScore;
		result = prime * result + ((studentNo == null) ? 0 : studentNo.hashCode());
		result = prime * result + totalScore;
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
		ModelViewBean other = (ModelViewBean) obj;
		if (ExamDate == null) {
			if (other.ExamDate != null)
				return false;
		} else if (!ExamDate.equals(other.ExamDate))
			return false;
		if (StudentName == null) {
			if (other.StudentName != null)
				return false;
		} else if (!StudentName.equals(other.StudentName))
			return false;
		if (averageScore == null) {
			if (other.averageScore != null)
				return false;
		} else if (!averageScore.equals(other.averageScore))
			return false;
		if (englishScore != other.englishScore)
			return false;
		if (examNo != other.examNo)
			return false;
		if (historyScore != other.historyScore)
			return false;
		if (koreanScore != other.koreanScore)
			return false;
		if (mathScore != other.mathScore)
			return false;
		if (scienceScore != other.scienceScore)
			return false;
		if (studentNo == null) {
			if (other.studentNo != null)
				return false;
		} else if (!studentNo.equals(other.studentNo))
			return false;
		if (totalScore != other.totalScore)
			return false;
		return true;
	}
	

	
}
