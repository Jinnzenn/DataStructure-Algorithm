public class Leetcode 340 Longest Substring with At Most K Distinct Characters {
    public int lengthOfLongestSubstringTwoDistinct(String s, int k) {
        char[] chars = s.toCharArray();
        int[] charCount = new int[256];
        for(char ch : chars){
            charCount[ch]++;
        }
        int charNum = 0;
        int left = 0, right = 0;
        int maxLen = 0;
        while(right < chars.length){
            char ch = chars[right];
            charCount[ch]++;
            if(charCount[ch] == 1) charNum++;
            while(charNum>k){
                char ch = chars[left];
                charCount[ch]--;
                if(charCount[ch] == 0) charNum--;
                left++;
            }
            maxLen = Math.max(right-left+1, maxLen);
            right++;
        }
        return maxLen;
    }

}