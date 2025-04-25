package tictactoe;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("Input command: > ");
            String commands = scanner.nextLine();
            String[] commandsArray = commands.split(" ");

            if (commandsArray.length == 1 && commandsArray[0].equals("exit")) {
                break;
            }
            if (commandsArray.length != 3) {
                System.out.println("Bad parameters!");
                continue;
            }

            if (!(commandsArray[0].equals("start") && isValidLevel(commandsArray[1]) && isValidLevel(commandsArray[2]))) {
                System.out.println("Bad parameters!");
                continue;
            }

            Player player1 = createPlayer(commandsArray[1], "X");
            Player player2 = createPlayer(commandsArray[2], "O");

            game(player1, player2);
        }
    }

    static boolean isValidLevel(String level) {
        String[] validLevels = {"easy", "user", "medium", "hard"};

        for (String validLevel : validLevels) {
            if (level.equals(validLevel)) {
                return true;
            }
        }
        return false;
    }

    static Player createPlayer(String level, String symbol) {
        return switch (level) {
            case "easy" -> new Easy(symbol);
            case "medium" -> new Medium(symbol);
            case "hard" -> new Hard(symbol);
            case "user" -> new User(symbol);
            default -> throw new IllegalArgumentException("Invalid player type");
        };
    }

    public static void game(Player player1, Player player2){
        Board board = new Board();

        board.printBoard();

        boolean gameOn = true;
        while (gameOn){
            String sign = board.getNextSign();

            if (sign.equals("X")){
                player1.makeMove(board);
            }
            else {
                player2.makeMove(board);
            }

            board.printBoard();

            String result = board.checkWinner();
            gameOn = result.equals("game on");
            if (!gameOn) System.out.println(result);
        }
    }
}
