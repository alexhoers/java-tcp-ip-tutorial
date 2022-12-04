package simple;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Tests a continuous two-way communication request response between the client and server socket.
 * Make sure the server is running before executing the test.
 */
public class RepeatClientServerSpec {

    private static SimpleClient client;

    @BeforeAll
    public static void startConnection() throws IOException {
        client = new SimpleClient();
        client.startConnection("127.0.0.1", 5555);
    }

    @AfterAll
    public static void stopConnection() throws IOException {
        client.stopConnection();
    }

    @Test
    public void test_ClientServerConnection() throws IOException {
        String resp1 = client.sendMessage("hello");
        String resp2 = client.sendMessage("world");
        String resp3 = client.sendMessage("!");
        String resp4 = client.sendMessage(".");

        assertEquals("hello", resp1);
        assertEquals("world", resp2);
        assertEquals("!", resp3);
        assertEquals("bye", resp4);
    }

}
