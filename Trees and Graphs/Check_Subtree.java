import java.util.*;
import java.io.*;

class Node{
  int value;
  Node left,right;
  Node(int input){
    value = input;
    left = right = null;
  }
}

public class Main{

  static boolean checkSubTree(Node r1,Node r2){
    if(r2==null){
      return true;
    }
    return subTree(r1,r2);
  }

  static boolean subTree(Node r1,Node r2){
    if(r1==null){
      return false;
    }

    if(r1.value == r2.value && matchSubTree(r1,r2)){
      return true;
    }

    return subTree(r1.left,r2) || subTree(r1.right,r2);
  }

  static boolean matchSubTree(Node r1,Node r2){
    if(r1==null&&r2==null){
      return true;
    } else if(r1==null||r2==null){
      return false;
    }
    if(r1.value != r2.value){
      return false;
    }

    return matchSubTree(r1.left,r2.left) && matchSubTree(r1.right,r2.right);
  }

  public static void main(String[] args){
    Node a = new Node(1);
    Node b = new Node(2);
    Node c = new Node(3);
    Node d = new Node(4);
    Node e = new Node(5);
    Node f = new Node(6);
    Node g = new Node(7);

    Node h = new Node(3);
    Node i = new Node(6);
    Node j = new Node(8);

    a.left = b;
    a.right = c;
    b.left = d;
    b.right = e;
    c.left = f;
    c.right = g;

    h.left = i;
    h.right = j;
    System.out.println(checkSubTree(a,c));
  }
}
