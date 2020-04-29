package com.company;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class SocialNetworkServer {
    private static final int PORT = 8100;
    private ServerSocket serverSocket;
    private boolean running = false;

    public static void main(String[] args) {
        SocialNetworkServer server = new SocialNetworkServer();
        server.init();
        server.waitForClients(); //... handle the exceptions!
    }

    private void init() {
        try {
            serverSocket = new ServerSocket(PORT);
        } catch (IOException e) {
            e.printStackTrace();
        }
        running = true;
    }

    // Implement the init() method: create the serverSocket and set running to true
    private void waitForClients() {
        while (running) {
            System.out.println(" Asteptam un client... ");
            try {
                Socket socket = serverSocket.accept();
                new ClientThread(socket, this).run();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


}