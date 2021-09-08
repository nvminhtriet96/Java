package fn.entities;

import java.util.Date;

public class GoodStudent extends Student implements Comparable<GoodStudent> {
	private double gpa;
	private String bestRewardName;
	
	// constructor
	public GoodStudent() {
		super();
	}
	
	public GoodStudent(String fullName, java.util.Date doB, String sex, String phoneNumber, String universityName, String gradeLevel, double gpa, String bestRewardName) {
		super(fullName, doB, sex, phoneNumber, universityName, gradeLevel);
		this.gpa = gpa;
		this.bestRewardName = bestRewardName;
	}
	
	//getter, setter method
	public double getGpa() {
		return gpa;
	}

	public void setGpa(double gpa) {
		this.gpa = gpa;
	}

	public String getBestRewardName() {
		return bestRewardName;
	}

	public void setBestRewardName(String bestRewardName) {
		this.bestRewardName = bestRewardName;
	}

	@Override
	public String getFullName() {
		// TODO Auto-generated method stub
		return super.getFullName();
	}

	@Override
	public void setFullName(String fullName) {
		// TODO Auto-generated method stub
		super.setFullName(fullName);
	}

	@Override
	public Date getDoB() {
		// TODO Auto-generated method stub
		return super.getDoB();
	}

	@Override
	public void setDoB(Date doB) {
		// TODO Auto-generated method stub
		super.setDoB(doB);
	}

	@Override
	public String getSex() {
		// TODO Auto-generated method stub
		return super.getSex();
	}

	@Override
	public void setSex(String sex) {
		// TODO Auto-generated method stub
		super.setSex(sex);
	}

	@Override
	public String getPhoneNumber() {
		// TODO Auto-generated method stub
		return super.getPhoneNumber();
	}

	@Override
	public void setPhoneNumber(String phoneNumber) {
		// TODO Auto-generated method stub
		super.setPhoneNumber(phoneNumber);
	}

	@Override
	public String getUniversityName() {
		// TODO Auto-generated method stub
		return super.getUniversityName();
	}

	@Override
	public void setUniversityName(String universityName) {
		// TODO Auto-generated method stub
		super.setUniversityName(universityName);
	}

	@Override
	public String getGradeLevel() {
		// TODO Auto-generated method stub
		return super.getGradeLevel();
	}

	@Override
	public void setGradeLevel(String gradeLevel) {
		// TODO Auto-generated method stub
		super.setGradeLevel(gradeLevel);
	}

	// display information of good student
	@Override
	public String ShowMyInfor() {
		return "GoodStudent [FullName=" + getFullName() + ", DoB="
				+ getDoB() + ", Sex=" + getSex() + ", PhoneNumber=" + getPhoneNumber()
				+ ", UniversityName=" + getUniversityName() + ", GradeLevel=" + getGradeLevel()
				+ ", Gpa=" + getGpa() + ", BestRewardName=" + getBestRewardName() + "]";
	}

	@Override
	public int compareTo(GoodStudent o) {
		if (this.getGpa() == o.getGpa()) {
			return this.getFullName().compareTo(o.getFullName());
		}
		if (this.getGpa() > o.getGpa()) {
			return -1;
		}
		else {
			return 1;
		}
	}
	
}

