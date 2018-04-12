package class10.Assignment_8;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class SimpleCalculator extends JFrame implements ActionListener {
    private JFrame frame;
    private JTextField jTextField;
    private String[] bottonName;
    private JButton button;


    public SimpleCalculator() {
        frame = new JFrame();
        addComponents();
        setLayout();
        makeItVisible();

    }

    private void addComponents() {
        setTitle("Calculator");
        String[] keyName = {
                "7", "8", "9", "/",
                "4", "5", "6", "*",
                "1", "2", "3", "-",
                "0", ".", "c", "+",
                "=",};
        bottonName = keyName;
    }

    private void setLayout() {
        setLayout(new FlowLayout());
        jTextField = new JTextField(20);

        jTextField.setEditable(false);
        JPanel jPanel = new JPanel();

        jPanel.setLayout(new GridLayout(5, 4, 10, 10));

        frame.add(jTextField, BorderLayout.NORTH);
        frame.add(jPanel, BorderLayout.CENTER);

        jTextField.setPreferredSize(new Dimension(50, 50));
        jTextField.setFont(new Font("TimesRoman", Font.BOLD, 20));
        for (String name : bottonName) {
            button = new JButton(name);
            jPanel.add(button);
            button.addActionListener(this);
        }

        jPanel.setPreferredSize(new Dimension(250, 300));

    }

    private void makeItVisible() {
        frame.setSize(500, 500);
        frame.setVisible(true);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private double calculateWork(String input) {
        String s = jTextField.getText();
        double result = 0;
        ArrayList<Character> operatorList = new ArrayList<Character>();
        ArrayList<Double> numList = new ArrayList<Double>();
        int numListCounter = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '+' || s.charAt(i) == '-' || s.charAt(i) == '*' || s.charAt(i) == '/') {
                numList.add(Double.parseDouble(s.substring(numListCounter, i)));
                operatorList.add(s.charAt(i));
                numListCounter = i + 1;
            }

        }
        numList.add(Double.parseDouble(s.substring(numListCounter)));//add last number
        if (operatorList.contains('/') || operatorList.contains('*')) {
            for (int i = 0; i < operatorList.size(); i++) {
                if (operatorList.get(i).equals('*')) {
                    result = (double) (numList.get(i) * numList.get(i + 1));
                } else if (operatorList.get(i).equals('/')) {
                    result = (double) (numList.get(i) / numList.get(i + 1));
                } else
                    continue;
                numList.set(i, result);
                numList.remove(i + 1);
                operatorList.remove(i);
                i--;
            }
        }
        for (int i = 0; i < operatorList.size(); i++) {
            if (operatorList.get(i).equals('+')) {
                result = (double) (numList.get(i) + numList.get(i + 1));
            } else if (operatorList.get(i).equals('-')) {
                result = (double) (numList.get(i) - numList.get(i + 1));
            } else
                continue;
            numList.set(i, result);
            numList.remove(i + 1);
            operatorList.remove(i);
            i--;
        }
        return result;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        JButton mouseAction = (JButton) ae.getSource();
        if (mouseAction.getText().equals("c"))
            jTextField.setText("");
        else if (!mouseAction.getText().equals("=")) {
            jTextField.setText(jTextField.getText() + mouseAction.getText());
        } else if (mouseAction.getText().equals("=")) {
            double result = calculateWork(jTextField.getText());
            jTextField.setText(result + "");
        }
    }


    public static void main(String[] args) {
        SimpleCalculator cal = new SimpleCalculator();

    }
}