package com.company;

import java.util.Scanner;

public class Main {

     public static void main(String[] args) {
    // write your code here
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int[][] arr = new int[N][N];
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                if(in.hasNext()){
                    arr[i][j] = in.nextInt();
                }
                
            }
        }
        
        for(int i=1;i<N;i++){
            for(int j=1;j<N;j++){
                if(arr[i][j]==0){
                    arr[i][0]=0;
                    arr[0][j]=0;
                }
            }
        }

        for(int i=1;i<N;i++){
            for(int j=1;j<N;j++){
                if( arr[i][0]==0 ||  arr[0][j]==0){                   
                    arr[i][j]=0;
                }
            }
        }

        if(arr[0][0]==0){
            for(int i=0;i<N;i++){
                arr[i][0]=0;
                arr[0][i]=0;
            }
        }

        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }

    }

}
