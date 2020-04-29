package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.net.SocketTimeoutException;

public class ClientThread extends Thread {
    private Socket socket = null;
    private final SocialNetworkServer server;
    ClientThread(Socket socket , SocialNetworkServer server ) throws SocketException {
        this.socket = socket;
        this.server = server;
    }
    public void run() {
        BufferedReader in = null; //client -> server stream
        String request = null;
        String response = null;
        PrintWriter out = null;
        try {
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new PrintWriter(socket.getOutputStream()); //server -> client stream
            while(true) {
                request = in.readLine();
                if( request == null )
                    break;
                response = execute(request);
                out.println(response);
                out.flush();
                if( response.equals("exit") ) {
                    break;
                }
            }
        } catch (SocketTimeoutException e) {
            e.printStackTrace();
            System.out.println("Socket timed out!!!");
            out.println("exit");

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    private String execute(String request) throws IOException {
        System.out.println("Server received the request " + request );
        return "Syntax";
        // display the message: "Server received the request ... "
    }
}
