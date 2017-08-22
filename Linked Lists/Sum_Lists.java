//package com.company;
import java.io.*;
import java.util.*;

class Node {
	int value;
	Node next;
	Node(int input){
		value = input;
	}
}

public class Sum_Lists {
      public static Node result=null;
      public static Node tail = null;
  public static void adding(int input){
    Node temp = new Node(input);
    if(result == null){
      tail = temp;
      result = temp;
    } else {
      tail.next = temp;
      tail = tail.next;
    }
  }
  public static void sum(Node head1, Node head2){
    Node first = head1;
    Node second = head2;
    int carry = 0;
    int value = 0;
    while(first!=null || second!=null){

      value = carry + (first!=null ? first.value : 0) + (second!=null ? second.value : 0);
      adding(value%10);
      carry = value>10?value/10:0;

      if(first!=null){
        first = first.next;
      }
      if(second!=null){
        second = second.next;
      }
    }
    if(carry!=0){
      adding(carry);
    }
    display(result);
  }

  public static void display(Node head){
    Node curr = head;
    while(curr!=null){
      System.out.print(curr.value+" ");
      curr = curr.next;
    }
  }

  public static void main(String[] args) {
  // write your code here
   Node a = new Node(9);
   Node b = new Node(7);
   Node c = new Node(8);
   Node d = new Node(6);
   Node e = new Node(8);
   Node f = new Node(5);
   a.next = b;
   b.next = c;
   c.next = null;
   d.next = e;
   e.next = f;
   f.next = null;
   sum(a,d);
  }
}
