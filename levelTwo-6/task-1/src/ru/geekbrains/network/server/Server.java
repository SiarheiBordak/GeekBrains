package ru.geekbrains.network.server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {
    private ServerSocket serverSocket;
    private DataOutputStream out;
    private DataInputStream in;

    public Server (){
        try {
            serverSocket = new ServerSocket(8989);
            System.out.println("Server is up, waiting for connection...");
            Socket socket = serverSocket.accept();
            System.out.println("Client connected:" + socket);

            in = new DataInputStream(socket.getInputStream());
            out = new DataOutputStream(socket.getOutputStream());

            new Thread(() -> {
                Scanner scanner = new Scanner(System.in);

                try {
                    while (true){
                        System.out.println("Type message to client...");
                        out.writeUTF(scanner.next());
                    }
                } catch (Exception e) {
                    System.out.println("Transmission closed.");
                }
            }).start();

            try{
                while (true){
                    String msgFromClient = in.readUTF();
                    System.out.println("Client message: " + msgFromClient);
                }
            } catch (IOException e){
                System.out.println("Connection closed.");
            }

        } catch (IOException e){
            throw new RuntimeException("SWW", e);
        }
    }
}