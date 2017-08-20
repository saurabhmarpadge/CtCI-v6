package com.company;
import java.io.*;
import java.util.*;

class Main {
	public static void main (String[] args) {
		//code
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		ArrayList<ArrayList<Integer>> arr = new ArrayList<ArrayList<Integer>>();
		
		for(int i=0;i<N;i++){
		    arr.add(new ArrayList<Integer>());
		    for(int j=0;j<N;j++){
		        arr.get(i).add(in.nextInt());
		    }
		}
		
		for(int i=0;i<N/2;i++){
			for(int j=i;j<N-1-i;j++){
				int temp = arr.get(i).get(j);
				arr.get(i).set(j,arr.get(j).get(N-1-i));
				arr.get(j).set(N-1-i,arr.get(N-1-i).get(N-1-j));
				arr.get(N-1-i).set(N-1-j,arr.get(N-1-j).get(i));
				arr.get(N-1-j).set(i,temp);
			}
		}
		
				
		for(int i=0;i<arr.size();i++){
		    for(int j=0;j<arr.get(i).size();j++){
		        System.out.print(arr.get(i).get(j)+" ");
		    }
		    System.out.println();
		}
	}
}