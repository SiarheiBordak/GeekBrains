package ru.geekbrains.gui;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class MessageAreaKeyListener implements KeyListener {
    private final JTextArea inputMessage;

    public MessageAreaKeyListener(JTextArea inputMessage) {
        this.inputMessage = inputMessage;
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_ENTER) {
            JTextArea showMessages = (JTextArea) e.getSource();

            if (!showMessages.getText().isEmpty()) {
                inputMessage.append(showMessages.getText() + "\n");
                showMessages.setText("");
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }
}
