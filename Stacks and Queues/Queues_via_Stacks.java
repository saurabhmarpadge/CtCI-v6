package com.company;
import java.io.*;
import java.util.*;

class MyQueue{
    Stack<Integer> st1;
    Stack<Integer> st2;

    MyQueue(){
        st1 = new Stack<>();
        st2 = new Stack<>();
    }

    void push(int input){
        st1.push(input);
    }

    int pop(){
        if(st2.empty()){
            while(!st1.empty()){
                st2.push(st1.pop());
            }
        }
        return st2.pop();
    }

    int front(){
        if(st2.empty()){
            while(!st1.empty()){
                st2.push(st1.pop());
            }
        }
        return st2.peek();
    }

}
public class Main {

    public static void main(String[] args) {
    // write your code here
       MyQueue queue = new MyQueue();
       queue.push(1);
       queue.push(2);
       queue.push(3);
       queue.push(4);
       queue.push(5);
       System.out.println(queue.pop());
       System.out.println(queue.pop());
       System.out.println(queue.pop());
       queue.push(3);
       queue.push(4);
       System.out.println(queue.pop());
       System.out.println(queue.pop());
       System.out.println(queue.pop());
       System.out.println(queue.pop());
    }
}

