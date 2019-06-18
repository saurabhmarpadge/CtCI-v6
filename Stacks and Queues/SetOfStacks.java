package com.Practice;

import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.List;
import java.util.Stack;

public class SetOfStacks {

    public static void main(String[] args){
        Stacks<Integer> stacks = new Stacks<>();
        stacks.push(1);
        stacks.push(2);
        stacks.push(3);
        stacks.push(4);

        System.out.println(stacks.pop());
        System.out.println(stacks.popAt(1));
        System.out.println(stacks.pop());
        System.out.println(stacks.pop());
    }
}

class Stacks<T> {
    private List<Stack<T>> stackList;
    private static final int CAPACITY = 2;
    Stacks(){
        stackList = new ArrayList<>();
    }

    void push(T data){
        if(stackList.size()==0){
            stackList.add(new Stack<>());
        }
        if(stackList.get(stackList.size()-1).size()<CAPACITY){
            stackList.get(stackList.size()-1).push(data);
        } else {
            stackList.add(new Stack<>());
            stackList.get(stackList.size() - 1).push(data);
        }
    }

    T pop(){
            if(stackList.size()==0){
                throw new EmptyStackException();
            }
            T data = stackList.get(stackList.size()-1).pop();
            if(stackList.get(stackList.size()-1).empty()){
                stackList.remove(stackList.get(stackList.size()-1));
            }
            return data;
    }

    T popAt(int location){
        if(stackList.size()==0){
            throw new EmptyStackException();
        }
        T data = stackList.get(location-1).pop();
        if(stackList.get(location-1).empty()){
            stackList.remove(stackList.get(location-1));
        }
        return data;
    }

}
