package ru.geekbrains.gui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DigitButtonListener implements ActionListener {
    private final JTextField textField;

    public DigitButtonListener(JTextField textField) {
        this.textField = textField;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton button = (JButton) e.getSource();

        textField.setText(textField.getText() + button.getText());
    }
}
