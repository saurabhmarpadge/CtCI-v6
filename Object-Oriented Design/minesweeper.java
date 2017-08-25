import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

class minesweeper{
    private int MINES, SIDES;
    private int movesLeft;
    private ArrayList<ArrayList<String>> userBoard ;
    private ArrayList<ArrayList<String>> realBoard ;
    private ArrayList<ArrayList<Integer>> minesLocation;
    private int myX,myY;
    Scanner in = new Scanner(System.in);
    minesweeper(){
        userBoard = new ArrayList<ArrayList<String>>();
        realBoard = new ArrayList<ArrayList<String>>();
        minesLocation = new ArrayList<ArrayList<Integer>>();
    }
    /*
    * Initialize Board with '?'
    */
    void initialize(){
        for (int i = 0; i < SIDES ; i++) {
            userBoard.add(new ArrayList<String>());
            realBoard.add(new ArrayList<String>());
            for (int j = 0; j < SIDES ; j++) {
                userBoard.get(i).add("?");
                realBoard.get(i).add("?");
            }
        }
    }
    /*
    * Check if its a Mine
    */
    boolean isMine(int row, int col){
        if(realBoard.get(row).get(col).equals("*")){
            return true;
        }
        return false;
    }
    /*
    * Check if its a valid move
    */
    boolean isValid(int row, int col){
        if(row<0 || row>=SIDES || col<0||col>=SIDES){
            return false;
        }
        return true;
    }

    /*
    * DFS Algorithm to Finding Connected Nodes
    */
    void expand(int row, int col){

        if(!isValid(row,col)){
            return;
        }

        if(realBoard.get(row).get(col).equals("*")){
            return;
        }
        if(!userBoard.get(row).get(col).equals("?")){
            return;
        }
        movesLeft--;

        int data = Integer.parseInt(realBoard.get(row).get(col));
        if(data>=1&&data<=8){
            userBoard.get(row).set(col,realBoard.get(row).get(col));
        } else {
            realBoard.get(row).set(col,"9");
            userBoard.get(row).set(col," ");
            for (int r = row-1; r <=row+1 ; r++) {
                for (int c = col-1; c <= col+1;c++) {
                    if(r!=row||c!=col){
                        expand(r,c);
                    }
                }
            }
        }


    }
    /*
    * Accept User Input in the from on X and Y
    */
    void getMoves(){
        System.out.println("Enter You Move:-");
        myX = in.nextInt();
        myY = in.nextInt();
    }
    /*
    * Display Board
    */
    void printBoard(ArrayList<ArrayList<String>> board){
        System.out.println();
        System.out.print("   ");
        for (int i = 0; i < SIDES; i++) {
            if(i<10){
                System.out.print(" ");
            }
            System.out.print(i+" ");
        }
        System.out.println();
        for (int i = 0; i < board.size(); i++) {
            System.out.print(i+"  ");
            if(i<10){
                System.out.print(" ");
            }
            for (int j = 0; j < board.get(i).size(); j++) {
                if(board.get(i).get(j).equals("9")){
                    System.out.print("   ");
                } else {
                    System.out.print(board.get(i).get(j)+"  ");
                }

            }
            System.out.println();
        }
    }
    /*
    * Generate Mines
    */
    void getRandomMines(){
        boolean[] mark = new boolean[SIDES*SIDES];
        for (int j = 0; j < MINES ; j++) {
            minesLocation.add(new ArrayList<Integer>());
        }
        int i=0;
        Random rn =new Random();
        while(i<MINES){
            int random = Math.abs(rn.nextInt()) % (SIDES*SIDES);
            int x = (random / SIDES)%SIDES;
            int y = random % SIDES;
            if(mark[i]==false){
                minesLocation.get(i).add(x);
                minesLocation.get(i).add(y);
                mark[i]=true;
                i++;
            }
        }
    }

    void placeMines(){
        getRandomMines();
        for (int i = 0; i < MINES; i++) {
          realBoard.get(minesLocation.get(i).get(0)).set(minesLocation.get(i).get(1),"*");
        }
    }

    int mineFound(int row,int col){
        if(isValid(row,col) && isMine(row,col)){
            return 1;
        }
        return 0;
    }

    /*
    * Find count of No of Adjacent Mines
    */
    int getMineCount(int row, int col){
        return mineFound(row+1,col)
                + mineFound(row-1,col)
                + mineFound(row,col-1)
                + mineFound(row,col+1)
                + mineFound(row-1,col-1)
                + mineFound(row-1, col+1)
                + mineFound(row+1,col-1)
                + mineFound(row+1,col+1);
    }
    /*
    * Fill count of No of Adjacent Mines
    */
    void placeCount(){
        for (int i = 0; i < realBoard.size() ; i++) {
            for (int j = 0; j < realBoard.get(i).size(); j++) {
                if(!realBoard.get(i).get(j).equals("*")){
                    realBoard.get(i).set(j,Integer.toString(getMineCount(i,j)));
                }
            }
        }
    }
    /*
    * Set Difficulty Level
    */
    void chooseMode(){
        System.out.println("Welcome to Minesweeper Game");
        System.out.println("Select Mode");
        System.out.println("0 - Easy");
        System.out.println("1 - Medium");
        System.out.println("2 - Hard");

        int choice = in.nextInt();
        switch (choice){
            case 0:
                SIDES = 9;
                MINES = 10;
                break;
            case 1:
                SIDES = 16;
                MINES = 40;
                break;
            case 2:
                SIDES = 24;
                MINES = 99;
                break;
            default:
                SIDES = 9;
                MINES = 10;
        }

    }

    void fillRealBoard(){
        placeMines();
        placeCount();
    }

    void playMineSweeper(){
        boolean gameOver = false;
        chooseMode();
        movesLeft = (SIDES*SIDES);
        initialize();
        fillRealBoard();
        System.out.println("*************************WelCome to Minesweeper**************************");
        while (!gameOver){
            if(movesLeft==MINES&&gameOver==false){
                printBoard(userBoard);
                System.out.println("You Won!!!");
                break;
            }

            System.out.println("Moves left:"+(movesLeft-MINES));
            printBoard(userBoard);
            getMoves();
            if(userBoard.get(myX).get(myY).equals("?")){
                if(realBoard.get(myX).get(myY).equals("*")){
                    gameOver = true;
                    System.out.println("***Mines***");
                    System.out.println("You Lost!!!");
                    userBoard.get(myX).set(myY,"*");
                    printBoard(userBoard);
                    System.out.println("Press 0 for to view all Mines");
                    if(in.nextInt()==0){
                        System.out.println("Solution");
                        printBoard(realBoard);
                    }

                } else if(Integer.parseInt(realBoard.get(myX).get(myY))>=1 && Integer.parseInt(realBoard.get(myX).get(myY))<=8){
                        userBoard.get(myX).set(myY,realBoard.get(myX).get(myY));
                        movesLeft--;
                } else if(realBoard.get(myX).get(myY).equals("0")){
                    expand(myX,myY);
                }
            }


        }
    }
    /*
    * To test game
    */
    void testMines(){
        getRandomMines();
        for (int i = 0; i < minesLocation.size() ; i++) {
            System.out.println(minesLocation.get(i).get(0)+" "+minesLocation.get(i).get(1));
        }
    }

    void testGame(){
        chooseMode();
        initialize();
        //testMines();
        fillRealBoard();
        printBoard(userBoard);
        printBoard(realBoard);
    }
}

public class Main {

    public static void main(String[] args) {
	    minesweeper game = new minesweeper();
	    game.playMineSweeper();
    }
}
