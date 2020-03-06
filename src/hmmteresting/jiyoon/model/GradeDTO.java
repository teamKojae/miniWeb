package hmmteresting.jiyoon.model;


public class GradeDTO {
	
	
	private String studentName;
	
	private int examNo;
	private int examCode; 
	private String examDate;
	
	private String studentNo;
	private int koreanScore; 
	private int mathScore; 
	private int englishScore; 
	private int scienceScore; 
	private int historyScore;
	private int totalScore; 
	private int averageScore;
	
	public GradeDTO() {
		// TODO Auto-generated constructor stub
	}
	
	public GradeDTO(String studentNo, String studentName, int examCode, String examDate, 
			int koreanScore,  int mathScore, int englishScore, int scienceScore, int historyScore,
			int totalScore, int averageScore, int examNo) {
		super();
		this.studentNo = studentNo;
		this.studentName = studentName;
		this.examCode = examCode;
		this.examDate = examDate;
		this.koreanScore = koreanScore;
		this.mathScore = mathScore;
		this.englishScore = englishScore;
		this.scienceScore = scienceScore;
		this.historyScore =  historyScore;
		this.totalScore = totalScore;
		this.averageScore = averageScore;
		this.examNo = examNo;
		
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

	public int getKoreanScore() {
		return koreanScore;
	}

	public int getExamNo() {
		return examNo;
	}

	public void setExamNo(int examNo) {
		this.examNo = examNo;
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

	public int getAverageScore() {
		return averageScore;
	}

	public void setAverageScore(int averageScore) {
		this.averageScore = averageScore;
	}

	@Override
	public String toString() {
		return "GradeDTO [studentName=" + studentName + ", examNo=" + examNo + ", examCode=" + examCode + ", examDate="
				+ examDate + ", studentNo=" + studentNo + ", koreanScore=" + koreanScore + ", mathScore=" + mathScore
				+ ", englishScore=" + englishScore + ", scienceScore=" + scienceScore + ", historyScore=" + historyScore
				+ ", totalScore=" + totalScore + ", averageScore=" + averageScore + "]";
	}


	
	

}
