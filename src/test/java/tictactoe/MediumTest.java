package tictactoe;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class MediumTest {

    private Medium mediumPlayer;
    private Board board;

    @BeforeEach
    void setUp() {
        mediumPlayer = new Medium("X");
        board = new Board();
    }

    @Test
    void testMakeMove() {
        assertDoesNotThrow(() -> mediumPlayer.makeMove(board));
    }

    @Test
    void testMediumWins() {
        board.setCoordinate(0, 0, "X");
        board.setCoordinate(0, 1, "X");
        board.setCoordinate(1, 1, "O");
        board.setCoordinate(1, 2, "O");
        mediumPlayer.makeMove(board);
        assertEquals("X wins", board.checkWinner());
    }

    @Test
    void testMediumBlocks() {
        mediumPlayer = new Medium("O");
        board.setCoordinate(0, 0, "X");
        board.setCoordinate(0, 1, "X");
        board.setCoordinate(1, 1, "O");
        board.setCoordinate(1, 2, "O");
        mediumPlayer.makeMove(board);
        assertNotEquals("X wins", board.checkWinner());
    }
}
