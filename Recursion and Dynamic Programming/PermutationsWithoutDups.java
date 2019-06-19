public class PermutationsWithoutDups {
    public static void main(String[] args){
        String str = "abc";
        permute("",str,str.length()-1);
    }

    static void permute(String permutedString, String original, int index){
        if(index<0){
            System.out.println(permutedString);
            return;
        }
        for(int i = 0; i<=permutedString.length(); i++){
            String temp = permutedString.substring(0,i) + original.charAt(index) + permutedString.substring(i);
            permute(temp,original,index-1);
        }

    }
}
