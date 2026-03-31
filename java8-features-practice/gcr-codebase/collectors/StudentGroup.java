import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StudentGroup {
	public static void main(String... args) {

		List<Student> students = Arrays.asList(new Student("Shiva", 2), new Student("Anu", 2), new Student("Mamta", 1),
				new Student("Diya", 3), new Student("Richa", 3), new Student("Deelip", 1));

		Map<Integer, List<String>> groupedStudents = students.stream().collect(
				Collectors.groupingBy(Student::getGrade, Collectors.mapping(Student::getName, Collectors.toList())));

		System.out.println(groupedStudents);
	}
}

class Student {
	private String name;
	private int grade;

	public String getName() {
		return name;
	}

	public int getGrade() {
		return grade;
	}

	public Student(String name, int grade) {
		this.name = name;
		this.grade = grade;
	}
}
