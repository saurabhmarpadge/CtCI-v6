import java.util.*;

public class GroupAnagrams {
    public static void main(String[] args) {
        List<String> result = groupAnagram(new ArrayList<>(Arrays.asList("abc","cba","bca","ghi","iac","ihg","cai")));
        for(String str:result){
            System.out.println(str);
        }
    }

    public static List<String> groupAnagram(ArrayList<String> strs){
        HashMap<String,ArrayList<String>> hm = new HashMap<>();
        for(String str:strs){
            String key = sortString(str);
            if(!hm.containsKey(key)){
                hm.put(key,new ArrayList<>());
            }
            ArrayList<String> list = hm.get(key);
            list.add(str);
        }
        List<String> result = new ArrayList<>();
        for(String sKey:hm.keySet()){
            for(String str:hm.get(sKey)){
                result.add(str);
            }
        }
        return result;
    }
    public static String sortString(String string){
        char[] chars = string.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }
}