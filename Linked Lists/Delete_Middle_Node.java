package com.company;
import java.io.*;

class Node{
    String value;
    Node next;
    Node(String data){
        value = data;
        next = null;
    }
}

class Delete{
    Node head;
    Delete(Node input){
        head = input;
    }

    void solve(Node input){
        Node target = input;
        target.value = target.next.value;
        target.next = target.next.next;
    }

    void print(){
    	Node curr = head;
    	while(curr!=null){
    		System.out.println(curr.value);
    		curr = curr.next;
    	}
    }
}


public class Main {

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
        e.next = null;

        Delete obj = new Delete(a);
        obj.print();
        obj.solve(c);
        obj.print();
    }
}
