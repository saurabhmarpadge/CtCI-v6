import java.io.*;
import java.util.*;

class Main {

  static ArrayList<ArrayList<Integer>> powerSet(ArrayList<Integer> set){
    ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
    int max = 1 << set.size();
    for(int count=0;count<max;count++){
      ArrayList<Integer> subset = Int2Set(count,set);
      result.add(subset);
    }
    return result;
  }

  static ArrayList<Integer> Int2Set(int count,ArrayList<Integer> set){
    ArrayList<Integer> subset = new ArrayList<Integer>();
    for(int itr=0;itr<set.size();itr++){
      if((count & (1 << itr))>0){
        subset.add(set.get(itr));
      }
    }
    return subset;
  }

  public static void main(String[] args) {
    ArrayList<Integer> data = new ArrayList<Integer>(Arrays.asList(1,2,3,4));
    ArrayList<ArrayList<Integer>> powerset = powerSet(data);
    for(int i = 0; i < powerset.size(); i++){
          for(int j = 0; j < powerset.get(i).size(); j++){
                System.out.print(powerset.get(i).get(j)+" ");
          }
          System.out.println();
      }
    }
}
