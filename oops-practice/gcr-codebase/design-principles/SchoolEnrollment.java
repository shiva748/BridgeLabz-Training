import java.util.ArrayList;
import java.util.List;

class Course {
	private String courseName;
	private List<Student> enrolledStudents = new ArrayList<>();

	Course(String courseName) {
		this.courseName = courseName;
	}

	void addStudent(Student student) {
		if (!enrolledStudents.contains(student)) {
			enrolledStudents.add(student);
		}
	}

	List<Student> getStudents() {
		return enrolledStudents;
	}

	String getCourseName() {
		return courseName;
	}
}

class Student {
	private String studentName;
	private List<Course> courses = new ArrayList<>();

	Student(String studentName) {
		this.studentName = studentName;
	}

	void enroll(Course course) {
		if (!courses.contains(course)) {
			courses.add(course);
			course.addStudent(this);
		}
	}

	List<Course> getCourses() {
		return courses;
	}

	String getStudentName() {
		return studentName;
	}
}

class School {
	private String schoolTitle;
	private List<Student> students = new ArrayList<>();

	School(String schoolTitle) {
		this.schoolTitle = schoolTitle;
	}

	void admitStudent(Student student) {
		students.add(student);
	}

	List<Student> getStudents() {
		return students;
	}

	String getSchoolTitle() {
		return schoolTitle;
	}
}

public class SchoolEnrollment {
	public static void main(String[] args) {
		School greenValley = new School("Green Valley School");

		Student arjun = new Student("Arjun");
		Student neha = new Student("Neha");

		Course math = new Course("Mathematics");
		Course science = new Course("Science");

		greenValley.admitStudent(arjun);
		greenValley.admitStudent(neha);

		arjun.enroll(math);
		arjun.enroll(science);
		neha.enroll(science);
	}
}
