package com.company;
import java.io.*;
import java.util.*;

	class Node{
		String value;
		Node next;
		Node(String input){
			value = input;
			next = null;
		}
	}

public class Main {

	 public static void print(Node head){
        Node curr = head;
        while(curr!=null){
           System.out.println(curr.value);
           curr = curr.next;
       }
    }

	public static void removeDups(Node head){
		Node first = head;
		Node second;

		while(first!=null){
		    Node prev = first;
			second = first.next;
			while(prev.next!=null){
				if(first.value.equals(second.value)){
				    second = second.next;
				    prev.next = second;
				} else {
				    prev = prev.next;
                    second= second.next;
				}
			}
			    first = first.next;
		}
	
	}

    public static void main(String[] args) {
    // write your code here
       Node a = new Node("A");
       Node b = new Node("B");
       Node c = new Node("B");
       Node d = new Node("A");
       Node e = new Node("D");
       Node f = new Node("D");
       a.next = b;
       b.next = c;
       c.next = d;
       d.next = e;
       e.next = f;
       f.next = null;

       //Remove Duplicates
       removeDups(a);
       
       //Print List
       print(a);
    }
}
