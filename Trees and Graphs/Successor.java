import java.util.*;
import java.io.*;

class Node{

  String value;
  Node left,right,parent;

  Node(String input){
    value = input;
    left = right = parent = null;
  }
}

public class Main{

  public static Node successor(Node root){
    if(root.right!=null){
      return leftMostNode(root.right);
    } else {
      //Find a rightmost ancestor of the node
        Node curr = root;
        Node p = root.parent;
        while(p!=null && p.left!=curr){
          curr = p;
          p = p.parent;
        }
        return p;
    }
  }

  public static Node leftMostNode(Node root){
    Node curr = root;
    while(curr.left!=null){
      curr = curr.left;
    }
    return curr;
  }

  public static void main(String[] args){

    Node a = new Node("A");
    Node b = new Node("B");
    Node c = new Node("C");
    Node d = new Node("D");
    Node e = new Node("E");
    Node f = new Node("F");
    Node g = new Node("G");

    a.parent = null;
    a.left = b;
    a.right = c;
    b.parent = c.parent = a;
    b.left = d;
    b.right = e;
    d.parent = e.parent = b;
    c.left = f;
    c.right = g;
    f.parent = g.parent = c;
    Node result = successor(e);
    if(result!=null){
      System.out.println(result.value);
    } else {
      System.out.println(result);
    }

  }
}
