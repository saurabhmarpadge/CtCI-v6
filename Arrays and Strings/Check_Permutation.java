package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Scanner in = new Scanner(System.in);
        String one = in.next();
        String two = in.next();

        int visited[] = new int[26];

        for (int i = 0; i <one.length() ; i++) {
            int temp = one.charAt(i) - 'a';
            visited[temp]++;
        }
        for (int i = 0; i <two.length() ; i++) {
            int temp = one.charAt(i) - 'a';
            visited[temp]++;
        }
        for (int i = 0; i <26 ; i++) {
            if(visited[i]%2!=0){
                System.out.println("No");
                return;
            }
        }
        System.out.println("Yes");
    }
}
