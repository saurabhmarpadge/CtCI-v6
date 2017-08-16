package com.company;

class Node{
    String value;
    Node next;
    Node(String data){
        value = data;
        next = null;
    }
}

class kthsolver{
    Node head;
    kthsolver(Node input){
        head = input;
    }

    void findKth(int k){
        Node ptr1 = head;
        Node ptr2 = head;

        while(k>0){
            ptr2 = ptr2.next;
            k--; 
        }

        while(ptr2!=null){
            ptr1 = ptr1.next;
            ptr2 = ptr2.next;
        }
        System.out.println(ptr1.value);
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

        kthsolver obj = new kthsolver(a);
        obj.findKth(3);
    }
}
