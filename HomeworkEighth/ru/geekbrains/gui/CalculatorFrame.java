package ru.geekbrains.gui;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;

public class CalculatorFrame extends JFrame {
    public CalculatorFrame() {
        setTitle("Calculator");
        setResizable(false);
        setSize(250, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        setLayout(new BorderLayout());
        
        JPanel top = new JPanel();
        top.setLayout(new BorderLayout());
        JTextField inputField = new JTextField();
        inputField.setEditable(false);
        inputField.setHorizontalAlignment(JTextField.RIGHT);
        inputField.setFont(inputField.getFont().deriveFont(Font.BOLD, 20));
        top.add(inputField, BorderLayout.CENTER);
        add(top, BorderLayout.NORTH);

        JPanel bottom = new JPanel();
        bottom.setLayout(new GridLayout(4, 2));
        add(bottom, BorderLayout.CENTER);

        DigitButtonListener digitButtonListener = new DigitButtonListener(inputField);
        
        for (int i = 0; i < 10; i++) {
            JButton button = new JButton(String.valueOf(i));
            button.addActionListener(digitButtonListener);
            //button.setPreferredSize(new Dimension(10,5));
            bottom.add(button);
        }

        JButton add = new JButton("+");
        add.addActionListener(digitButtonListener);
        bottom.add(add);

        JButton minus = new JButton("-");
        minus.addActionListener(digitButtonListener);
        bottom.add(minus);

        JButton multiply = new JButton("*");
        multiply.addActionListener(digitButtonListener);
        bottom.add(multiply);

        JButton divide = new JButton("/");
        divide.addActionListener(digitButtonListener);
        bottom.add(divide);

        ScriptEngineManager sem = new ScriptEngineManager();
        ScriptEngine eng = sem.getEngineByName("JavaScript");

        JButton result = new JButton("=");
        result.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String[] operands = inputField.getText().split("[+\\-/*]");
                String[] operators = inputField.getText().split("[0-9]+");

                double result = Double.parseDouble(operands[0]);

                for(int i = 1; i < operands.length; i++) {
                    if(operators[i].equals("+")) {
                        result += Double.parseDouble(operands[i]);
                    } else if (operators[i].equals("-")) {
                        result -= Double.parseDouble(operands[i]);
                    } else {
                        try {
                            result =  new BigDecimal(eng.eval(inputField.getText()).toString()).doubleValue();
                        } catch (ScriptException scriptException) {
                            scriptException.printStackTrace();
                        }
                    }
                }

                inputField.setText(String.valueOf(result));
            }
        });
        bottom.add(result);

        JButton clear = new JButton("C");
        clear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                inputField.setText("");
            }
        });
        bottom.add(clear);

        setVisible(true);
    }
}
