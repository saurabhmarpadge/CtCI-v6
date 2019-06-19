import java.util.HashSet;

public class Parens {
    private static HashSet<String> stringHashSet = new HashSet<String>();
    public static void main(String[] args){
        permute("",3);
    }

    static void permute(String permutedString,int count){
        if(count<=0){
            if(!stringHashSet.contains(permutedString)){
                System.out.println(permutedString);
                stringHashSet.add(permutedString);
            }
            return;
        }
        for(int i = 0; i<=permutedString.length(); i++){
            String temp = permutedString.substring(0,i) + "()" + permutedString.substring(i);
            permute(temp,count-1);
        }

    }
}
