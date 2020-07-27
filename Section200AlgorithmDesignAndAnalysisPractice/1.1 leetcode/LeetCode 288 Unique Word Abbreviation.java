import java.util.*;
public class ValidWordAbbr {
    Map<String, Set<String>> map;
    public ValidWordAbbr(String[] dictionary) {
        map = new HashMap<>();
        for (String s : dictionary) {
            String abbr = getAbbr(s);
            if (!map.containsKey(abbr)) {
                map.put(abbr, new HashSet<String>());
            }
            map.get(abbr).add(s);
        }
    }
 
    public boolean isUnique(String word) {
        String abbr = getAbbr(word);
        if (!map.containsKey(abbr) || (map.get(abbr).contains(word) && map.get(abbr).size() == 1)) {
            return true;
        }
        return false;
    }
     
    private String getAbbr(String s) {
        //StringBuilder temp = new StringBuilder();
        
        if (s.length() < 3) {
            return s;
        }
        int len = s.length();
        return s.substring(0, 1) + (len - 2) + s.substring(len - 1);
    }
}　　