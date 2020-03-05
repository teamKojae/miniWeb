package hmmteresting.jiyoon.model;

public class RequestModifyDTO {
	
	int modifyNo;
	String studentNO;
	String content;
	int state;
	
	public RequestModifyDTO() {

	}
	
	public RequestModifyDTO(int modifyNo, String studentNO, String content, int state) {
		super();
		this.modifyNo = modifyNo;
		this.studentNO = studentNO;
		this.content = content;
		this.state = state;
	}
	
	public int getModifyNo() {
		return modifyNo;
	}
	public void setModifyNo(int modifyNo) {
		this.modifyNo = modifyNo;
	}
	public String getStudentNO() {
		return studentNO;
	}
	public void setStudentNO(String studentNO) {
		this.studentNO = studentNO;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}

	
	@Override
	public String toString() {
		return "RequsetModifyDTO [modifyNo=" + modifyNo + ", studentNO=" + studentNO + ", content=" + content
				+ ", state=" + state + "]";
	}
	

}
