package simple;

import base.BaseServer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;

/**
 * A simple server socket class which is exchanges messages with a client.
 * The server can only send one greeting response before it closes its connection.
 */
public class SimpleServer extends BaseServer {

    /**
     * Start the simple server and block requests until a client connects is established.
     * The simple server continues to block the connection until a message from a connected client is received.
     * @param port Local port number of the server socket
     * @throws IOException IO error when opening the socket
     */
    public void start(int port) throws IOException {
        // Bind the server socket to a specific port and localhost ip
        serverSocket = new ServerSocket(port);
        // Block the request until a client makes a connection request
        clientSocket = serverSocket.accept();
        // Accept the new socket and bind it to the same local port and access the input and output streams to write
        // to and from the client
        out = new PrintWriter(clientSocket.getOutputStream(), true);
        in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        String greeting = in.readLine();
        if ("greetings server".equals(greeting)) {
            out.println("greetings client");
        }
        else {
            out.println("unrecognised greeting");
        }
        stop();
    }

    public static void main(String[] args) throws IOException {
        SimpleServer server = new SimpleServer();
        server.start(6666);
    }
}
