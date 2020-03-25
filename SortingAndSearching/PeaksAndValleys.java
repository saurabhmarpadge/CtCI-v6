import java.util.*;

public class PeaksAndValleys{
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(Arrays.asList(5,3,1,2,3,9));
        list = getPeakValleys(list);
        for(int num:list){
            System.out.print(num+" ");
        }
    }
    public static List<Integer> getPeakValleys(List<Integer> list){
        if(list.size()<=2){
            return list;
        }
        for(int idx=1;idx<list.size()-1;idx+=2){
            int bigIndex = getBigIndex(list,idx-1,idx,idx+1);
            if(idx!=bigIndex){
                swap(list,idx,bigIndex);
            }
        }
        return list;
    }

    public static void swap(List<Integer> list, int first, int second){
        int temp = list.get(first);
        list.set(first,list.get(second));
        list.set(second,temp);
    }
    public static int getBigIndex(List<Integer> list,int a, int b, int c){
        int maxi = list.get(a)>list.get(b)?a:b;
        return list.get(maxi)>list.get(c)?maxi:c;
    }
}