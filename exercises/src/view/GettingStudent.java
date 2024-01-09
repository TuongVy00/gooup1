package view;

import java.util.Arrays;

import bean.Student;
import common.Grade;
import functional.Condition;

/**
 * Với sinh viên có học lực loại F bắt buộc phải đăng ký học lại.
 * Tìm danh sách sinh viên từng đạt loại A trong năm 2021.
 * Tìm danh sách sinh viên đã tham gia học lại môn cấu trúc dữ liệu trong năm 2021.
 */

public class GettingStudent {
	public static void main(String[] args) {
		Student[] students = getStudents();		
		Student[] gradeA = filter(students, student -> Grade.A.equals(student.getGrade()));
		Student[] gradeF = filter(students, student -> Grade.F.equals(student.getGrade()));
		
		System.out.println("List of students who have achieved grade A in 2021: \n" + Arrays.toString(gradeA));
		System.out.println("List of students who have re-learned Data Structures in 2021: \n" + Arrays.toString(gradeF));
	}
	
	private static Student[] getStudents() {
		Student s1 = new Student(102, "Nam", Grade.C);
		Student s2 = new Student(103, "Bảo", Grade.F);
		Student s3 = new Student(104, "Hoàng", Grade.D);
		Student s4 = new Student(105, "Nguyên", Grade.B);
		Student s5 = new Student(107, "Vũ", Grade.F);
		Student s6 = new Student(109, "Lan", Grade.A);
		Student s7 = new Student(202, "Đạt", Grade.C);
		
		return new Student[] { s1, s2, s3, s4, s5, s6, s7 };
	}
	
	private static Student[] filter(Student[] students, Condition condition) {
		Student[] result = new Student[students.length];
		int index = 0;

		for (Student student : students) {
			if (condition.check(student)) {
				result[index++] = student;
			}
		}
		return Arrays.copyOfRange(result, 0, index);
	}
}