package tictactoe;

import java.util.Scanner;

public class User extends Player{

    public User(String sign) {
        super(sign);
    }

    @Override
    public void makeMove(Board board){
        Scanner scanner = new Scanner(System.in);
        int coordinate1, coordinate2;
        String[][] boardArray = board.getBoard();

        while (true){
            try {
                System.out.print("Enter the coordinates: > ");
                coordinate1 = scanner.nextInt();
                coordinate1--;
                coordinate2 = scanner.nextInt();
                coordinate2--;
                if(coordinate1 >= 0 && coordinate1 < 3 && coordinate2 >= 0 && coordinate2 < 3 && boardArray[coordinate1][coordinate2].equals(" ")){
                    boardArray[coordinate1][coordinate2] = super.getSign();
                    board.setBoard(boardArray);
                    break;
                } else if (coordinate1 < 0 || coordinate1 > 2 || coordinate2 < 0 || coordinate2 > 2) {
                    System.out.println("Coordinates should be from 1 to 3!");
                } else if (!boardArray[coordinate1][coordinate2].equals(" ")) {
                    System.out.println("This cell is occupied! Choose another one!");
                }
            } catch (Exception e) {
                System.out.println("You should enter numbers!");
                this.makeMove(board);
                break;
            }
        }
    }
}
