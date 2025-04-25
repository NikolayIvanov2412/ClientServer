package ru.netology;

import java.io.*;
import java.net.*;

public class Client {
    public static void main(String[] args) {
        String host = "localhost"; // Адрес сервера
        int port = 8080; // Порт сервера

        try (Socket socket = new Socket(host, port); // Подключаемся к серверу
             PrintWriter out = new PrintWriter(socket.getOutputStream(), true); // Поток для отправки данных серверу
             BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()))) { // Поток для чтения данных от сервера

            out.println("NiceBot"); // Отправляем строку на сервер

            String resp = in.readLine(); // Читаем ответ от сервера
            System.out.println(resp); // Выводим ответ сервера
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}