package tictactoe;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.*;
import static org.junit.jupiter.api.Assertions.*;

class MainTest {
    private ByteArrayOutputStream testOut;

    @BeforeEach
    void setUpStreams() {
        testOut = new ByteArrayOutputStream();
        System.setOut(new PrintStream(testOut));
    }

    private void provideInput(String data) {
        ByteArrayInputStream testIn = new ByteArrayInputStream(data.getBytes());
        System.setIn(testIn);
    }

    @Test
    void testExitCommand() {
        provideInput("exit\n");

        assertDoesNotThrow(() -> Main.main(new String[]{}));

        String output = testOut.toString();
        assertTrue(output.contains("Input command: >"));
    }

    @Test
    void testBadParameters() {
        provideInput("badinput\nexit\n");

        Main.main(new String[]{});

        String output = testOut.toString();
        assertTrue(output.contains("Bad parameters!"));
    }

    @Test
    void testInvalidLevel() {
        provideInput("start cat dog\nexit\n");

        Main.main(new String[]{});

        String output = testOut.toString();
        assertTrue(output.contains("Bad parameters!"));
    }

    @Test
    void testCreatePlayerTypes() {
        Player easy = Main.createPlayer("easy", "X");
        assertInstanceOf(Easy.class, easy);

        Player medium = Main.createPlayer("medium", "X");
        assertInstanceOf(Medium.class, medium);

        Player hard = Main.createPlayer("hard", "X");
        assertInstanceOf(Hard.class, hard);

        Player user = Main.createPlayer("user", "X");
        assertInstanceOf(User.class, user);
    }

    @Test
    void testIsValidLevel() {
        assertTrue(Main.isValidLevel("easy"));
        assertTrue(Main.isValidLevel("medium"));
        assertTrue(Main.isValidLevel("hard"));
        assertTrue(Main.isValidLevel("user"));
        assertFalse(Main.isValidLevel("invalid"));
    }
}
