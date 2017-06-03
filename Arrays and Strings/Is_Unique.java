import java.util.*;
class Solution{

  public static boolean withDS(String input){
    ArrayList<Integer> myArr = new ArrayList<>(Collections.nCopies(26,0));
   for(int i=0;i<input.length();i++){
   if(myArr.get((int)input.charAt(i)-97)==1){
        return false;
      } else {
        int index  = (int)input.charAt(i)-97;
        myArr.set(index,1);
      }

    }
    return true;
  }

  public static boolean withoutDS(String input){
    for(int i=0;i<input.length();i++){
      for(int j=i+1;j<input.length();j++){
        if(input.charAt(i)==input.charAt(j)){
          return false;
        }
      }
    }
    return true;
  }

  public static void main(String args[]){
    Scanner in = new Scanner(System.in);
    String input = in.next();
    if(withDS(input)){
      System.out.println("Is Unique");
    } else {
      System.out.println("Not Unique");
    }
    if(withoutDS(input)){
      System.out.println("Is Unique");
    } else {
      System.out.println("Not Unique");
    }
  }
}
