import java.util.*;

public class SortedMatrixSearch {
    public static void main(String[] args) {
        int[][] matrix = new int[][]{
                {1,3,5,9},
                {2,6,8,10},
                {11,13,16,18},
                {12,14,18,19}
        };
        int[] result = matrixSearch(matrix,16);
        System.out.println(result[0]+" "+result[1]);
    }
    public static int[] matrixSearch(int[][] matrix, int target){
        int row = 0;
        int col = matrix[0].length-1;
        while(row<matrix.length&&col>0){
            if(matrix[row][col]==target){
                return new int[]{row,col};
            } else if(matrix[row][col]<target){
                row++;
            } else {
                col--;
            }
        }
        return new int[]{-1,-1};
    }
}