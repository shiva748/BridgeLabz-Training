import java.util.Scanner;

public class StudentScoreManager {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.print("Enter total students: ");
        int studentCount = input.nextInt();

        System.out.print("Enter subjects per student: ");
        int subjectCount = input.nextInt();

        int[][] marksTable = new int[studentCount][subjectCount];
        int[] studentAverages = new int[studentCount];

        int minMark = Integer.MAX_VALUE;
        int maxMark = Integer.MIN_VALUE;

        for (int student = 0; student < studentCount; student++) {
            System.out.println("Input marks for Student " + (student + 1));

            int total = 0;
            int subjectIndex = 0;

            while (subjectIndex < subjectCount) {
                int score = input.nextInt();

                if (score < 0) {
                    System.out.println("Invalid input. Re-enter mark:");
                    continue;
                }

                marksTable[student][subjectIndex] = score;
                total += score;

                if (score < minMark) minMark = score;
                if (score > maxMark) maxMark = score;

                subjectIndex++;
            }

            studentAverages[student] = total / subjectCount;
        }

        int classAverage = calculateClassAverage(studentAverages);

        System.out.println("\nClass Average Score: " + classAverage);
        System.out.println("Student Performance:");

        for (int i = 0; i < studentAverages.length; i++) {
            System.out.println("Student " + (i + 1) + " -> " +
                    studentAverages[i] + " (" +
                    performanceLabel(studentAverages[i], classAverage) + ")");
        }

        input.close();
    }

    private static int calculateClassAverage(int[] averages) {
        int total = 0;
        for (int value : averages) {
            total += value;
        }
        return total / averages.length;
    }

    private static String performanceLabel(int studentAvg, int classAvg) {
        if (studentAvg > classAvg) return "Above Average";
        if (studentAvg < classAvg) return "Below Average";
        return "Average";
    }
}
