//LeetCode 325 和 LeetCode 560有关
//暴力解法 O(n*n)
class Solution {
    public int maxSubArrayLen(int[] nums, int k) {
        int maxLen = 0;
        for(int i = 0; i < nums.length; i++){
            int tempSum = 0;
            for(int j = 0; j < nums.length; j++){
                tempSum += nums[j];
                if(tempSum == k) maxLen = Math.max(maxLen, j-i+1);
            }
        }
        return maxLen;
    }
}

//计算累计值，建立累计值和索引的映射（sum(0~i),i)
//O(n)
class Solution{
    public int maxSubArrayLen(int[] nums, int k){
        int maxLen = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        map.put(0, 1);//关键代码，对于第一次遇到累加和为k时，代码能够计算maxLen
        for(int i = 0; i < nums.length; i++){
            sum += nums[i];
            if(!map.containsKey(sum)) map.put(sum, i);
            if(map.containsKey(sum-k)) maxLen = Math.max(maxLen, 1 + i - map.get(sum-k));
        }
        return maxLen;

    }
}
