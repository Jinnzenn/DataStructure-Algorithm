//LeetCode 249 Group Shift Strings
import java.util.HashMap;
import java.util.ArrayList;
import java.util.List;
public class Solution{
    public List<List<String>> groupStrings(String[] strings){
        HashMap<String, List<String>> map = new HashMap<>();
        for(String str: strings){
            String strbased = change2Base(str);
            if(!map.containsKey(strbased)) map.put(strbased, new ArrayList<String>());
            map.get(strbased).add(str);
        }
        return new ArrayList<List<String>>(map.values());
    }

    public String change2Base(String str){
        StringBuilder sb = new StringBuilder();
        int diff = str.charAt(1) - 'a';
        char[] chars = str.toCharArray();
        for(char ch : chars){
            char temp = (ch - 'a') < diff ? (char)(ch-diff+26) : (char)(ch-diff);
            sb.append(temp); 
        }
        return sb.toString();
    }
}
