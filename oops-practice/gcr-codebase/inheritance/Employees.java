class Employee {
	String name;
	int id;
	double salary;

	public void displayDetails() {
		System.out.println("Employee Name: " + name);
		System.out.println("Employee ID: " + id);
		System.out.println("Salary: " + salary);
	}
}

class Manager extends Employee {
	int teamSize;

	@Override
	public void displayDetails() {
		System.out.println("Manager Name: " + name);
		System.out.println("Manager ID: " + id);
		System.out.println("Salary: " + salary);
		System.out.println("Team Size: " + teamSize);
	}
}

class Developer extends Employee {
	String programmingLanguage;

	@Override
	public void displayDetails() {
		System.out.println("Developer Name: " + name);
		System.out.println("Developer ID: " + id);
		System.out.println("Salary: " + salary);
		System.out.println("Programming Language: " + programmingLanguage);
	}
}

class Intern extends Employee {
	int durationMonths;

	@Override
	public void displayDetails() {
		System.out.println("Intern Name: " + name);
		System.out.println("Intern ID: " + id);
		System.out.println("Salary: " + salary);
		System.out.println("Internship Duration: " + durationMonths + " months");
	}
}

public class Employees {
	public static void main(String[] args) {
		Employee manager = new Manager();
		manager.name = "Rahul";
		manager.id = 101;
		manager.salary = 80000;

		Employee developer = new Developer();
		developer.name = "Anita";
		developer.id = 102;
		developer.salary = 60000;

		Employee intern = new Intern();
		intern.name = "Amit";
		intern.id = 103;
		intern.salary = 15000;

		manager.displayDetails();
		developer.displayDetails();
		intern.displayDetails();
	}
}
