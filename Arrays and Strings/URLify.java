package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Scanner in = new Scanner(System.in);
        String input = in.nextLine();

        StringBuilder result = new StringBuilder();
        boolean flag = true;
        for (int i = 0; i <input.length() ; i++) {
             if(input.charAt(i)!=' '){
                 result.append(input.charAt(i));
                 flag = true;
             } else {
                 if(flag) {
                     result.append(input.charAt(i));
                    flag = false;
                 }
             }
        }
        for (int i = 0; i <result.length() ; i++) {
            if(i==result.length()-1  && result.charAt(i)==' '){
                break;
            }
            if(!(i==0&& result.charAt(i)==' ')){

                if (result.charAt(i) == ' ') {
                    System.out.print("%20");
                } else {
                    System.out.print(result.charAt(i));
                }
            }
        }
    }

}
