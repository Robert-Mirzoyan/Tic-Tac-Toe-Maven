package tictactoe;

public class Board implements Cloneable {
    String[][] board;

    public Board() {
        board = new String[3][3];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                board[i][j] = " ";
            }
        }
    }

    public void printBoard(){
        System.out.println("---------");
        for (String[] strings : this.board) {
            System.out.print("| ");
            for (String string : strings) {
                System.out.print(string + " ");
            }
            System.out.println("|");
        }
        System.out.println("---------");
    }

    public String getNextSign(){
        int xCount = 0, oCount = 0;
        for (String[] strings : this.board) {
            for (String string : strings) {
                if (string.equals("X")) xCount++;
                else if (string.equals("O")) oCount++;
            }
        }
        if (xCount == oCount) return "X";
        else return "O";
    }

    public String checkWinner() {
        for (int i = 0; i < 3; i++) {
            if (board[i][0].equals(board[i][1]) && board[i][1].equals(board[i][2]) && !board[i][0].equals(" ")) {
                return board[i][0] + " wins";            }
        }

        for (int j = 0; j < 3; j++) {
            if (board[0][j].equals(board[1][j]) && board[1][j].equals(board[2][j]) && !board[0][j].equals(" ")) {
                return board[0][j] + " wins";
            }
        }

        if (board[0][0].equals(board[1][1]) && board[1][1].equals(board[2][2]) && !board[0][0].equals(" ")) {
            return board[0][0] + " wins";
        }
        if (board[0][2].equals(board[1][1]) && board[1][1].equals(board[2][0]) && !board[0][2].equals(" ")) {
            return board[0][2] + " wins";
        }

        boolean isFull = true;

        for (String[] strings : board) {
            for (String string : strings) {
                if (string.equals(" ")) {
                    isFull = false;
                    break;
                }
            }
        }

        if (isFull){
            return "Draw";
        }

        return "game on";
    }

    public String[][] getBoard() {
        String[][] boardCopy = new String[3][3];
        for (int i = 0; i < 3; i++) {
            System.arraycopy(this.board[i], 0, boardCopy[i], 0, 3);
        }
        return boardCopy;
    }

    @SuppressWarnings("unused")
    public void setBoard(String[][] board) {
        this.board = board;
    }

    public void setCoordinate(int Coordinate1, int Coordinate2, String sign) {
        this.board[Coordinate1][Coordinate2] = sign;
    }

    @Override
    public Board clone() {
        try {
            Board clone = (Board) super.clone();
            clone.board = new String[3][3];
            for (int i = 0; i < 3; i++) {
                System.arraycopy(this.board[i], 0, clone.board[i], 0, 3);
            }
            return clone;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
}
