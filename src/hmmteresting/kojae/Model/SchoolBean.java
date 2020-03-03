package hmmteresting.kojae.Model;

public class SchoolBean {
	private int schoolNo;
	private String schoolName;
	private String locationName;
	public SchoolBean() {
	}
	public SchoolBean(int schoolNo, String schoolName, String locationName) {
		this.schoolNo = schoolNo;
		this.schoolName = schoolName;
		this.locationName = locationName;
	}
	public int getSchoolNo() {
		return schoolNo;
	}
	public void setSchoolNo(int schoolNo) {
		this.schoolNo = schoolNo;
	}
	public String getSchoolName() {
		return schoolName;
	}
	public void setSchoolName(String schoolName) {
		this.schoolName = schoolName;
	}
	public String getLocationName() {
		return locationName;
	}
	public void setLocationName(String locationName) {
		this.locationName = locationName;
	}
	@Override
	public String toString() {
		return "SchoolBean [schoolNo=" + schoolNo + ", schoolName=" + schoolName + ", locationName=" + locationName
				+ "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((locationName == null) ? 0 : locationName.hashCode());
		result = prime * result + ((schoolName == null) ? 0 : schoolName.hashCode());
		result = prime * result + schoolNo;
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
		SchoolBean other = (SchoolBean) obj;
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
		if (schoolNo != other.schoolNo)
			return false;
		return true;
	}
	
}
