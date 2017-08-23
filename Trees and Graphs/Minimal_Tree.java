import java.io.*;
import java.util.*;

class Node{
	int value;
	Node left;
	Node right;
	Node(int input){
	    value = input;
		left = null;
		right = null;
	}
}

public class Main{

	public static void inOrder(Node root){
		if(root==null){
			return;
		}
		inOrder(root.left);
		System.out.println(root.value);
		inOrder(root.right);
	}

	public static void listToBST(ArrayList<Integer> sortedList){
		inOrder(listToBST(sortedList,0,sortedList.size()-1));
	}

	public static Node listToBST(ArrayList<Integer> sortedList,int start, int end){
		if(end<start){
			return null;
		}
		int mid = (start+end)/2;
		Node root = new Node(sortedList.get(mid));
		root.left = listToBST(sortedList,start,mid-1);
		root.right = listToBST(sortedList,mid+1,end);
		return root;
	}

	public static void main(String[] args){
		ArrayList<Integer> sortedList = new ArrayList<Integer>();
		sortedList.add(1);
		sortedList.add(2);
		sortedList.add(3);
		sortedList.add(4);
		sortedList.add(5);
		sortedList.add(6);
		listToBST(sortedList);
	}
}
