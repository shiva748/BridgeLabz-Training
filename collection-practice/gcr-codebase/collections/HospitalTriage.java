import java.util.PriorityQueue;
import java.util.Scanner;

class Patient {
    String name;
    int severity;

    Patient(String name, int severity) {
        this.name = name;
        this.severity = severity;
    }
}

public class HospitalTriage {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        PriorityQueue<Patient> triageQueue =
                new PriorityQueue<>((p1, p2) -> p2.severity - p1.severity);

        System.out.print("Enter number of patients: ");
        int total = scanner.nextInt();
        scanner.nextLine(); // consume newline

        for (int i = 0; i < total; i++) {
            System.out.print("Enter patient name: ");
            String pname = scanner.nextLine();

            System.out.print("Enter severity level: ");
            int level = scanner.nextInt();
            scanner.nextLine();

            triageQueue.add(new Patient(pname, level));
        }

        System.out.println("\nTreatment Order:");
        while (!triageQueue.isEmpty()) {
            Patient current = triageQueue.poll();
            System.out.println(current.name + " (Severity: " + current.severity + ")");
        }

        scanner.close();
    }
}
