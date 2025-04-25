package tictactoe;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class BoardTest {

    private Board board;

    @BeforeEach
    void setUp() {
        board = new Board();
    }

    @Test
    void testIsEmpty() {
        String[][] b = board.getBoard();
        for (String[] row : b) {
            for (String cell : row) {
                assertEquals(" ", cell);
            }
        }
    }

    @Test
    void testGetNextSign() {
        assertEquals("X", board.getNextSign());
    }

    @Test
    void testGetNextSignAfterOneMove() {
        board.setCoordinate(0, 0, "X");
        assertEquals("O", board.getNextSign());
    }

    @Test
    void testSetCoordinate() {
        board.setCoordinate(1, 1, "X");
        assertEquals("X", board.getBoard()[1][1]);
    }

    @Test
    void testCheckWinnerRows() {
        board.setBoard(new String[][]{
                {"X", "X", "X"},
                {" ", " ", " "},
                {" ", " ", " "}
        });
        assertEquals("X wins", board.checkWinner());
    }

    @Test
    void testCheckWinnerColumns() {
        board.setBoard(new String[][]{
                {"O", " ", " "},
                {"O", " ", " "},
                {"O", " ", " "}
        });
        assertEquals("O wins", board.checkWinner());
    }

    @Test
    void testCheckWinnerDiagonals() {
        board.setBoard(new String[][]{
                {"X", " ", " "},
                {" ", "X", " "},
                {" ", " ", "X"}
        });
        assertEquals("X wins", board.checkWinner());
    }

    @Test
    void testCheckWinnerNextDiagonal() {
        board.setBoard(new String[][]{
                {" ", " ", "O"},
                {" ", "O", " "},
                {"O", " ", " "}
        });
        assertEquals("O wins", board.checkWinner());
    }

    @Test
    void testDraw() {
        board.setBoard(new String[][]{
                {"X", "O", "X"},
                {"X", "O", "O"},
                {"O", "X", "X"}
        });
        assertEquals("Draw", board.checkWinner());
    }

    @Test
    void testGameOn() {
        board.setBoard(new String[][]{
                {"X", "O", "X"},
                {" ", "O", " "},
                {"O", "X", "X"}
        });
        assertEquals("game on", board.checkWinner());
    }

    @Test
    void testClone() {
        board.setCoordinate(0, 0, "X");
        Board cloned = board.clone();
        cloned.setCoordinate(0, 0, "O");
        assertEquals("X", board.getBoard()[0][0]);
        assertEquals("O", cloned.getBoard()[0][0]);
    }
}
