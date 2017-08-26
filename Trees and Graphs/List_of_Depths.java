import java.io.*;
import java.util.*;

class Node{
	String value;
	Node left,right;
	Node(String input){
		value = input;
		left = right = null;
	}
}

public class Main{

	public static ArrayList<LinkedList<String>> solve(Node root){
		ArrayList<LinkedList<String>> result = new ArrayList<LinkedList<String>>();
		Queue<Node> que = new LinkedList<Node>();
		que.add(root);
		que.add(null);
		int i=0;
		result.add(new LinkedList<String>());
		while(!que.isEmpty()){
			Node curr = que.poll();
			if(curr==null){
				if(!que.isEmpty()){
					i++;
					result.add(new LinkedList<String>());
					que.add(curr);
				}
			} else {
				result.get(i).add(curr.value);
				if(curr.left!=null){
					que.add(curr.left);
				}
				if(curr.right!=null){
					que.add(curr.right);
				}
			}
		}
		return result;
	}

	public static void display(ArrayList<LinkedList<String>> result){
		for(int i=0;i<result.size();i++){
			for(int j=0;j<result.get(i).size();j++){
				System.out.print(result.get(i).get(j)+" ");
			}
			System.out.println();
		}
	}

	public static void main(String[] args){
		Node a = new Node("A");
		Node b = new Node("B");
		Node c = new Node("C");
		Node d = new Node("D");
		Node e = new Node("E");
		Node f = new Node("F");
		Node g = new Node("G");

		a.left = b;
		a.right = c;
		b.left = d;
		b.right = e;
		c.left = f;
		c.right = g;

		display(solve(a));
	}
}
