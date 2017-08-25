import java.util.*;
import java.io.*;

class Treenode{
  String value;
  Treenode left,right;
  Treenode(String input){
    value = input;
    left = right = null;
  }
}

public class Main{

  public static boolean isBalanced(Treenode root){
    if(root==null){
      return true;
    }

    int lh = height(root.left);
    int rh = height(root.right);

    return (Math.abs(lh-rh)<=1 && isBalanced(root.left) && isBalanced(root.right));
  }

  public static int height(Treenode root){
    if(root==null){
      return 0;
    }

    return 1 + Math.max(height(root.left),height(root.right));
  }


  public static void main(String[] args){
    Treenode a = new Treenode("A");
    Treenode b = new Treenode("B");
    Treenode c = new Treenode("C");
    Treenode d = new Treenode("D");
    Treenode e = new Treenode("E");
    Treenode f = new Treenode("F");
    Treenode g = new Treenode("G");

    a.left = b;
    a.right = c;
    b.left = d;
    b.right = e;
    c.left = f;
    c.right = g;

    System.out.println(isBalanced(a));
  }
}
