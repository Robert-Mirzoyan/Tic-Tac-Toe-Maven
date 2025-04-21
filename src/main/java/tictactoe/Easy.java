package tictactoe;

public class Easy extends Player{
    private String sign;

    public Easy(String sign) {
        super(sign);
    }

    @Override
    public void makeMove(Board board){
        System.out.println("Making move level \"easy\"");
        super.makeMove(board);
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
