package Chapter201ClassicProblemsAndAlgorithm.Section200AlgorithmDesignAndAnalysisPractice.LeetCode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class Solution {
    public int numTriplets(int[] nums1, int[] nums2) {
        int count1 = 0;
        Map<Integer, Integer> map1 = new HashMap<>();
        for(int i = 0; i < nums1.length; ++i){
            int product = nums1[i] * nums1[i];
            map1.put(product, map1.getOrDefault(product, 0) + 1);
        }
        for(int i = 0; i < nums2.length; ++i){
            for(int j = i+1; j < nums2.length; ++j){
                int product = nums2[i] * nums2[j];
                if(map1.containsKey(product)){
                    count1 += map1.get(product);
                }
            }
        }
        return count1;
    }
    public static void main(String[] args){
        int[] arr1 = new int[] {43024, 99908};
        int[] arr2 = new int[] {1864};
        int count1 = new Solution().numTriplets(arr1, arr2);
        int count2 = new Solution().numTriplets(arr2, arr1);
        System.out.println(count1 +  " " + count2);
    }
}