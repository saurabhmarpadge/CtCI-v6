import java.util.*;
import java.io.*;

class Node{
    Node prev,next;
    int key,value;
    Node(int key, int value){
        this.key = key;
        this.value = value;
        this.prev = null;
        this.next = null;
    }
}

class LRUCache{
    int capacity=5;
    Node start,end;
    HashMap<Integer,Node> hm;

    LRUCache(int capacity){
        start = end = null;
        this.capacity = capacity;
        hm = new HashMap<Integer,Node>();
    }

    void set(int key, int value){
        if(hm.containsKey(key)){
            Node old = hm.get(key);
            old.value = value;
            removeNode(old);
            insertAtFirst(old);
        } else {
            if(hm.size()>=capacity){
                hm.remove(end.key);
                removeNode(end);
            }
            Node newNode = new Node(key,value);
            insertAtFirst(newNode);
            hm.put(key,newNode);
        }
    }


    int get(int key){
        if(hm.containsKey(key)){
             Node curr = hm.get(key);
             removeNode(curr);
             insertAtFirst(curr);
             return curr.value;
         }
         return -1;
    }

    void insertAtFirst(Node instNode){
        instNode.next = start;
        instNode.prev = null;

        if(start!=null){
            start.prev = instNode;
        }
        start = instNode;

        if(end==null){
          end = start;
        }
    }

    void removeNode(Node rmNode){
        if(rmNode.prev!=null){
            rmNode.prev.next = rmNode.next;
        } else {
          start = rmNode.next;
        }
        if(rmNode.next!=null){
            rmNode.next.prev = rmNode.prev;
        } else {
          end = rmNode.prev;
        }
    }

}

public class Main{
    public static void main(String[] args){
        LRUCache cache = new LRUCache(5);
        cache.set(1,15);
        cache.set(2,24);
        System.out.println(cache.get(5));
        cache.set(3,33);
        cache.set(4,42);
        System.out.println(cache.get(3));
        cache.set(5,34);
        System.out.println(cache.get(5));
        cache.set(6,67);
        cache.set(7,67);
        System.out.println(cache.get(6));
        cache.set(6,89);
        System.out.println(cache.get(6));
    }
}
