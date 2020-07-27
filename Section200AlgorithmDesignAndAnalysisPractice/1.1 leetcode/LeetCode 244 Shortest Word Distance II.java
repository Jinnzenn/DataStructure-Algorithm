//LeetCode 244 Shortest Word Distance
//time:O(m*n)
//space:O(n)
import java.util.*;
class Solution{
    private HashMap<String,List<Integer>> map;  //word,index(list)
    public ShortestWordDistanceII(String words){
        map = new HashMap<>();
        for(int i=0 ; i<words.length ; i++){
            if(map.containsKey(word[i])){
                map.get(word[i]).add(i);
            }else{
                List<Integer> list = new ArrayList<>();
                list.add(i);
                map.put(word[i],list);
            }
        }
    }
    //time:O(m*n) 穷举所有索引组合
    public int shortest(String word1,String word2){
        List<Integer> l1 = map.get(word1);
        List<Integer> l2 = map.get(word2);
        int res = Integer.MAX_VALUE;
        for(int num1 : l1){
            for(int num2 : l2){
                res = Math.min(res,math.abs(num1-num2));
            }
        }
        return res;
    }
}

//双指针法
//time:O(m+n)
//space:O(n)
class Solution{
    private HashMap<String,List<Integer>> map;  //word,index(list)
    public ShortestWordDistanceII(String words){
        map = new HashMap<>();
        for(int i=0 ; i<words.length ; i++){
            if(map.containsKey(word[i])){
                map.get(word[i]).add(i);
            }else{
                List<Integer> list = new ArrayList<>();
                list.add(i);
                map.put(word[i],list);
    }
    //time:O(m+n)
    public int shortest(String word1,String word2){
        List<Integer> l1 = map.get(word1);
        List<Integer> l2 = map.get(word2);
        int res = Integer.MAX_VALUE;
        int i=0,j=0;
        while(i<l1.size() && j<l2.size()){
            res = Math.min(res,Math.abs(l1.get(i),l2.get(j));
            if(l1.get(i)<l2.get(j)){
                i++;
            }else{
                j++;
            }
        }
        return res;
    }
}