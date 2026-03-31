import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class DoctorAvilabilityFilter {

	public static void main(String[] args) {
		List<Doctor> doctors = Arrays.asList(new Doctor("Shiva", "Cardiology", true),
				new Doctor("Ananya", "Neurology", false), new Doctor("Rahul", "Orthopedics", true),
				new Doctor("Meera", "Dermatology", true), new Doctor("Arjun", "Pediatrics", false),
				new Doctor("Kavya", "Gynecology", true));
		List<Doctor> avilableDoctors = doctors.stream().filter(d -> d.isAvilable())
				.sorted(Comparator.comparing(Doctor::getSpecialty)).collect(Collectors.toList());

		System.out.println(avilableDoctors);
	}

}

class Doctor {
	private String name;
	private String specialty;
	private boolean avilable;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSpecialty() {
		return specialty;
	}

	public void setSpecialty(String specialty) {
		this.specialty = specialty;
	}

	public boolean isAvilable() {
		return avilable;
	}

	public void setAvilable(boolean avilable) {
		this.avilable = avilable;
	}

	public Doctor(String name, String specialty, boolean avilable) {
		super();
		this.name = name;
		this.specialty = specialty;
		this.avilable = avilable;
	}

	@Override
	public String toString() {
		return "Doctor [name=" + name + ", specialty=" + specialty + ", avilable=" + avilable + "]";
	}

}