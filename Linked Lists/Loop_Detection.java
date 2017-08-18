package com.company;
import java.io.*;
import java.util.*;

class Node {
	String value;
	Node next;
	Node(String input){
		value = input;
	}
}


public class Main {

	public static Node loopDetect(Node head){
		Node fast = head;
		Node slow = head;

		while(fast.next!=null){

			slow = slow.next;
			fast = fast.next;
			if(fast!=null){
				fast = fast.next;
			}
            
			if(slow==fast.next){
				return slow;
			}

		}
		return null;
	}

    public static void main(String[] args) {
    // write your code here
     Node a = new Node("A");
     Node b = new Node("B");
     Node c = new Node("C");
     Node d = new Node("D");
     Node e = new Node("E");

     a.next = b;
     b.next = c;
     c.next = d;
     d.next = e;
     e.next = c;
     System.out.println(loopDetect(a).value);
    }
}