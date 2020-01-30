import java.util.*;

public class SearchInRotatedArray {
    public static void main(String[] args) {
        int[] data = {15,16,19,20,25,1,3,4,5,7,10,14};
        System.out.println(binarySearchRotated(data,16));
        System.out.println(binarySearchRotated(data,15));
        System.out.println(binarySearchRotated(data,25));
        System.out.println(binarySearchRotated(data,1));
        System.out.println(binarySearchRotated(data,10));
        System.out.println(binarySearchRotated(data,7));

    }

    public static int binarySearchRotated(int[] data, int target){
        int low = 0;
        int high = data.length-1;
        int ans = -1;
        while(low<=high){
            int mid = low + (high-low)/2;
            if(data[mid]==target){
                ans = data[mid];
                return ans;
            }else if(data[low]<=data[mid]){
                if(data[low]<=target&&data[mid]>target){
                    high = mid -1;
                } else {
                    low = mid + 1;
                }
            } else {
                if(data[mid]<target&&target<=data[high]){
                    low = mid +1;
                } else {
                    high = mid -1;
                }
            }
        }
        return ans;
    }
}