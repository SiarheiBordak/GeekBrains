package ru.geekbrains.network.client;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    private Socket socket;
    private DataInputStream in;
    private DataOutputStream out;

    public Client() {
        try {
            socket = new Socket("localhost", 8989);
            in = new DataInputStream(socket.getInputStream());
            out = new DataOutputStream(socket.getOutputStream());

            new Thread(() -> {
                Scanner scanner = new Scanner(System.in);

                try {
                    while (true){
                        System.out.println("Please type your message...");
                        out.writeUTF(scanner.next());
                    }
                } catch (Exception e) {
                    System.out.println("Transmission closed.");
                }
            }).start();

            try{
                while (true) {
                    String msgFromServer = in.readUTF();
                    System.out.println("Server message: " + msgFromServer);
                }
            } catch (IOException e) {
                System.out.println("Connection closed.");
            }

        } catch (IOException e){
            throw new RuntimeException("SWW", e);
        }
    }
}