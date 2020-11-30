public class Board {
    Box[][] boxes;
    Board(){
        boxes = new Box[8][8];
    }
    public Box getBox(int x, int y){
        return boxes[x][y];
    }

    public void resetBoard() {
        for(int x=0;x<8;x++){
            for(int y=0;y<8;y++){
                boxes[x][y] = new Box(null,null,x,y);
            }
        }
    }
}
