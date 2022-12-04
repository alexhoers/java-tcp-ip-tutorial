package repeat;

import base.BaseServer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;

public class RepeatServer extends BaseServer {

    /**
     * Start the repeat server and block requests until a client connects is established.
     * The simple server continues to block the connection until a message from a connected client is received.
     * The server continues to echo the message strings until a "." character is received.
     * @param port Local port number of the server socket
     * @throws IOException IO error when opening the socket
     */
    public void start(int port) throws IOException {
        serverSocket = new ServerSocket(port);
        clientSocket = serverSocket.accept();
        out = new PrintWriter(clientSocket.getOutputStream(), true);
        in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

        String inputLine;
        while ((inputLine = in.readLine()) != null) {
            if (".".equals(inputLine)) {
                out.println("bye");
                break;
            }
            out.println(inputLine);
        }
        stop();
    }

    public static void main(String[] args) throws IOException {
        RepeatServer server = new RepeatServer();
        server.start(5555);
    }

}
