package view;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map.Entry;
import java.util.stream.Collectors;

import bean.Student2;
import common.Gender;

import static utils.PrintUtils.*;

/**
 * Cho danh sách sinh viên được input từ file student.txt. Viết chương trình
 * 1. Sắp xếp danh sách sinh viên tăng dần theo ĐTB. Nếu ĐTB bằng nhau sắp xếp giảm
 * dần theo họ tên.
 * 2. Viết hàm tìm kiếm danh sách sinh viên có ĐTB > 8
 * 3. Viết hàm tìm kiếm toàn bộ các sinh viên NỮ
 * 4. Tìm kiếm sinh viên chỉ xuất hiện một lần trong student.txt. Biết rằng 2 sinh viên được
 * phân biệt với nhau thông qua MSSV
 */

public class StudentApp {
	public static void main(String[] args) {
		List<Student2> students = getStudentFromFile("F:/Baitap/gooup1/exercises/src/student.txt");

		print("1. Sắp xếp danh sách sinh viên tăng dần theo ĐTB. Nếu ĐTB bằng nhau sắp xếp giảm dần theo họ tên",
				sortByGpa(students));

		print("2. Tìm kiếm danh sách sinh viên có ĐTB > 8", findStudentWithGpa(students));

		print("3. Tìm kiếm toàn bộ các sinh viên NỮ", findStudentWithGender(students));

		print("4. Tìm kiếm sinh viên chỉ xuất hiện một lần trong student.txt. Biết rằng 2 sinh viên được"
				+ " phân biệt với nhau thông qua MSSV", findUniqueStudent(students));

	}

	private static List<Student2> getStudentFromFile(String pathname) {
		List<Student2> students = new ArrayList<>();
		Path path = Paths.get(pathname);
		
		if (!Files.exists(path)) {
            System.out.println("File not found: " + pathname);
        }
		
		List<String> lines;
		try {
			lines = Files.readAllLines(path);
			for (String line : lines) {
				String[] elements = line.split(", ");
				if (elements.length == 4) {
					String id = elements[0].trim();
					String fullname = elements[1].trim();
					double gpa = Double.parseDouble(elements[2].trim());
					Gender gender = Gender.valueOf(elements[3].trim().toUpperCase());
					students.add(new Student2(id, fullname, gpa, gender));
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return students;
	}

	private static List<Student2> sortByGpa(List<Student2> students) {
		return students.stream()
					   .sorted(Comparator.comparing(Student2::getGpa).thenComparing(Student2::getFullname, Comparator.reverseOrder()))
					   .collect(Collectors.toList());
	}

	private static List<Student2> findStudentWithGpa(List<Student2> students) {
		return students.stream()
					   .filter(student -> student.getGpa() > 8)
					   .collect(Collectors.toList());
	}

	private static List<Student2> findStudentWithGender(List<Student2> students) {
		return students.stream()
				       .filter(student -> student.getGender() == Gender.NU)
				       .collect(Collectors.toList());
	}

	private static List<String> findUniqueStudent(List<Student2> students) {
		return students.stream()
				       .collect(Collectors.groupingBy(Student2::getId, Collectors.counting()))
				       .entrySet()
				       .stream()
				       .filter(student -> student.getValue() == 1)
				       .map(Entry::getKey)
				       .collect(Collectors.toList());
	}
}