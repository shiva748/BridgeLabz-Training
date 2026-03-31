public class Course {

	private String courseName;
	private int duration;
	private double fee;
	private static String instituteName;

	public void displayCourseDetails() {
		System.out.printf("The course %s of duration %d year will cost %.2f", courseName, duration, fee);
	}

	public static void updateInstituteName(String instituteName) {
		Course.instituteName = instituteName;
	}

	public static String getInstituteName() {
		return instituteName;
	}

	public static void setInstituteName(String instituteName) {
		Course.instituteName = instituteName;
	}

	public double getFee() {
		return fee;
	}

	public void setFee(double fee) {
		this.fee = fee;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
}