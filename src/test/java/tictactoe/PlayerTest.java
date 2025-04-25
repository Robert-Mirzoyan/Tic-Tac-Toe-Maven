package tictactoe;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {

    private Player player;
    private Board board;

    static class DummyPlayer extends Player {
        public DummyPlayer(String sign) {
            super(sign);
        }
    }

    @BeforeEach
    void setUp() {
        player = new DummyPlayer("X");
        board = new Board();
    }

    @Test
    void testMakeMove() {
        assertEquals(9, countEmptyCells(board));
        player.makeMove(board);
        assertEquals(8, countEmptyCells(board));
        assertEquals(1, countSign(board, "X"));
    }

    @Test
    void testGetAndSetSign() {
        assertEquals("X", player.getSign());
        player.setSign("O");
        assertEquals("O", player.getSign());
    }

    private int countEmptyCells(Board board) {
        int count = 0;
        for (String[] row : board.getBoard()) {
            for (String cell : row) {
                if (cell.equals(" ")) {
                    count++;
                }
            }
        }
        return count;
    }

    private int countSign(Board board, String sign) {
        int count = 0;
        for (String[] row : board.getBoard()) {
            for (String cell : row) {
                if (cell.equals(sign)) {
                    count++;
                }
            }
        }
        return count;
    }
}
