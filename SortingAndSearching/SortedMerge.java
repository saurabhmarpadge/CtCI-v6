import java.util.*;

public class SortedMerge {
    public static void main(String[] args) {
        int[] A = new int[10];
        int[] B = new int[5];
        for(int idx=0,idxJ=1;idx<5;idx++,idxJ+=2){
            A[idx]=idxJ;
            B[idx]=idxJ+1;
        }
        merge2Array(A,B,5,5);
        for(int num:A){
            System.out.print(num+" ");
        }
    }

    public static void merge2Array(int[] A, int[] B,int nA, int nB){
        int p1 = nA-1;
        int p2 = nB-1;
        int mergeIdx = A.length-1;
        while(p2>=0) {
            if (A[p1] > B[p2]) {
                A[mergeIdx--] = A[p1--];
            } else {
                A[mergeIdx--] = B[p2--];
            }
        }
    }
}