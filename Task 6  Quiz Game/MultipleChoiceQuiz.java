import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MultipleChoiceQuiz extends JFrame {
    private static final String[] questions = {
            "What is the capital of France?",
            "Which planet is known as the Red Planet?",
            "What is the largest mammal in the world?",
            "Who wrote 'Romeo and Juliet'?"
    };

    private static final String[][] choices = {
            {"Paris", "Berlin", "London", "Madrid"},
            {"Mars", "Venus", "Jupiter", "Saturn"},
            {"Elephant", "Blue Whale", "Giraffe", "Hippopotamus"},
            {"William Shakespeare", "Jane Austen", "Charles Dickens", "Mark Twain"}
    };

    private static final char[] correctAnswers = {'A', 'A', 'B', 'A'};

    private int currentQuestionIndex;
    private char selectedAnswer;

    private JLabel questionLabel;
    private ButtonGroup answerGroup;
    private JRadioButton[] answerButtons;
    private JButton nextButton;

    public MultipleChoiceQuiz() {
        super("Multiple Choice Quiz");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        setLayout(new BorderLayout());

        questionLabel = new JLabel("", JLabel.CENTER);
        questionLabel.setFont(new Font("Arial", Font.BOLD, 14));

        JPanel choicesPanel = new JPanel();
        choicesPanel.setLayout(new GridLayout(4, 1));

        answerGroup = new ButtonGroup();
        answerButtons = new JRadioButton[4];

        for (int i = 0; i < 4; i++) {
            answerButtons[i] = new JRadioButton();
            answerButtons[i].setFont(new Font("Arial", Font.PLAIN, 12));
            answerGroup.add(answerButtons[i]);
            choicesPanel.add(answerButtons[i]);
        }

        nextButton = new JButton("Next");
        nextButton.addActionListener(new NextButtonListener());

        add(questionLabel, BorderLayout.NORTH);
        add(choicesPanel, BorderLayout.CENTER);
        add(nextButton, BorderLayout.SOUTH);

        startQuiz();
    }

    private void startQuiz() {
        currentQuestionIndex = 0;
        displayQuestion(currentQuestionIndex);
    }

    private void displayQuestion(int index) {
        questionLabel.setText(questions[index]);

        for (int i = 0; i < 4; i++) {
            answerButtons[i].setText(choices[index][i]);
            answerButtons[i].setSelected(false);
        }
    }

    private class NextButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            for (int i = 0; i < 4; i++) {
                if (answerButtons[i].isSelected()) {
                    selectedAnswer = (char) ('A' + i);
                    break;
                }
            }

            if (selectedAnswer == 0) {
                JOptionPane.showMessageDialog(null, "Please select an answer.", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                checkAnswer();
            }
        }
    }

    private void checkAnswer() {
        if (selectedAnswer == correctAnswers[currentQuestionIndex]) {
            JOptionPane.showMessageDialog(null, "Correct! Well done!");
        } else {
            JOptionPane.showMessageDialog(null, "Incorrect. The correct answer is " +
                    correctAnswers[currentQuestionIndex] + ": " + choices[currentQuestionIndex][correctAnswers[currentQuestionIndex] - 'A']);
        }

        currentQuestionIndex++;

        if (currentQuestionIndex < questions.length) {
            displayQuestion(currentQuestionIndex);
        } else {
            JOptionPane.showMessageDialog(null, "Quiz completed. Thanks for playing!");
            System.exit(0);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            MultipleChoiceQuiz quiz = new MultipleChoiceQuiz();
            quiz.setVisible(true);
        });
    }
}
