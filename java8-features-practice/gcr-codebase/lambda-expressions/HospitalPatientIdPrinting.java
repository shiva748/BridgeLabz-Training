import java.util.Arrays;
import java.util.List;

class Patient {
    String id;
    String name;

    Patient(String id, String name) {
        this.id = id;
        this.name = name;
    }

    String getId() {
        return id;
    }

    String getName() {
        return name;
    }

    @Override
    public String toString() {
        return id + " - " + name;
    }
}

public class HospitalPatientIdPrinting {

    public static void main(String[] args) {

        List<Patient> patients = Arrays.asList(
                new Patient("P-101", "Amit"),
                new Patient("P-102", "Neha"),
                new Patient("P-103", "Rohit"),
                new Patient("P-104", "Kavya"));

        patients.forEach(System.out::println);
    }
}
