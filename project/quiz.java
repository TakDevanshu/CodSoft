import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

class Question {
    String question;
    String[] options;
    String answer;

    public Question(String question, String[] options, String answer) {
        this.question = question;
        this.options = options;
        this.answer = answer;
    }
}

public class quiz {
    private static int score = 0;
    private static final int TIME_LIMIT = 10; // time limit in seconds
    private static boolean timeUp = false;
    private static String userAnswer = "";

    public static void main(String[] args) {
        List<Question> questions = new ArrayList<>();
        questions.add(new Question("What is the tallest mountain in the world?", new String[]{"A. K2", "B. Mount Everest", "C. Denali", "D. Mount Kilimanjaro"}, "B"));
        questions.add(new Question("What is the largest planet in our solar system?", new String[]{"A. Earth", "B. Venus", "C. Mars", "D. Jupiter"}, "D"));
        questions.add(new Question("What is the world's largest ocean?", new String[]{"A. Atlantic Ocean", "B.Indian Ocean", "C. Pacific Ocean", "D.Southern Ocean"}, "B"));
        questions.add(new Question("How many bones are there in the adult human body?", new String[]{"A. 206", "B. 256", "C. 216", "D. 232"}, "A"));
        runQuiz(questions);
    }

    public static void runQuiz(List<Question> questions) {
        Scanner scanner = new Scanner(System.in);
        List<String[]> answersSummary = new ArrayList<>();

        for (int i = 0; i < questions.size(); i++) {
            Question question = questions.get(i);
            System.out.println("\nQuestion " + (i + 1) + ": " + question.question);
            for (String option : question.options) {
                System.out.println(option);
            }

            Timer timer = new Timer();
            TimerTask task = new TimerTask() {
                @Override
                public void run() {
                    timeUp = true;
                }
            };

            timer.schedule(task, TIME_LIMIT * 1000);
            timeUp = false;
            userAnswer = "";

            while (!timeUp) {
                System.out.print("Your answer (A/B/C/D): ");
                userAnswer = scanner.nextLine().toUpperCase();
                if (userAnswer.matches("[ABCD]")) {
                    break;
                } else {
                    System.out.println("Invalid input. Please enter A, B, C, or D.");
                }
            }
            timer.cancel();

            if (timeUp) {
                System.out.println("\nTime's up!");
                userAnswer = "No Answer";
            }

            if (userAnswer.equals(question.answer)) {
                System.out.println("Correct!");
                score++;
                answersSummary.add(new String[]{String.valueOf(i + 1), "Correct", userAnswer, question.answer});
            } else {
                System.out.println("Wrong! The correct answer was " + question.answer + ".");
                answersSummary.add(new String[]{String.valueOf(i + 1), "Incorrect", userAnswer, question.answer});
            }
        }

        // Display final results
        System.out.println("\nQuiz Over!");
        System.out.println("Your final score is " + score + "/" + questions.size() + ".");
        System.out.println("\nSummary of answers:");
        for (String[] summary : answersSummary) {
            System.out.println("Question " + summary[0] + ": " + summary[1] + " (Your answer: " + summary[2] + ", Correct answer: " + summary[3] + ")");
        }

        scanner.close();
    }
}

