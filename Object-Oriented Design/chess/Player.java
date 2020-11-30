public class Player {
    Color color;
    Player(Color color){
        this.color = color;
    }

    public boolean isWhiteSide() {
        return color.equals(Color.WHITE);
    }
}
