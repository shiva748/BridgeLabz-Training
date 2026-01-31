import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class DepartmentAverageSalary {

	public static void main(String[] args) {

		List<Employee> employees = Arrays.asList(new Employee("Shiva", "IT", 75000), new Employee("Anu", "HR", 50000),
				new Employee("Ravi", "Finance", 65000), new Employee("Mamta", "IT", 80000),
				new Employee("Diya", "HR", 52000), new Employee("Richa", "Finance", 70000),
				new Employee("Amit", "IT", 78000), new Employee("Kavya", "HR", 54000),
				new Employee("Suresh", "Finance", 72000), new Employee("Neha", "IT", 76000));

		Map<String, Double> averageSalaryByDepartment = employees.stream().collect(
				Collectors.groupingBy(Employee::getDepartment, Collectors.averagingDouble(Employee::getSalary)));

		System.out.println(averageSalaryByDepartment);
	}
}

class Employee {
	private String name;
	private String department;
	private double salary;

	public String getName() {
		return name;
	}

	public String getDepartment() {
		return department;
	}

	public double getSalary() {
		return salary;
	}

	public Employee(String name, String department, double salary) {
		this.name = name;
		this.department = department;
		this.salary = salary;
	}
}
