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

class BST{
    Node root;
    BST(){
        root = null;
    }
    boolean solver(Node curr){

        if(curr.left==null && curr.right==null){
            return true;
        }

        if(curr.left != null && curr.right!=null){
            if(curr.value<curr.right.value && curr.value>curr.left.value){
                return solver(curr.left) && solver(curr.right);
            }
        }

        if(curr.left!=null&&curr.right==null){
            return curr.value>curr.left.value;
        }

        if(curr.left==null&&curr.right!=null){
            return curr.value<curr.right.value;
        }

        return false;
    }
}

public class Main {

    public static void main(String[] args) {
        Node a = new Node(1);
        Node b = new Node(2);
        Node c = new Node(3);
        Node d = new Node(4);
        Node e = new Node(5);
        Node f = new Node(6);
        Node g = new Node(7);

        d.left = b;
        b.left = a;
        b.right = c;
        d.right = f;
        f.left = e;
        f.right = g;

        BST obj= new BST();
        System.out.println(obj.solver(d));
    }

}

