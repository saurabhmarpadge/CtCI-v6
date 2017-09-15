import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    static long getWays(long money, long[] c,int index, HashMap<String,Long> memo){
        if(money==0){
            return 1;
        }
        if(index>=c.length){
            return 0;
        }
        String key = money +":"+ index;
        if(memo.containsKey(key)){
            return memo.get(key);
        }
        long ways = 0;
        long amt = money;
        while(amt>=0){
            ways += getWays(amt,c,index+1,memo);
            amt -= c[index];
        }
        memo.put(key,ways);
        return ways;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        long[] c = new long[m];
        for(int c_i=0; c_i < m; c_i++){
            c[c_i] = in.nextLong();
        }
        System.out.println(getWays(n, c, 0,new HashMap<String,Long>()));
    }
}
