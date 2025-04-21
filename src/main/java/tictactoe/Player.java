package tictactoe;

import java.util.Random;

public abstract class Player {
    private String sign;

    public Player(String sign) {
        this.sign = sign;
    }

    void makeMove(Board board){
        Random random = new Random();
        int rows = board.getBoard().length;
        int cols = board.getBoard()[0].length;

        while (true) {
            int i = random.nextInt(rows);
            int j = random.nextInt(cols);
            if (board.getBoard()[i][j].equals(" ")) {
                board.setCoordinate(i, j, this.sign);
                return;
            }
        }
    }

    @SuppressWarnings("unused")
    public String getSign() {
        return sign;
    }

    @SuppressWarnings("unused")
    public void setSign(String sign) {
        this.sign = sign;
    }
}
