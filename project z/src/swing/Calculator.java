package swing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Calculator {
    private JFrame frame;
    private JTextField numberField1, numberField2;
    private JButton addButton, subtractButton, multiplyButton, divideButton;

    public Calculator() {
        initializeUI();
    }

    private void initializeUI() {
        frame = new JFrame();
        frame.setTitle("Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        frame.setResizable(false);

        JPanel numberPanel = new JPanel();
        numberPanel.setLayout(new FlowLayout());

        numberField1 = new JTextField(10);
        numberField1.setHorizontalAlignment(JTextField.RIGHT);
        numberField2 = new JTextField(10);
        numberField2.setHorizontalAlignment(JTextField.RIGHT);

        numberPanel.add(numberField1);
        numberPanel.add(numberField2);

        addButton = new JButton("+");
        subtractButton = new JButton("-");
        multiplyButton = new JButton("*");
        divideButton = new JButton("/");

        addButton.addActionListener(new OperatorButtonListener('+'));
        subtractButton.addActionListener(new OperatorButtonListener('-'));
        multiplyButton.addActionListener(new OperatorButtonListener('*'));
        divideButton.addActionListener(new OperatorButtonListener('/'));

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(1, 4));
        buttonPanel.add(addButton);
        buttonPanel.add(subtractButton);
        buttonPanel.add(multiplyButton);
        buttonPanel.add(divideButton);

        frame.add(numberPanel, BorderLayout.NORTH);
        frame.add(buttonPanel, BorderLayout.CENTER);

        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private class OperatorButtonListener implements ActionListener {
        private final char operator;

        public OperatorButtonListener(char operator) {
            this.operator = operator;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            double number1 = Double.parseDouble(numberField1.getText());
            double number2 = Double.parseDouble(numberField2.getText());

            double result = 0.0;

            switch (operator) {
                case '+':
                    result = number1 + number2;
                    break;
                case '-':
                    result = number1 - number2;
                    break;
                case '*':
                    result = number1 * number2;
                    break;
                case '/':
                    result = number1 / number2;
                    break;
            }

            JOptionPane.showMessageDialog(frame, "Result: " + result);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new Calculator();
            }
        });
    }
}

