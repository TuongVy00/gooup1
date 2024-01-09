package bean;

import common.Grade;

/**
 * Trong năm 2021 có N sinh viên khoa CNTT đăng ký học phần cấu trúc dữ liệu. 
 * Thông tin mỗi sinh viên được lưu trữ tại hệ thống gồm: Mã sinh viên, Họ tên, Xếp loại
 * Xếp loại học lực được lưu trong Enum với các giá trị: A, B, C, D, E, F
 */

public class Student {
	private int id;
	private String name;
	private Grade grade;

	public Student() {
	}

	public Student(int id, String name, Grade grade) {
		this.id = id;
		this.name = name;
		this.grade = grade;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Grade getGrade() {
		return grade;
	}

	public void setGrade(Grade grade) {
		this.grade = grade;
	}

	@Override
	public String toString() {
		return "Student [id: " + id + ", name: " + name + ", grade: " + grade + "]";
	}

}