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
    private static Node globalhead;
	public static void palindrome(Node head){
		Node head1 = head;
		Node head2 = findMid(head);
	    int temp = 0;
		if(counting(head)){
		    temp = head2.value;
		    head2 = head2.next;
		}
		head2 = makeReverse(head2);
		System.out.println(compare(head1,head2));
		merge(head1,head2,temp);
	}
	
    public static boolean counting(Node head){
        Node curr = head;
        int count = 0;
        while(curr!=null){
        	count++;
        	curr=curr.next;
        }
        return (count%2!=0);
    }

	public static void merge(Node head1,Node head2,int temp){
		Node curr = head1;
		while(curr.next!=null){
			curr = curr.next;
		}
		if(temp!=0){
		    curr.next = new Node(temp);
		    curr = curr.next;
		}
		head2 = makeReverse(head2);
		curr.next = head2;
		display(head1);
	}

	public static Node makeReverse(Node curr){
		globalhead = null;
		reverse(curr);
		return globalhead;
	}
	public static void reverse(Node curr){
		if(curr.next == null){
			globalhead = curr;
			return;
		}
		reverse(curr.next);
		Node temp = curr.next;
		temp.next = curr;
		curr.next = null;
		return;
	}

	public static Node findMid(Node head){
		Node fast = head;
		Node slow = head;
		Node preSlow = null;

		while(fast!=null&&fast.next!=null){
			fast = fast.next.next;
			preSlow = slow;
			slow = slow.next;
		}
		preSlow.next = null;
		return slow;
	}

	public static boolean compare(Node head1,Node head2){
		Node first = head1;
		Node second = head2;
		while(first!=null&&second!=null){
			if(first.value!=second.value){
				return false;
			}
			first = first.next;
			second = second.next;
		}
		return true;
	}

	public static void display(Node head){
		Node curr = head;
		while(curr!=null){
			System.out.print(curr.value+" ");
			curr = curr.next;
		}
		System.out.println();
	}

    public static void main(String[] args) {
    // write your code here
       Node a = new Node(1);
       Node b = new Node(2);
       Node c = new Node(3);
       Node d = new Node(4);
       Node e = new Node(3);
       Node f = new Node(2);
       Node h = new Node(1);
       a.next = b;
       b.next = c;
       c.next = d;
       d.next = e;
       e.next = f;
       f.next = h;
       h.next = null;
       palindrome(a);
    }

}
