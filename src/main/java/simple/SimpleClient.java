package simple;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * A simple client socket class which exchanges messages with a server.
 */
public class SimpleClient {
    private Socket clientSocket;
    private PrintWriter out;
    private BufferedReader in;

    /**
     * Starts connection with a new server socket.
     * @param ip Ip address of the server socket
     * @param port Local port of the server socket
     * @throws IOException IO error when opening the socket
     */
    public void startConnection(String ip, int port) throws IOException {
        clientSocket = new Socket(ip, port);
        out = new PrintWriter(clientSocket.getOutputStream(), true);
        in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
    }

    /**
     * Sends a message to the server socket.
     * @param msg Message to send to the server socket
     * @return Returned message from the server socket
     * @throws IOException IO error when sending a message to the socket
     */
    public String sendMessage(String msg) throws IOException {
        out.println(msg);
        String resp = in.readLine();
        return resp;
    }

    /**
     * Stops the connection with the socket
     * @throws IOException
     */
    public void stopConnection() throws IOException {
        in.close();
        out.close();
        clientSocket.close();
    }
}
