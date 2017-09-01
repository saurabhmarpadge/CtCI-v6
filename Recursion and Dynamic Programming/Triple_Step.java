import java.util.*;
import java.io.*;

public class Main{
  static int countPaths(int steps){
    return countPaths(steps, new ArrayList<Integer>(Arrays.asList(1,2,3)),new int[steps+1]);
  }

  static int countPaths(int steps,ArrayList<Integer> jumps,int[] memo){
    if(steps==0){
      return 1;
    }
    if(steps<0 || (steps>0&&steps<Collections.min(jumps))){
      return 0;
    }
    if(memo[steps]==0){
      for(Integer jump:jumps){
        memo[steps] += countPaths(steps-jump,jumps,memo);
      }
    }
    return memo[steps];
  }

  public static void main(String[] args){
    Scanner in = new Scanner(System.in);
    int tc = in.nextInt();
    while(--tc>=0){
      int staircase = in.nextInt();
      System.out.println(countPaths(staircase));
    }
  }
}
