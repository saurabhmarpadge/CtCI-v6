import java.io.*;
import java.util.*;

class Main {

  static int solve(int x, int y){
    if(y==0){
      return 0;
    }
    return x + solve(x,y-1);
  }

  public static void main(String[] args) {
    System.out.println(solve(5,2));
  }
}
