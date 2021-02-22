package ru.geekbrains.chat.server.auth;

import ru.geekbrains.chat.server.Server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

/**
 * 1. Unique login (accept)
 * 2. Unknown user login (reject)
 * 3. Already logged-in (reject)
 * 4. Receive message to itself
 * 5. Broadcast message upon success login + basic messages
 */
public class ClientHandler {
    private final Server server;
    private final Socket socket;
    private final DataInputStream in;
    private final DataOutputStream out;
    private String name;

    public ClientHandler(Server server, Socket socket) {
        try {
            this.server = server;
            this.socket = socket;
            this.in = new DataInputStream(socket.getInputStream());
            this.out = new DataOutputStream(socket.getOutputStream());

            new Thread(new Runnable() {
                @Override
                public void run() {
                    listen();
                }
            }).start();

        } catch (IOException e) {
            throw new RuntimeException("SWW", e);
        }
    }

    private void listen() {
        try {
            doAuth();
            readMessage();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void doAuth() throws IOException {
        while (true) {
            /**
             * Auth Pattern
             * -auth login password
             */
            String input = in.readUTF();
            if (input.startsWith("-auth")) {
                String[] credentials = input.split("\\s");
                AuthEntry maybeAuthEntry = server.getAuthenticationService()
                        .findUserByCredentials(credentials[1], credentials[2]);
                if (maybeAuthEntry != null) {
                    if (server.isNicknameFree(maybeAuthEntry.getNickname())) {
                        sendMessage("CMD: auth is ok");
                        name = maybeAuthEntry.getNickname();
                        server.broadcast(name + " logged in.");
                        server.subscribe(this);
                        return;
                    } else {
                        sendMessage("Current user is already logged-in.");
                    }
                } else {
                    sendMessage("Unknown user. Incorrect login/password");
                }
            } else {
                sendMessage("Invalid authentication request.");
            }
        }
    }

    public String getName() {
        return name;
    }

    public void readMessage() throws IOException {
        while (true) {
            StringBuilder message = new StringBuilder(in.readUTF());

            if(message.toString().contains("/w")) {
                String[] detailsPrivateMessages = message.toString().split("\\s");
                String nickname = detailsPrivateMessages[1];
                message.setLength(0);

                for (int i = 2; i < detailsPrivateMessages.length; i++) {
                    message.append(" ").append(detailsPrivateMessages[i]);
                }

                server.sendPrivateMessage(this, nickname, message.toString());
            }  else {
                server.broadcast(name + ": " + message.toString());
            }
        }
    }

    public void sendMessage(String message) {
        try {
            out.writeUTF(message);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ClientHandler that = (ClientHandler) o;
        return Objects.equals(server, that.server) && Objects.equals(socket, that.socket) && Objects.equals(in, that.in) && Objects.equals(out, that.out) && Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(server, socket, in, out, name);
    }
}
