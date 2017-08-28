 /*
  * All three Maps are implementations of Map Interface.
  */

import java.util.*;
import java.io.*;

class Person{
  int id;
  String email;
  Person(int id, String email){
    this.id = id;
    this.email = email;
  }
}

public class Main{
  public static void main(String[] args){

    /*
     * HashMap - Any Ordering, O(1) lookUp and insertion, it is implementation of Array of linked lists.
     */
    System.out.println("HashMap");
    Map<String,Person> myMap = new HashMap<String,Person>();
    myMap.put("Z",new Person(1,"z@gmail.com"));
    myMap.put("A",new Person(2,"a@gmail.com"));
    myMap.put("J",new Person(3,"j@gmail.com"));
    myMap.put("L",new Person(4,"l@gmail.com"));
    myMap.put("M",new Person(5,"m@gmail.com"));

    System.out.println("Checking by Key "+myMap.containsKey("A"));
    System.out.println("Checking by Value "+myMap.containsValue(new Person(1,"z@gmail.com")));
    System.out.println("Get A "+myMap.get("A").id+" "+myMap.get("A").email);

    for (Map.Entry<String,Person> e: myMap.entrySet()) {
      System.out.println(e.getKey()+" "+e.getValue().id+" "+e.getValue().email);
    }

    System.out.println("Print using Iterator");
    Map<String,Person> myMap1 = new HashMap<String,Person>();
    //Clone
    //myMap1 = (HashMap)myMap.clone();
    myMap1.putAll(myMap);
    Iterator itr = myMap.entrySet().iterator();
    while(itr.hasNext()){
      Map.Entry<String,Person> entry = (Map.Entry<String,Person>)itr.next();
      System.out.println(entry.getKey()+" "+entry.getValue().id+" "+entry.getValue().email);
    }

    /*
     * TreeMap - Sorted Ordering, O(logN) lookUp and insertion, it is implementation of RedBlack Tree and Comparable Interface.
     */
    System.out.println("TreeMap");
    myMap = new TreeMap<String,Person>();
    //or myMap = new TreeMap<String,Person>(myMap);
    myMap.put("Z",new Person(1,"z@gmail.com"));
    myMap.put("A",new Person(2,"a@gmail.com"));
    myMap.put("J",new Person(3,"j@gmail.com"));
    myMap.put("L",new Person(4,"l@gmail.com"));
    myMap.put("M",new Person(5,"m@gmail.com"));

    System.out.println("Remove a Node A " +myMap.remove("A"));
    System.out.println("Print Size "+myMap.size());
    System.out.println("Check if Map is empty "+myMap.isEmpty());

    for(String s: myMap.keySet()){
      System.out.println(s+" "+myMap.get(s).id+" "+myMap.get(s).email);
    }

    /*
     * LinkedHashMap - Maintains Insertion Order, O(1) lookUp and insertion, it is implementation of doubly linked buckets.
     */
     System.out.println("LinkedHashMap");
     myMap = new LinkedHashMap<String,Person>();
     myMap.put("Z",new Person(1,"z@gmail.com"));
     myMap.put("A",new Person(2,"a@gmail.com"));
     myMap.put("J",new Person(3,"j@gmail.com"));
     myMap.put("L",new Person(4,"l@gmail.com"));
     myMap.put("M",new Person(5,"m@gmail.com"));

     Set set = myMap.entrySet();
     itr = set.iterator();
     while(itr.hasNext()){
       Map.Entry<String,Person> e = (Map.Entry<String,Person>) itr.next();
       System.out.println(e.getKey()+" "+e.getValue().id+" "+e.getValue().email);
     }



  }
}
