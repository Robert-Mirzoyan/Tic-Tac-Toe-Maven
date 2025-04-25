package tictactoe;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class EasyTest {

    private Easy easyPlayer;
    private Board board; // no mocking

    @BeforeEach
    void setUp() {
        easyPlayer = new Easy("X");
        board = new Board(); // real object
    }

    @Test
    void testMakeMove() {
        easyPlayer.makeMove(board);
    }
}