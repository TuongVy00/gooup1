package bean;

import common.Gender;

public class Student2 {
	private String id;
	private String fullname;
	private double gpa;
	private Gender gender;

	public Student2() {
	}

	public Student2(String id, String fullname, double gpa, Gender gender) {
		this.id = id;
		this.fullname = fullname;
		this.gpa = gpa;
		this.gender = gender;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public double getGpa() {
		return gpa;
	}

	public void setGpa(double gpa) {
		this.gpa = gpa;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", fullname=" + fullname + ", gpa=" + gpa + ", gender=" + gender + "]";
	}
}