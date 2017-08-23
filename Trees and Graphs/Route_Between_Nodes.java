import java.io.*;
import java.util.*;

class Graph{
    private int V;
    private LinkedList<LinkedList<Integer>> adj;

    Graph(int v){
      V = v;
      adj = new LinkedList<LinkedList<Integer>>();
      for(int i=0;i<V+1;i++){
        adj.add(new LinkedList<Integer>());
      }
    }

  void addEdge(int u, int v){
    adj.get(u).add(v);
  }

  boolean isReachable(int s, int d){
    LinkedList<Integer> que = new LinkedList<Integer>();
    que.add(s);
    boolean[] visited = new boolean[V+1];
    while(!que.isEmpty()){
      s = que.poll();
      visited[s] = true;
      Iterator<Integer> i = adj.get(s).listIterator();
      while(i.hasNext()){
        s = i.next();
        if(s==d){
          return true;
        }
        if(!visited[s]){
          visited[s] = true;
          que.push(s);
        }
      }
    }
    return false;
  }
}

class Main{
public static void main(String[] args){
  Graph g = new Graph(5);
  g.addEdge(1,2);
  g.addEdge(2,5);
  g.addEdge(1,4);
  g.addEdge(3,2);
  g.addEdge(4,2);
  g.addEdge(4,5);
  int s = 1;	//source
  int d = 3;	//destination
  if(g.isReachable(s,d)){
    System.out.println(s+" is Reachable to "+d);
  } else {
    System.out.println(s+" is Not Reachable to "+d);
  }
}
}
