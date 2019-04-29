
class LinkedList {
  int data;
  LinkedList next;
  LinkedList(int data){
    this.data = data;
  }
}

public class Partition {
  public static void main(String[] args){
    LinkedList a = new LinkedList(3);
    LinkedList b = new LinkedList(5);
    LinkedList c = new LinkedList(8);
    LinkedList d = new LinkedList(2);
    LinkedList e = new LinkedList(5);
    LinkedList f = new LinkedList(1);
    LinkedList g = new LinkedList(10);
    a.next = b;
    b.next = c;
    c.next = d;
    d.next = e;
    e.next = f;
    f.next = g;
    g.next = null;
    LinkedList node = getPartitionedList(a,5);
    displayList(node);
  }
  static void displayList(LinkedList node){
    while(node!=null){
      System.out.print(node.data+" ");
      node = node.next;
    }
  }
  static LinkedList getPartitionedList(LinkedList node, int pivot){
    if(node==null){
      return null;
    }
    LinkedList head = null;
    LinkedList tail = null;
    while(node!=null){
      LinkedList currNode = new LinkedList(node.data);
      if(head==null){
        head = currNode;
        tail = currNode;
      } else if(pivot>currNode.data){
        currNode.next = head;
        head = currNode;
      } else {
        tail.next = currNode;
        tail = currNode;
      }
      node = node.next;
    }
    return head;
  }
}
