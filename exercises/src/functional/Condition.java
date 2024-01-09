package functional;

import bean.Student;

@FunctionalInterface
public interface Condition {
	boolean check(Student student);
}