import java.util.HashMap;
import java.util.Map;
public class Solution{
    public int count = 0;
    public int strobogrammaticInRange(String low, String high){
        HashMap<Character, Character> map = new HashMap<>();
        map.put('0', '0');
        map.put('6', '9');
        map.put('8', '8');
        map.put('9', '6');
        //求出所有长度的数字，并逐一和low high比较
        for(int i = low.length(); i <= high.length(); i++){
            dfs(map, 0, i, new int[i], low, high);
        }
        return count;
    }

    private void dfs(Map<Character, Character> map, int index, int limit, int[] buffer, String low, String high){
        if(index == (limit+1)/2){
            String num = String.valueOf(buffer);//数组转String
            if(limit == low.length() && num.compareTo(low)<0 
            || limit == high.length() && num.compareTo(high)>0){
                return;
            }
            count++;
            return;
        }
        for(Character ch : map.keySet()){
            //注意以0开头，以6/9为中心点的情况要跳过(n==1时例外)
            if(limit != 1 && index == 0 && ch == '0') continue;
            //if(limit!=1 && index==n/2 && ch != map.get(ch))
            if(limit != 1 && index == n/2 && (ch=='6' || ch=='9')) continue;
            buffer[index] = ch;
            buffer[limit-1-index] = map.get(ch);
            dfs(map, index+1, limit, buffer, low, high);
        }
    }
}