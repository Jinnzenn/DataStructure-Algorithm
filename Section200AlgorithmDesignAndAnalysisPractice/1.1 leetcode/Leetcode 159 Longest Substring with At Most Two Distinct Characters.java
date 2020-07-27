//Leetcode 159 Longest Substring with At Most Two Distinct Characters
public class Solution{
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        int[] characterCount = new int[26];
        int start = 0, end = 0, charNum = 0, maxLen = 0;
        while(end < s.length()){
            char c = s.charAt(end);
            characterCount[c-'a']++;
            if(characterCount[c-'a'] == 1) charNum++;
            while(charNum>2){
                //start向右移动只到满足要求
                char temp = s.charAt(start);
                characterCount[temp-'a']--;
                if(characterCount[temp-'a'] == 0) charNum--;
                start++;
            }
            maxLen = Math.max(maxLen, end - start + 1);
            end++;
        } 
    }
}