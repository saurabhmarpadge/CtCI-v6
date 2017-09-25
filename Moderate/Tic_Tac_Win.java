import java.util.*;
import java.io.*;

class Main {

  static boolean solve(int[][] board){
    for(int i=0; i<3; i++){
      if(hasWon(board[0][i],board[1][i],board[2][i])){
        return true;
      }
      if(hasWon(board[i][0],board[i][1],board[i][2])){
        return true;
      }
    }
    if(hasWon(board[0][0],board[1][1],board[2][2])){
      return true;
    }
    if(hasWon(board[0][2],board[1][1],board[2][0])){
      return true;
    }
    return false;
  }

  static boolean hasWon(int p1,int p2,int p3){
    if(p1==-99){
      return false;
    }
    return p1==p2 && p2==p3;
  }

  public static void main(String[] args) {
      int[][] board = new int[][]{
        {-99,1,0},
        {0,-99,0},
        {0,1,-99}
      };
    System.out.println(solve(board));
  }
}
