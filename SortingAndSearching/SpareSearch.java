import java.util.*;

public class SpareSearch {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>(Arrays.asList("at","","","","ball","","","car","","","dad","",""));
        System.out.println(binarySearch(list,"ball"));
    }
    public static int binarySearch(List<String> list, String target){
        int low = 0;
        int high = list.size();
        while(low<=high){
            int mid = low + ((high-low)/2);
            mid = getValidateMid(list,mid);
            if(mid==-1){
                return -1;
            }
            if(list.get(mid).equals(target)){
                return mid;
            } if(list.get(mid).compareTo(target)>0){
                high =mid-1;
            } else {
                low = mid+1;
            }
        }
        return -1;
    }

    public static int getValidateMid(List<String> list, int mid){
        if(!list.get(mid).equals("")){
            return mid;
        }
        int left = mid-1;
        int right = mid+1;
        while(left>=0&&right<list.size()){
            if(!list.get(left).equals("")){
                return left;
            }
            if(!list.get(right).equals("")){
                return right;
            }
            left--;
            right++;
        }
        return -1;
    }
}