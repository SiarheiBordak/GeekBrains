package ru.geekbrains.chat.client.network;

public interface ClientNetwork {
    void send(String message);
    String receive();
}
