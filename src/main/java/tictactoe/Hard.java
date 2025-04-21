package tictactoe;

public class Hard extends Player{

    public Hard(String sign) {
        super(sign);
    }

    @Override
    public void makeMove(Board board) {
        System.out.println("Making move level \"hard\"");
        Board cloneBoard = board.clone();

        int bestScore = Integer.MIN_VALUE;
        int bestMoveX = -1, bestMoveY = -1;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (cloneBoard.getBoard()[i][j].equals(" ")) {
                    cloneBoard.setCoordinate(i, j, this.getSign());

                    int score = minimax(cloneBoard, 0, false);

                    cloneBoard.setCoordinate(i, j, " ");

                    if (score > bestScore) {
                        bestScore = score;
                        bestMoveX = i;
                        bestMoveY = j;
                    }
                }
            }
        }

        board.setCoordinate(bestMoveX, bestMoveY, this.getSign());
    }

    private int minimax(Board board, int depth, boolean isMaximizing) {
        int bestScore;
        String oppositeSign = this.getSign().equals("X") ? "O" : "X";

        String winner = board.checkWinner();
        if (winner.equals(this.getSign() + " wins")) return 10 - depth;
        else if (winner.equals(oppositeSign + " wins")) return -10 + depth;
        else if (winner.equals("Draw")) return 0;

        if (isMaximizing) {
            bestScore = Integer.MIN_VALUE;
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (board.getBoard()[i][j].equals(" ")) {
                        board.setCoordinate(i, j, this.getSign());
                        int score = minimax(board, depth + 1, false);
                        board.setCoordinate(i, j, " ");
                        bestScore = Math.max(score, bestScore);
                    }
                }
            }
        } else {
            bestScore = Integer.MAX_VALUE;
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (board.getBoard()[i][j].equals(" ")) {
                        board.setCoordinate(i, j, oppositeSign);
                        int score = minimax(board, depth + 1,true);
                        board.setCoordinate(i, j, " ");
                        bestScore = Math.min(score, bestScore);
                    }
                }
            }
        }
        return bestScore;
    }
}
