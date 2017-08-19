package com.company;
import java.io.*;
import java.util.*;


class Node{
    int value;
    Node next;
    Node(int input){
        value = input;
        next = null;
    }
}


public class Main {

 public static Node intersect(Node head1, Node head2){
        if(head1==null || head2==null){
            return new Node(-1);
        }
        int c1 = getCount(head1);
        int c2 = getCount(head2);
        if(c1>c2){
          int d = c1-c2;
          return intersect(d,head1,head2);
        } else {
            int d = c2-c1;
            return intersect(d,head2,head1);
        }
    }
    
    public static Node intersect(int d, Node big, Node small){
        
        if(big==null || small==null){
            return new Node(-1);
        }
        for(int i=0;i<d;i++){
            big = big.next;
        }
        
        while(big.next!=null && small.next!=null){
            if(big==small){
                return big;
            }
            big = big.next;
            small = small.next;
        }
        return null;
    }
    
    public static int getCount(Node curr){
        Node trav = curr;
        int count = 0;
        while(trav!=null){
            count++;
            trav = trav.next;
        }
        return count;
    }
    
	public static void main (String[] args) {
		//code
		Node a = new Node(1);
		Node b = new Node(2);
		Node c = new Node(3);
		Node d = new Node(4);
		Node e = new Node(5);
		Node f = new Node(6);
		
		Node g = new Node(7);
		Node h = new Node(8);
		//List 1
		a.next = b;
		b.next = c;
		c.next = d;
		d.next = e;
		e.next = f;
		//List 2
		g.next = h;
		h.next =d;
		System.out.println(intersect(a,g).value);
	}
}

       
    