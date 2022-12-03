package simple;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Tests a simple two-way communication request response between the client and server socket.
 * Make sure the server is running before executing the test.
 */
public class SimpleClientServerSpec {

    private static SimpleClient client;

    @BeforeAll
    public static void startConnection() throws IOException {
        client = new SimpleClient();
        client.startConnection("127.0.0.1", 6666);
    }

    @AfterAll
    public static void stopConnection() throws IOException {
        client.stopConnection();
    }

    @Test
    public void test_ClientServerConnection() throws IOException {
        String response = client.sendMessage("greetings server");
        assertEquals("greetings client", response);
    }

}
