public abstract class Piece {
    private Color color;
    private boolean status;
    public abstract boolean canMove(Board board, Box start, Box end);
    public void setKilled(boolean status){
        this.status = status;
    }
}
