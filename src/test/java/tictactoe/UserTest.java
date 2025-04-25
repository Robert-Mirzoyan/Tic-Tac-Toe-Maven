package tictactoe;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayInputStream;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {

    private User userPlayer;
    private Board board;

    @BeforeEach
    void setUp() {
        userPlayer = new User("X");
        board = new Board();
    }

    @Test
    void testValidMove() {
        String input = "1 1\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        userPlayer.makeMove(board);
        assertEquals("X", board.getBoard()[0][0]);
    }

    @Test
    void testOccupiedCell() {
        board.setCoordinate(0, 0, "O");
        String input = "1 1\n2 2\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        userPlayer.makeMove(board);
        assertEquals("X", board.getBoard()[1][1]);
    }

    @Test
    void testInvalidInput() {
        board.setCoordinate(0, 0, "O");
        String input = "a a";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        assertThrows(StackOverflowError.class, () -> userPlayer.makeMove(board));
    }

    @Test
    void testOutOfRangeInput() {
        String input = "4 4\n2 3\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        userPlayer.makeMove(board);
        assertEquals("X", board.getBoard()[1][2]);
    }
}
