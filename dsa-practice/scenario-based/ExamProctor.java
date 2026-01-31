import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import java.util.function.Function;

class ExamProctor {

    private Stack<Integer> navigationStack = new Stack<>();
    private Map<Integer, String> answers = new HashMap<>();

    public void visitQuestion(int questionId) {
        navigationStack.push(questionId);
    }

    public void submitAnswer(int questionId, String answer) {
        answers.put(questionId, answer);
    }

    public int calculateScore(Map<Integer, String> correctAnswers) {
        Function<Map<Integer, String>, Integer> scoringLogic = ans -> {
            int score = 0;
            for (Map.Entry<Integer, String> entry : ans.entrySet()) {
                if (entry.getValue().equals(correctAnswers.get(entry.getKey()))) {
                    score++;
                }
            }
            return score;
        };
        return scoringLogic.apply(answers);
    }

    public static void main(String[] args) {
        ExamProctor exam = new ExamProctor();

        exam.visitQuestion(1);
        exam.visitQuestion(2);
        exam.visitQuestion(3);

        exam.submitAnswer(1, "A");
        exam.submitAnswer(2, "B");
        exam.submitAnswer(3, "C");

        Map<Integer, String> correctAnswers = new HashMap<>();
        correctAnswers.put(1, "A");
        correctAnswers.put(2, "C");
        correctAnswers.put(3, "C");

        int score = exam.calculateScore(correctAnswers);
        System.out.println("Final Score: " + score);
    }
}
