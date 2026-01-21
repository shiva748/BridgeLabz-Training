import java.util.Scanner;

public class StudentGradeAnalyzer {

    static String[] studentNames;
    static int[] studentIds;
    static Integer[][] grades;

    static int students;
    static int subjects;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {
            System.out.print("Enter number of students: ");
            students = sc.nextInt();

            System.out.print("Enter number of subjects: ");
            subjects = sc.nextInt();

            studentNames = new String[students];
            studentIds = new int[students];
            grades = new Integer[students][subjects];

            sc.nextLine();

            for (int i = 0; i < students; i++) {
                System.out.println("\nEnter details for Student " + (i + 1));

                System.out.print("Name: ");
                studentNames[i] = sc.nextLine();

                System.out.print("ID: ");
                studentIds[i] = sc.nextInt();

                for (int j = 0; j < subjects; j++) {
                    try {
                        System.out.print("Grade for Subject " + (j + 1) + ": ");
                        int grade = sc.nextInt();

                        if (grade < 0 || grade > 100) {
                            throw new IllegalArgumentException("Grade must be between 0 and 100");
                        }

                        grades[i][j] = grade;
                    } catch (Exception e) {
                        System.out.println("Invalid input. Grade skipped.");
                        grades[i][j] = null;
                        sc.nextLine();
                    }
                }
                sc.nextLine();
            }

            calculateStudentTotalsAndAverages();
            calculateHighestPerSubject();
            calculateClassAverage();

        } catch (Exception e) {
            System.out.println("Input error: " + e.getMessage());
        } finally {
            sc.close();
        }
    }

    static void calculateStudentTotalsAndAverages() {
        System.out.println("\n--- Student Totals & Averages ---");

        for (int i = 0; i < students; i++) {
            int total = 0;
            int count = 0;

            for (int j = 0; j < subjects; j++) {
                if (grades[i][j] != null) {
                    total += grades[i][j];
                    count++;
                }
            }

            if (count == 0) {
                System.out.println(studentNames[i] + " (ID: " + studentIds[i] + ") - No grades available");
            } else {
                double average = (double) total / count;
                System.out.println(studentNames[i] + " (ID: " + studentIds[i] +
                        ") Total: " + total + ", Average: " + average);
            }
        }
    }

    static void calculateHighestPerSubject() {
        System.out.println("\n--- Highest Grade per Subject ---");

        for (int j = 0; j < subjects; j++) {
            int highest = -1;

            for (int i = 0; i < students; i++) {
                if (grades[i][j] != null && grades[i][j] > highest) {
                    highest = grades[i][j];
                }
            }

            if (highest == -1) {
                System.out.println("Subject " + (j + 1) + ": No grades available");
            } else {
                System.out.println("Subject " + (j + 1) + ": Highest Grade = " + highest);
            }
        }
    }

    static void calculateClassAverage() {
        int total = 0;
        int count = 0;

        for (int i = 0; i < students; i++) {
            for (int j = 0; j < subjects; j++) {
                if (grades[i][j] != null) {
                    total += grades[i][j];
                    count++;
                }
            }
        }

        System.out.println("\n--- Class Average ---");
        if (count == 0) {
            System.out.println("No grades available to calculate class average.");
        } else {
            double classAverage = (double) total / count;
            System.out.println("Overall Class Average: " + classAverage);
        }
    }
}
