//LeetCode 247 Strobogrammatic Number II
import java.util.*;

public class Solution{
    public List<String> findStrobogrammatic(int n) {
        List<String> res = new ArrayList<>();
		if (n == 0)
			return res;
		if (n == 1)
            return Arrays.asList("0", "1", "8");
        Map<Character, Character> map = new HashMap<Character, Character>();
        map.put('0', '0');
        map.put('1', '1');
        map.put('6', '9');
        map.put('8', '8');
        map.put('9', '6');
        dfs(map, new char[n], 0, n, res);
		return res;
    }

    private void dfs(Map<Character, Character> map, char[] buffer, int index, int n, List<String> res){
        //n==3 index = 2 pass the middle line; n==4 index = 2 pass the middle line
        if(index == (n+1)/2){
            res.add(String.valueOf(buffer));
            return;
        }
        for(char ch : map.keySet()){
            if(index == 0 && n > 1 && ch == '0') continue;
            //n==3 n/2=1 ; n==4 n/2==2
            if(index == n/2 && (ch=='6' || ch=='9')) continue;
            buffer[index] = ch;
            buffer[n-1-index] = map.get(ch);
            dfs(map, buffer, index+1, n, res);
        }
    }
}