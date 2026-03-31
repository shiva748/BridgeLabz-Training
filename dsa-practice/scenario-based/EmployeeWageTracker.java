public class EmployeeWageTracker {

	public static void main(String[] args) {

		System.out.println("Welcome to Employee Wage Computation Program");

		int wagePerHour = 20;
		int fullDayHour = 8;
		int partTimeHour = 4;

		int maxWorkingDays = 20;
		int maxWorkingHours = 100;

		int totalWorkingDays = 0;
		int totalWorkingHours = 0;
		int totalSalary = 0;

		while (totalWorkingDays < maxWorkingDays && totalWorkingHours < maxWorkingHours) {

			totalWorkingDays++;

			int attendanceCheck = (int) (Math.random() * 3);
			int workingHours = 0;

			switch (attendanceCheck) {
			case 1:
				workingHours = fullDayHour;
				System.out.println("Day " + totalWorkingDays + ": Employee is Present (Full Day)");
				break;

			case 2:
				workingHours = partTimeHour;
				System.out.println("Day " + totalWorkingDays + ": Employee is Present (Part Time)");
				break;

			default:
				workingHours = 0;
				System.out.println("Day " + totalWorkingDays + ": Employee is Absent");
			}

			if (totalWorkingHours + workingHours > maxWorkingHours) {
				workingHours = maxWorkingHours - totalWorkingHours;
			}

			totalWorkingHours += workingHours;
			int dailyWage = workingHours * wagePerHour;
			totalSalary += dailyWage;

			System.out.println("Worked Hours: " + workingHours);
			System.out.println("Daily Wage: " + dailyWage);
		}

		System.out.println("Total Working Days: " + totalWorkingDays);
		System.out.println("Total Working Hours: " + totalWorkingHours);
		System.out.println("Total Employee Wage for the Month: " + totalSalary);
	}
}
