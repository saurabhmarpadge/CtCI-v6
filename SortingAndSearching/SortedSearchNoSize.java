import java.util.*;

public class SortedSearchNoSize {
    public static void main(String[] args) {
        int[] data = {1,2,3,4,4,5,6,7,8};
        System.out.println(getIndex(4,data));
    }

    public static int getElement(int index, int[] array){
        if(index<array.length){
            return array[index];
        }
        return -1;
    }

    public static int getIndex(int x,int[] array){
        int idx=0;
        while(getElement(idx,array)!=-1 && getElement(idx,array)<x){
            if(idx==0){
                idx=1;
            } else {
                idx*=2;
            }
        }
        return binarySearch(array,x,idx/2,idx);
    }

    public static int binarySearch(int[] data, int target, int low, int high){
        while(low<=high){
            int mid = low + ((high-low)/2);
            if(mid==-1||data[mid]>target){
                high=mid-1;
            } else if(data[mid]<target) {
                low=mid+1;
            } else {
                return mid;
            }
        }
        return -1;
    }
}