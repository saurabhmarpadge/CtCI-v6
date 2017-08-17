package com.company;

import java.util.Scanner;
import java.util.Stack;

public class Main {

    public static Stack<Integer> printing(Stack<Integer> input){
        Stack<Integer> temp = new Stack<Integer>();
        while(!input.empty()){
            temp.push(input.pop());
        }

        while(!temp.empty()){
            System.out.print(temp.peek()+" ");
            input.push(temp.pop());
        }
        System.out.println();
        return input;
    }

    public static void main(String[] args) {
	// write your code here
        Stack<Integer> min = new Stack<>();
        Stack<Integer> max = new Stack<>();

        int buff =0;

        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        for (int i = 0; i <N ; i++) {

            max.push(in.nextInt());
        }


        boolean stop = true;
        boolean ch = true;
        while(stop){
            if(ch){
                //System.out.println("max -> min");
                // max = printing(max);
                buff = max.pop();
                while(!max.empty()){

                    if(buff>max.peek()){

                        min.push(max.pop());
                        if(max.empty()){
                            min.push(buff);
                        }

                    } else {

                        min.push(buff);
                        if(!max.empty()){
                            buff = max.pop();
                        }
                        if(max.empty()){
                            min.push(buff);
                        }

                    }

                }
                //min = printing(min);
                ch=false;
            } else {
               // System.out.println("min -> max");
                // min = printing(min);
                boolean close = true;
                buff = min.pop();
                while(!min.empty()){

                    if(buff>min.peek()){
                        if(!max.empty()){
                            if(close && max.peek()<buff){
                                close = false;
                            }
                        }
                        max.push(buff);
                        if(!min.empty()){
                            buff = min.pop();
                        }
                        if(min.empty()){
                            if(!max.empty()){
                                if(close && max.peek()<buff){
                                    close = false;
                                }
                            }
                            max.push(buff);
                        }

                    } else {
                        if(!max.empty()){
                            if(close && max.peek()<min.peek()){
                                close = false;
                            }
                        }
                        max.push(min.pop());
                        if(min.empty()){
                            if(!max.empty()){
                                if(close && max.peek()<buff){
                                    close = false;
                                }
                            }
                            max.push(buff);
                        }

                    }
                }
               // max = printing(max);
                ch = true;
                if(close){
                    stop = false;
                }

            }
        }
        while (!max.empty()){
            System.out.print(max.pop()+" ");
        }
        System.out.println();
    }
}

