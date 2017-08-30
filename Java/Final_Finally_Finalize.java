import java.util.*;
import java.io.*;

/*
 * Final - Variable - Once initialized cannot be changed / To create constant variable
           Method   - Prevent Method Overriding
           Class    - Prevent Inheritance
 */

class Final{
  final int A = 1;

  final int B;

  final int C;
  //instance initializer block
  {
    B = 2;
  }
  //B = 6; Compiler Eroor

  Final(){
    C=3;
  }

  static final int D = 4;

  static final int E;

  static{
    E = 5;
  }

class aClass{
  final void function(){
    System.out.println("Hey, Its Final fucntion");
  }
}

final class bClass extends aClass{
  /*void function(){
    System.out.println("Its not possible");
  }*/
}
/*
class cClass extends aClass{
  // Can't inherit from final class
}*/

}

class Finally{
  void A(){
    try{
        System.out.println("try of A");
        throw new RuntimeException();
    }
    finally{
      System.out.println("Done with A");
    }
  }

  void B(){

    try{
      A();
      System.out.println("try of B");//It will not print
    }
    catch(Exception ex){
      System.out.println("Caught Exception");
    }
    finally{
        System.out.println("Done with B");
    }
  }

}


public class Main{
  public void finalize(){
    System.out.println("Finalize Called");
  }
  public static void main(String[] args){
    Final objFinal = new Final();
    System.out.println(objFinal.A+" "+objFinal.B+" "+objFinal.C+" "+objFinal.D+" "+objFinal.E);
    Finally objFinally = new Finally();
    objFinally.B();
    objFinal = null;
    objFinally = null;
    System.gc();
  }
}
