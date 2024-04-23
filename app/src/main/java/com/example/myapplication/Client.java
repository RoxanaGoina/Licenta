package com.example.myapplication;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
public class Client {
    private String host;
    private int port;

    public Client(String host, int port) {
        this.host = host;
        this.port = port;
    }
    public void connect() {
        try (Socket socket = new Socket(host, port);
             PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
             BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {

            System.out.println("Connected to server " + host + ":" + port);

            int[] dataToSend = {2, 24, 1, 1, 16, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};

            String jsonData = "[" + arrayToJSONString(dataToSend) + "]";

            out.println(jsonData);

            String receivedData = in.readLine();
            System.out.println("Received data from server: " + receivedData);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


//    public static void main(String[] args) {
//        String host = "127.0.0.1";
//        int port = 12345;
//
//        try (Socket socket = new Socket(host, port);
//             PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
//             BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {
//
//            System.out.println("Connected to server " + host + ":" + port);
//
//
//
//            int[] dataToSend = {2, 24, 1, 1, 16, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
//
//            String jsonData = "[" + arrayToJSONString(dataToSend) + "]";
//
//            out.println(jsonData);
//
//            String receivedData = in.readLine();
//            System.out.println("Received data from server: " + receivedData);
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }

    private static String arrayToJSONString(int[] array) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < array.length; i++) {
            sb.append(array[i]);
            if (i < array.length - 1) {
                sb.append(",");
            }
        }
        return sb.toString();
    }
}
