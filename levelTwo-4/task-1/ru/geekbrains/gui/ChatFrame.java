package ru.geekbrains.gui;

import javax.swing.*;
import java.awt.*;

public class ChatFrame extends JFrame {
    public ChatFrame() throws HeadlessException {
        setTitle("Chat");
        setResizable(false);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        setLayout(new BorderLayout());
        setSize(600, 700);
        setLocationRelativeTo(null);

        JPanel top = new JPanel();
        top.setBackground(Color.GRAY);
        add(top, BorderLayout.CENTER);

        JTextArea showMessages = new JTextArea(38, 48);
        showMessages.setBackground(Color.GRAY);
        showMessages.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(showMessages);
        top.add(scrollPane);

        JPanel bottom = new JPanel();
        add(bottom, BorderLayout.SOUTH);
        bottom.setBackground(Color.lightGray);

        JTextArea inputMessage = new JTextArea(1, 35);
        bottom.add(inputMessage);
        inputMessage.addKeyListener(new MessageAreaKeyListener(showMessages));

        JButton dispatch = new JButton(">>>");
        dispatch.addActionListener(e -> {
            if (!inputMessage.getText().isEmpty()) {
                showMessages.append(inputMessage.getText() + "\n");
                inputMessage.setText("");
            }
        });
        bottom.add(dispatch);

        setVisible(true);
    }
}
