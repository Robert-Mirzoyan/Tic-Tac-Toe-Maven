package tictactoe;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HardTest {

    private Hard hardPlayer;
    private Board board;

    @BeforeEach
    void setUp() {
        hardPlayer = new Hard("X");
        board = new Board();
    }

    @Test
    void testMakeMove() {
        assertDoesNotThrow(() -> hardPlayer.makeMove(board));
    }

    @Test
    void testHardWins() {
        board.setCoordinate(0, 0, "X");
        board.setCoordinate(0, 1, "X");
        board.setCoordinate(1, 1, "O");
        board.setCoordinate(1, 2, "O");
        hardPlayer.makeMove(board);
        assertEquals("X wins", board.checkWinner());
    }

    @Test
    void testHardBlocks() {
        hardPlayer = new Hard("O");

        board.setCoordinate(0, 0, "X");
        board.setCoordinate(0, 1, "X");
        board.setCoordinate(1, 1, "O");
        board.setCoordinate(2, 2, "O");
        hardPlayer.makeMove(board);
        assertNotEquals("X wins", board.checkWinner());
    }

    @Test
    void testHardDraw() {
        hardPlayer = new Hard("O");
        board.setBoard(new String[][]{
                {"X", "O", "X"},
                {"X", "O", "O"},
                {" ", "X", "X"}
        });
        hardPlayer.makeMove(board);
        assertEquals("Draw", board.checkWinner());
    }
}
