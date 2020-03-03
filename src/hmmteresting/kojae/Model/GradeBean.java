package hmmteresting.kojae.Model;

public class GradeBean {
	public GradeBean() {
	}

	public GradeBean(String studentNo, int examNo, int koreanScore, int mathScore, int englishScore, int scienceScore,
			int historyScore, int totlaScore, int averageScore) {
		this.studentNo = studentNo;
		this.examNo = examNo;
		this.koreanScore = koreanScore;
		this.mathScore = mathScore;
		this.englishScore = englishScore;
		this.scienceScore = scienceScore;
		this.historyScore = historyScore;
		this.totalScore = totlaScore;
		this.averageScore = averageScore;
	}

	private String studentNo;
	private int examNo;
	private int koreanScore;
	private int mathScore;
	private int englishScore;
	private int scienceScore;
	private int historyScore;
	private int totalScore;
	private int averageScore;

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

	public int getTotlaScore() {
		return totalScore;
	}

	public void setTotalScore(int totlaScore) {
		this.totalScore = totlaScore;
	}

	public int getAverageScore() {
		return averageScore;
	}

	public void setAverageScore(int averageScore) {
		this.averageScore = averageScore;
	}

	@Override
	public String toString() {
		return "GradeBean [studentNo=" + studentNo + ", examNo=" + examNo + ", koreanScore=" + koreanScore
				+ ", mathScore=" + mathScore + ", englishScore=" + englishScore + ", scienceScore=" + scienceScore
				+ ", historyScore=" + historyScore + ", totlaScore=" + totalScore + ", averageScore=" + averageScore
				+ "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + averageScore;
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
		GradeBean other = (GradeBean) obj;
		if (averageScore != other.averageScore)
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
