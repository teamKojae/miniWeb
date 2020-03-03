package hmmteresting.yena.model;

public class AdminBean {
	private int managerNo;
	private String managerId;
	private String managerPassword;
	public int getManagerNo() {
		return managerNo;
	}
	public void setManagerNo(int managerNo) {
		this.managerNo = managerNo;
	}
	public String getManagerId() {
		return managerId;
	}
	public void setManagerId(String managerId) {
		this.managerId = managerId;
	}
	public String getManagerPassword() {
		return managerPassword;
	}
	public void setManagerPassword(String managerPassword) {
		this.managerPassword = managerPassword;
	}
	@Override
	public String toString() {
		return "AdminBean [managerNo=" + managerNo + ", managerId=" + managerId + ", managerPassword=" + managerPassword
				+ "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((managerId == null) ? 0 : managerId.hashCode());
		result = prime * result + managerNo;
		result = prime * result + ((managerPassword == null) ? 0 : managerPassword.hashCode());
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
		AdminBean other = (AdminBean) obj;
		if (managerId == null) {
			if (other.managerId != null)
				return false;
		} else if (!managerId.equals(other.managerId))
			return false;
		if (managerNo != other.managerNo)
			return false;
		if (managerPassword == null) {
			if (other.managerPassword != null)
				return false;
		} else if (!managerPassword.equals(other.managerPassword))
			return false;
		return true;
	}
	
	
	
}
