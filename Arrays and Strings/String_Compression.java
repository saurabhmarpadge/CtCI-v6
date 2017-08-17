package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
    // write your code here
        Scanner in = new Scanner(System.in);
        String input = in.nextLine();

        ArrayList<Character> ch = new ArrayList<>();
        ArrayList<Integer> chcount = new ArrayList<>();
        Character curr = input.charAt(0);
        int count;
         //ch.add(curr);
        int i=0;
        while(true){
            count=0;
            while(i<input.length() && curr==input.charAt(i)){
                count++;
                i++;
            }
            ch.add(curr);
            
            chcount.add(count);
            if(i>=input.length()){
                break;
            } else {
                curr = input.charAt(i);
            }
        }
        if(input.length()==ch.size()){
            System.out.println(input);
        } else{
            for(int itr=0;itr<ch.size();itr++){
                System.out.print(ch.get(itr)+""+chcount.get(itr));
            }
        }

    }

}
