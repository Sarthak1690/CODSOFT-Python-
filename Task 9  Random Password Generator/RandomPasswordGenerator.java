import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Random;

public class RandomPasswordGenerator extends JFrame implements ActionListener {

    private JLabel passwordLengthLabel;
    private JTextField passwordLengthField;
    private JButton generatePasswordButton;
    private JTextArea passwordTextArea;

    public RandomPasswordGenerator() {
        createComponents();
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    private void createComponents() {
        setLayout(new FlowLayout());

        passwordLengthLabel = new JLabel("Password Length: ");
        add(passwordLengthLabel);

        passwordLengthField = new JTextField(10);
        add(passwordLengthField);

        generatePasswordButton = new JButton("Generate Password");
        generatePasswordButton.addActionListener(this);
        add(generatePasswordButton);

        passwordTextArea = new JTextArea(10, 20);
        add(new JScrollPane(passwordTextArea));
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == generatePasswordButton) {
            String passwordLengthString = passwordLengthField.getText();
            try {
                int passwordLength = Integer.parseInt(passwordLengthString);
                String password = generateRandomPassword(passwordLength);
                passwordTextArea.setText(password);
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Please enter a valid number for password length.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private String generateRandomPassword(int length) {
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!@#$%^&*()-_=+[]{}|;:',.<>?/";
        Random random = new Random();
        StringBuilder password = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            password.append(characters.charAt(random.nextInt(characters.length())));
        }
        return password.toString();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            RandomPasswordGenerator generator = new RandomPasswordGenerator();
            generator.setVisible(true);
        });
    }
}
