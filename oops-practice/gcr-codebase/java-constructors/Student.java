public class Student {
	public int rollNumber;
	protected String name;
	private double CGPA;

	public Student(int rollNumber, String name, double CGPA) {
		this.rollNumber = rollNumber;
		this.name = name;
		this.CGPA = CGPA;
	}

	public double getCGPA() {
		return CGPA;
	}

	public void setCGPA(double CGPA) {
		this.CGPA = CGPA;
	}

	public void displayStudent() {
		System.out.println("Roll Number: " + rollNumber);
		System.out.println("Name: " + name);
		System.out.println("CGPA: " + CGPA);
	}
}

class PostgraduateStudent extends Student {

	private String specialization;

	public PostgraduateStudent(int rollNumber, String name, double CGPA, String specialization) {
		super(rollNumber, name, CGPA);
		this.specialization = specialization;
	}

	public void displayPostgraduateStudent() {
		System.out.println("Roll Number: " + rollNumber);
		System.out.println("Name: " + name);
		System.out.println("CGPA: " + getCGPA());
		System.out.println("Specialization: " + specialization);
	}
}
