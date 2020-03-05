package hmmteresting.hyeonjun.Model;

import java.sql.Date;

public class UpdateCheck {
	private String studentNo;
	private String studentName;
	private Date examDate;
	private int examCode;
	private int koreanScore;
	private int mathScore;
	private int englishScore;
	private int scienceScore;
	private int historyScore;
	private int totalScore;
	private int averageSocre;
	private int updateCheck;
	
	@Override
	public String toString() {
		return "UpdateCheck [studentNo=" + studentNo + ", studentName=" + studentName + ", examDate=" + examDate
				+ ", examCode=" + examCode + ", koreanScore=" + koreanScore + ", mathScore=" + mathScore
				+ ", englishScore=" + englishScore + ", scienceScore=" + scienceScore + ", historyScore=" + historyScore
				+ ", totalScore=" + totalScore + ", averageSocre=" + averageSocre + ", updateCheck=" + updateCheck
				+ "]";
	}
	
	public String getStudentNo() {
		return studentNo;
	}
	public void setStudentNo(String studentNO) {
		this.studentNo = studentNO;
	}
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public Date getExamDate() {
		return examDate;
	}
	public void setExamDate(Date examDate) {
		this.examDate = examDate;
	}
	public int getExamCode() {
		return examCode;
	}
	public void setExamCode(int examCode) {
		this.examCode = examCode;
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
	public int getAverageSocre() {
		return averageSocre;
	}
	public void setAverageSocre(int averageSocre) {
		this.averageSocre = averageSocre;
	}
	public int getUpdateCheck() {
		return updateCheck;
	}
	public void setUpdateCheck(int updateCheck) {
		this.updateCheck = updateCheck;
	}
	
	
	
	
	
}
