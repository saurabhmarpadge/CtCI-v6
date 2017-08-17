package com.company;

import java.util.Scanner;

public class Main {

	   public static boolean compare(String input, int index, String input2, int index2){
		while(index<input.length()){
			if(input.charAt(index)!=input2.charAt(index2)){
				return false;
			}
			index++;
			index2 = (index2+1) % input2.length();
		}
		return true;
	}

    public static void main(String[] args) {
    // write your code here
        Scanner in = new Scanner(System.in);

        String input = in.nextLine();
        String input2 = in.nextLine();

        Character begin = input.charAt(0);

        for(int start = 0;start<input2.length();start++){
        	if(input2.charAt(start)==begin){
        		if(compare(input,0,input2,start)){
        			System.out.println("true");
        			return;
        		}
        	}
        }
        System.out.println("false");
    }
}
