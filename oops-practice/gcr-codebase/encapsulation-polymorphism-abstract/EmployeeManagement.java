import java.util.ArrayList;
import java.util.List;

interface Department {
	void assignDepartment(String dept);

	String getDepartmentDetails();
}

abstract class Employee implements Department {
	private int employeeId;
	private String name;
	private double baseSalary;
	private String department;

	Employee(int employeeId, String name, double baseSalary) {
		this.employeeId = employeeId;
		this.name = name;
		this.baseSalary = baseSalary;
	}

	public int getEmployeeId() {
		return employeeId;
	}

	public String getName() {
		return name;
	}

	public double getBaseSalary() {
		return baseSalary;
	}

	public void assignDepartment(String dept) {
		department = dept;
	}

	public String getDepartmentDetails() {
		return department;
	}

	abstract double calculateSalary();

	void displayDetails() {
		System.out.println(employeeId + " " + name + " " + calculateSalary() + " " + department);
	}
}

class FullTimeEmployee extends Employee {
	FullTimeEmployee(int id, String name, double salary) {
		super(id, name, salary);
	}

	double calculateSalary() {
		return getBaseSalary();
	}
}

class PartTimeEmployee extends Employee {
	private int hours;

	PartTimeEmployee(int id, String name, double rate, int hours) {
		super(id, name, rate);
		this.hours = hours;
	}

	double calculateSalary() {
		return getBaseSalary() * hours;
	}
}

public class EmployeeManagement {
	public static void main(String[] args) {
		List<Employee> employees = new ArrayList<>();

		Employee e1 = new FullTimeEmployee(1, "Amit", 40000);
		Employee e2 = new PartTimeEmployee(2, "Ravi", 500, 40);

		e1.assignDepartment("HR");
		e2.assignDepartment("IT");

		employees.add(e1);
		employees.add(e2);

		for (Employee e : employees) {
			e.displayDetails();
		}
	}
}
