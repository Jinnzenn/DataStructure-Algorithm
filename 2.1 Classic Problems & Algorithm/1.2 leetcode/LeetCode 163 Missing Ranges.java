//LeetCode 163
//注意,数组元素一定都在界内。
public class Solution {
    private String range(int lower, int upper) {
        if (lower == upper) return Integer.toString(lower);
        return lower + "->" + upper;//用StringBuilder会更快
    }
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> ranges = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            ranges.add(range(lower, upper));
            return ranges;
        }

        if (nums[0] > lower ) ranges.add(range(lower, nums[0]-1));
        //如果nums数组的元素可能落在界外，注意调整下标i的范围，从[0, nums.length] 调整为[firstIndexOfIligel,lastindexOfIligel] 合法元素值(lower, uppper)
        for(int i=0; i<nums.length-1; i++) {
            if (nums[i] + 1 < nums[i+1]) ranges.add(range(nums[i]+1, nums[i+1]-1));
        }
        if (nums[nums.length-1] < upper) ranges.add(range(nums[nums.length-1]+1, upper));
        return ranges;
    }
}