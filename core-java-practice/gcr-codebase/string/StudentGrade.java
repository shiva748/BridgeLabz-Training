import java.util.Random;

public class StudentGrade{
    public static int[][] generateScores(int students) {
        Random random = new Random();
        int[][] scores = new int[students][3];
        for (int i = 0; i < students; i++) {
            scores[i][0] = random.nextInt(51) + 50;
            scores[i][1] = random.nextInt(51) + 50;
            scores[i][2] = random.nextInt(51) + 50;
        }
        return scores;
    }
    public static double[][] calculateResults(int[][] scores) {
        double[][] results = new double[scores.length][3];
        for (int i = 0; i < scores.length; i++) {
            int total = scores[i][0] + scores[i][1] + scores[i][2];
            double average = total / 3.0;
            double percentage = (total / 300.0) * 100;
            average = Math.round(average * 100.0) / 100.0;
            percentage = Math.round(percentage * 100.0) / 100.0;
            results[i][0] = total;
            results[i][1] = average;
            results[i][2] = percentage;
        }
        return results;
    }
    public static String[] calculateGrades(double[][] results) {
        String[] grades = new String[results.length];
        for (int i = 0; i < results.length; i++) {
            double percentage = results[i][2];
            if (percentage >= 80)
                grades[i] = "A";
            else if (percentage >= 70)
                grades[i] = "B";
            else if (percentage >= 60)
                grades[i] = "C";
            else if (percentage >= 50)
                grades[i] = "D";
            else if (percentage >= 40)
                grades[i] = "E";
            else
                grades[i] = "R";
        }
        return grades;
    }
    public static void displayScorecard(int[][] scores, double[][] results, String[] grades) {
        System.out.println("Stu\tPhy\tChem\tMath\tTotal\tAvg\t%\tGrade");
        System.out.println("-------------------------------------------------------");
        for (int i = 0; i < scores.length; i++) {
            System.out.println(
                    (i + 1) + "\t" +
                    scores[i][0] + "\t" +
                    scores[i][1] + "\t" +
                    scores[i][2] + "\t" +
                    (int) results[i][0] + "\t" +
                    results[i][1] + "\t" +
                    results[i][2] + "\t" +
                    grades[i]
            );
        }
    }
    public static void main(String[] args) {
        int students = 5;
        int[][] scores = generateScores(students);
        double[][] results = calculateResults(scores);
        String[] grades = calculateGrades(results);
        displayScorecard(scores, results, grades);
    }
}
