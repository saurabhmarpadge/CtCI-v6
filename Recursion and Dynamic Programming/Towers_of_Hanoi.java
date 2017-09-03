import java.util.*;
import java.io.*;

class Tower{
  Stack<Integer> disks;
  Tower(){
    disks = new Stack<Integer>();
  }
  void add(int d){
    if(disks.isEmpty()){
      disks.push(d);
    } else if(disks.peek()>d){
      disks.push(d);
    }
  }

  void printTower(int towerId){
    System.out.print((char)('A'+towerId));
    if(disks.isEmpty()){
      System.out.print(" Empty");
    }
    while(!disks.isEmpty()){
      System.out.print(" "+disks.pop());
    }
    System.out.println();
  }

  void moveTop(Tower Des){
    Des.add(disks.pop());
  }

  void moveDisks(int n,Tower Des, Tower Aux){
    if(n>0){
      moveDisks(n-1,Aux,Des);
      moveTop(Des);
      Aux.moveDisks(n-1,Des,this);
    }
  }
}


public class Main{

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int disks = in.nextInt();
    Tower[] towers = new Tower[3];
    for(int i=0;i<3;i++){
      towers[i] = new Tower();
    }
    for(int d=disks;d>0;d--){
      towers[0].add(d);
    }
    towers[0].moveDisks(disks,towers[2],towers[1]);
    for(int i=0;i<3;i++){
      towers[i].printTower(i);
    }
  }
}
