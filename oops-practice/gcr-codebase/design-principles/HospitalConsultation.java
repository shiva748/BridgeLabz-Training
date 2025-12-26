import java.util.ArrayList;
import java.util.List;

class Patient {
	private String patientName;
	private List<Doctor> consultedDoctors = new ArrayList<>();

	Patient(String patientName) {
		this.patientName = patientName;
	}

	void addDoctor(Doctor doctor) {
		if (!consultedDoctors.contains(doctor)) {
			consultedDoctors.add(doctor);
		}
	}

	String getPatientName() {
		return patientName;
	}
}

class Doctor {
	private String doctorName;
	private List<Patient> patients = new ArrayList<>();

	Doctor(String doctorName) {
		this.doctorName = doctorName;
	}

	void consult(Patient patient) {
		if (!patients.contains(patient)) {
			patients.add(patient);
			patient.addDoctor(this);
		}
	}

	String getDoctorName() {
		return doctorName;
	}
}

class Hospital {
	private String hospitalName;
	private List<Doctor> doctors = new ArrayList<>();
	private List<Patient> patients = new ArrayList<>();

	Hospital(String hospitalName) {
		this.hospitalName = hospitalName;
	}

	void addDoctor(Doctor doctor) {
		doctors.add(doctor);
	}

	void addPatient(Patient patient) {
		patients.add(patient);
	}

	String getHospitalName() {
		return hospitalName;
	}
}

public class HospitalConsultation {
	public static void main(String[] args) {
		Hospital cityHospital = new Hospital("City Hospital");

		Doctor drMehta = new Doctor("Dr. Mehta");
		Doctor drRao = new Doctor("Dr. Rao");

		Patient aman = new Patient("Aman");
		Patient priya = new Patient("Priya");

		cityHospital.addDoctor(drMehta);
		cityHospital.addDoctor(drRao);

		cityHospital.addPatient(aman);
		cityHospital.addPatient(priya);

		drMehta.consult(aman);
		drMehta.consult(priya);
		drRao.consult(aman);
	}
}
