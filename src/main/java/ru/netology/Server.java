package ru.netology;

import java.io.*;
import java.net.*;

public class Server {
    public static void main(String[] args) {
        int port = 8080; // Выбираем порт для сервера
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Сервер запущен на порту: " + port);

            while (true) { // Бесконечный цикл для обработки входящих соединений
                try (Socket clientSocket = serverSocket.accept(); // Ожидаем подключения клиента
                     PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true); // Поток для отправки данных клиенту
                     BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()))) { // Поток для чтения данных от клиента

                    System.out.println("Новое подключение принято");

                    final String name = in.readLine(); // Читаем строку от клиента

                    System.out.println(String.format("Сообщение от клиента: %s, порт клиента: %d", name, clientSocket.getPort())); // Выводим сообщение и порт клиента

                    out.println(String.format("Привет %s, твой порт: %d", name, clientSocket.getPort())); // Отправляем ответ клиенту
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}