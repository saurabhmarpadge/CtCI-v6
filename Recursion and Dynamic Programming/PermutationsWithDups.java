
import java.util.HashSet;
import java.util.Set;

public class PermutationsWithDups {
    private static Set<String> stringHashSet = new HashSet<String>();
    public static void main(String[] args){

        String str = "aba";
        permute("",str,str.length()-1);
        for(String string : stringHashSet){
            System.out.println(string);
        }
    }

    static void permute(String permutedString, String original, int index){
        if(index<0){
            stringHashSet.add(permutedString);
            return;
        }
        for(int i = 0; i<=permutedString.length(); i++){
            String temp = permutedString.substring(0,i) + original.charAt(index) + permutedString.substring(i);
            permute(temp,original,index-1);
        }

    }
}
