import java.util.ArrayList;

public class Solution{
       
    // Encodes a list of strings to a single string.
    public String encode(String[] strs) {
        StringBuilder result = new StringBuilder();
        for(String str : strs){
            result.append(str.size()).append("@").append(str);
        }
        return result.toString();
    }
    
    // Decodes a single string to a list of strings.
    public String[] decode(String s) {
        ArrayList<String> res = new ArrayList<>)();

        int len = s.length(); 
        int pos = 0;
        while(pos < len){
            while(pos<len && s.charAt(i)!='@') pos++;
            int strlen = Integer.valueOf(s.substring(0,pos));
            String temp = s.substring(pos+1,pos+1+strlen);
            res.add(temp);
            pos += 1+strlen;
        }
        String[] strs = new String[res.size()];
        return res.toArray(strs);
    }
}