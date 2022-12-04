package base;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Base server class
 */
public class BaseServer {

    protected ServerSocket serverSocket;
    protected Socket clientSocket;
    protected PrintWriter out;
    protected BufferedReader in;

    /**
     * Close all connections of the client and server sockets
     * @throws IOException IO error when closing the sockets
     */
    public void stop() throws IOException {
        in.close();
        out.close();
        clientSocket.close();
        serverSocket.close();
    }

}
