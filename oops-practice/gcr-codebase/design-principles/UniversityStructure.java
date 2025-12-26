import java.util.ArrayList;
import java.util.List;

class Faculty {
	private String facultyName;

	Faculty(String facultyName) {
		this.facultyName = facultyName;
	}

	String getFacultyName() {
		return facultyName;
	}
}

class Department {
	private String departmentName;

	Department(String departmentName) {
		this.departmentName = departmentName;
	}

	String getDepartmentName() {
		return departmentName;
	}
}

class University {
	private String universityName;
	private List<Department> departments = new ArrayList<>();
	private List<Faculty> faculties = new ArrayList<>();

	University(String universityName) {
		this.universityName = universityName;
	}

	void addDepartment(String name) {
		departments.add(new Department(name));
	}

	void addFaculty(Faculty faculty) {
		faculties.add(faculty);
	}

	void closeUniversity() {
		departments.clear();
	}

	List<Department> getDepartments() {
		return departments;
	}

	List<Faculty> getFaculties() {
		return faculties;
	}

	String getUniversityName() {
		return universityName;
	}
}

public class UniversityStructure {
	public static void main(String[] args) {
		Faculty profA = new Faculty("Prof. Sharma");
		Faculty profB = new Faculty("Prof. Iyer");

		University techUni = new University("Tech University");

		techUni.addDepartment("Computer Science");
		techUni.addDepartment("Mechanical Engineering");

		techUni.addFaculty(profA);
		techUni.addFaculty(profB);

		techUni.closeUniversity();
	}
}
