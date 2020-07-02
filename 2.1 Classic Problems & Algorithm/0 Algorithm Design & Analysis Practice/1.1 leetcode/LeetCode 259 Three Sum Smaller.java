//LeetCode 325
public class Solution {
    public int threeSumSmaller(int[] nums, int target) {
        Arrays.sort(nums);
        int count = 0;
        for(int i=0; i<nums.length-2; i++) {
            int j=i+1, k=nums.length-1;
            while (j<k) {
                if (nums[i]+nums[j]+nums[k] < target) {
                    count += k-j;
                    j ++;
                } else {
                    k --;
                }
            }
        }
        return count;
    }
}

//使用TreeMap???
public class Solution {
    public int threeSumSmaller(int[] nums, int target) {
        if (nums == null || nums.length < 3) return 0;
        int counts = 0;
        //映射数值和数值出现次数
        TreeMap<Integer, Integer> treemap = new TreeMap<>();
        treemap.put(nums[0], 1);
        for(int i=1; i<nums.length-1; i++) {
            for(int j=i+1; j<nums.length; j++) {
                //headMap()方法返回key小于目标值的所有Entry，values()返回Entry中value组成的集合
                for(int count: treemap.headMap(target-nums[i]-nums[j]).values()) {
                    counts += count;
                }
            }
            Integer count = treemap.get(nums[i]);
            if (count == null) count = 1; else count ++;
            treemap.put(nums[i], count);
        }
        return counts;
    }
}