package tictactoe;

public class Medium extends Player{

    public Medium(String sign) {
        super(sign);
    }

    @Override
    public void makeMove(Board board){
        System.out.println("Making move level \"medium\"");
        String checkSign = super.getSign(), setSign = super.getSign();

        // Winning move
        if (winningMove(board, checkSign, setSign)) return;

        // Block opponent
        if (checkSign.equals("X")) checkSign = "O";
        else checkSign = "X";

        if (winningMove(board, checkSign, setSign)) return;

        // Random
        super.makeMove(board);
    }

    private boolean winningMove(Board board, String checkSign, String setSign) {
        for (int i = 0; i < board.getBoard().length; i++) {
            for (int j = 0; j < board.getBoard()[i].length; j++) {
                if (board.getBoard()[i][j].equals(" ")) {
                    board.setCoordinate(i, j, checkSign);
                    if (board.checkWinner().equals(checkSign + " wins")){
                        board.setCoordinate(i, j, setSign);
                        return true;
                    }
                    board.setCoordinate(i, j, " ");
                }
            }
        }
        return false;
    }
}
