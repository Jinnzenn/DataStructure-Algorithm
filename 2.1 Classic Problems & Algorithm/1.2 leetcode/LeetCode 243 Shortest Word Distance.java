//LeetCode 243
//Time O(n)
public class Solution {
    public int shortestDistance(String[] words, String word1, String word2){
        int pos1 = -1;
        int pos2 = -1;
        int distance = words.length;//求最短距离，这里相当于初始化为正无穷
        for(int i=0; i<words.length; i++) {
            if (word1.equals(words[i])) {
                pos1 = i;
                if (pos2 != -1 && pos1-pos2<distance) distance = pos1-pos2;
            } else if (word2.equals(words[i])) {
                pos2 = i;
                if (pos1 != -1 && pos2-pos1<distance) distance = pos2-pos1;
            }
        }
        return distance;
    }
}

//双指针写法
public class Solution{
    public int shortestDistance(String[] words, String word1, String word2){
        int pos1 = 0, pos2 = 0;
        int minDistance = words.length;
        //初始化
        while(pos1<words.length && words[pos1] != word1) pos1++;
        while(pos2<words.length && words[pos2] != word2) pos2++;
        for(pos1<words.length && pos2<words.length){
            minDistance == Math.min(minDistance, Math.abs(pos1-pos2));
            if(pos1 < pos2){
                while(pos1<words.length && words[pos1] != word1) pos1++;//找到下一个候选索引
            }else{
                while(pos2<words.length && words[pos2] != word2) pos2++;//找到下一个候选索引
            }
        }
        return minDistance;
    }
}