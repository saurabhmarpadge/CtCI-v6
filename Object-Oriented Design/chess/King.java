public class King extends Piece{
    private boolean isCastingDone = false;

    @Override
    public boolean canMove(Board board, Box start, Box end) {
        return false;
    }
    public boolean isCastingMove(){
        return false;
    }
}
