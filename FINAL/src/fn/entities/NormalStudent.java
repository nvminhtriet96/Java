package fn.entities;

import java.util.Date;

public class NormalStudent extends Student implements Comparable<NormalStudent> {
	private int englishScore;
	private double entryTestScore;
	
	// constructor
	public NormalStudent() {
		super();
	}
	
	public NormalStudent(String fullName, Date doB, String sex, String phoneNumber, String universityName, String gradeLevel, int englishScore, double entryTestScore) {
		super(fullName, doB, sex, phoneNumber, universityName, gradeLevel);
		this.englishScore = englishScore;
		this.entryTestScore = entryTestScore;
	}
	
	// getter,setter method
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

	public int getEnglishScore() {
		return englishScore;
	}
	
	public void setEnglishScore(int englishScore) {
		this.englishScore = englishScore;
	}

	public double getEntryTestScore() {
		return entryTestScore;
	}

	public void setEntryTestScore(double entryTestScore) {
		this.entryTestScore = entryTestScore;
	}

	// display information of normal student
	@Override
	public String ShowMyInfor() {
		return "NormalStudent [getFullName()="
				+ getFullName() + ", getDoB()=" + getDoB() + ", getSex()=" + getSex() + ", getPhoneNumber()="
				+ getPhoneNumber() + ", getUniversityName()=" + getUniversityName() + ", getGradeLevel()="
				+ getGradeLevel() + ", getEnglishScore()=" + getEnglishScore() + ", getEntryTestScore()="
				+ getEntryTestScore() + "]";
	}

	@Override
	public int compareTo(NormalStudent o) {
		if (this.getEntryTestScore() == o.getEntryTestScore()) {
			if (this.getEnglishScore() == o.getEnglishScore()) {
				return this.getFullName().compareTo(o.getFullName());
			}
		}
		if (this.getEntryTestScore() == o.getEntryTestScore()) {
			return o.getEnglishScore() - this.getEnglishScore();
		}
		int k =(int) (o.getEntryTestScore() - this.getEntryTestScore());
		return k;
	}

	
}
