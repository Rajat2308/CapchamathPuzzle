import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class CaptchaMathPuzzle extends JFrame {

    private JLabel num1Label, operatorLabel, num2Label, resultLabel;
    private JTextField resultTextField;
    private JButton submitButton;
    private int num1, num2, result;

    public CaptchaMathPuzzle() {
        // Initialize the GUI components
        num1Label = new JLabel();
        operatorLabel = new JLabel();
        num2Label = new JLabel();
        resultLabel = new JLabel();
        resultTextField = new JTextField();
        submitButton = new JButton("Submit");

        // Generate the math problem for the CAPTCHA
        generateMathProblem();

        // Add the components to the JFrame
        add(num1Label);
        add(operatorLabel);
        add(num2Label);
        add(resultLabel);
        add(resultTextField);
        add(submitButton);

        // Set the properties of the components
        num1Label.setFont(new Font("Arial", Font.PLAIN, 24));
        num1Label.setBounds(175, 140, 150, 25);
        operatorLabel.setFont(new Font("Arial", Font.PLAIN, 24));
        operatorLabel.setBounds(205, 140, 150, 25);
        num2Label.setFont(new Font("Arial", Font.PLAIN, 24));
        num2Label.setBounds(230, 140, 150, 25);
        resultLabel.setFont(new Font("Arial", Font.PLAIN, 24));
        resultLabel.setBounds(260, 140, 250, 25);
        resultTextField.setFont(new Font("Arial", Font.PLAIN, 24));
        resultTextField.setBounds(260, 140, 250, 25);
        submitButton.setFont(new Font("Arial", Font.PLAIN, 24));
        submitButton.setBounds(225, 160, 150, 25);
        resultTextField.setColumns(10);

        // Add an action listener to the submit button
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Check if the result entered by the user is correct
                int userResult = Integer.parseInt(resultTextField.getText());
                if (userResult == result) {
                    JOptionPane.showMessageDialog(null, "CAPTCHA Passed!");
                } else {
                    JOptionPane.showMessageDialog(null, "CAPTCHA Failed!");
                    generateMathProblem();
                    resultTextField.setText("");
                }
            }
        });

        // Set the properties of the JFrame
        setTitle("CAPTCHA Math Puzzle");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setSize(1000, 600);
        setVisible(true);

    }

    private void generateMathProblem() {
        Random rand = new Random();

        // Generate two random numbers between 1 and 10
        num1 = rand.nextInt(10) + 1;
        num2 = rand.nextInt(10) + 1;

        // Generate a random operator (+ or -)
        char operator = rand.nextBoolean() ? '+' : '-' ;

        // Calculate the result of the math problem
        if (operator == '+') {
            result = num1 + num2;
        } else
        {
            result = num1 - num2;
        }

        // Update the labels with the math problem
        num1Label.setText(String.valueOf(num1));
        operatorLabel.setText(String.valueOf(operator));
        num2Label.setText(String.valueOf(num2));
        resultLabel.setText("=");
    }

    public static void main(String[] args) {
        new CaptchaMathPuzzle();
    }
}
