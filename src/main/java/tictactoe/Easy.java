package tictactoe;

public class Easy extends Player{
    public Easy(String sign) {
        super(sign);
    }

    @Override
    public void makeMove(Board board){
        System.out.println("Making move level \"easy\"");
        super.makeMove(board);
    }
}
