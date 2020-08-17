package Chapter102AdvancedDataStructure.LFUCache.LFUCacheImpleMap;

import java.util.HashMap;

class Solution {
    public int minDays(int n) {
        if(n == 0) return 0;
        if(n == 1) return 1;
        if(n == 2) return 2;
        if(n == 3) return 2;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(1, 1);
        map.put(2, 2);
        map.put(3, 2);
        for(int i = 4; i <= n; ++i){
            int temp = map.get(i-1) + 1;
            if(i % 2 == 0) temp = Math.min(temp, map.get(i/2)+1);
            if(i % 3 == 0) temp = Math.min(temp, map.get(i/3)+1);
            map.put(i, temp);
        }
        return map.get(n);
    }
    public static void main(String[] args){
        int ret = new Solution().minDays(614);
        System.out.println(ret);
    }
}
