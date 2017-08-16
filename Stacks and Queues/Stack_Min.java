package com.company;
import java.io.*;
import java.util.*;

class modStack extends Stack<Integer>{
  private Stack<Integer> min = new Stack<Integer>();

  public void push(int item){
    if(min.empty()){
        min.push(item);
    } else {
        if(item<min()){
            min.push(item);
        } else {
            min.push(min());
        }
    }
    super.push(item);
  }

  public Integer pop(){
    min.pop();
    return super.pop();
  }

  public Integer min(){
    return min.peek();
  }
}

public class GFG {

    public static void main(String[] args) {
    // write your code here
       modStack stack = new modStack();
       stack.push(2);   System.out.println(stack.min());
       stack.push(-1);  System.out.println(stack.min());
       stack.push(3);   System.out.println(stack.min());
       stack.push(-10); System.out.println(stack.min());
       stack.push(-10); System.out.println(stack.min());
       stack.pop();     System.out.println(stack.min());
       stack.pop();     System.out.println(stack.min());
       stack.push(-20); System.out.println(stack.min());
       stack.pop();     System.out.println(stack.min());
    }
}

