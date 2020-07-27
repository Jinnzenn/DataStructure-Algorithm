package Chapter201ClassicProblemsAndAlgorithm.Section104Sorting;

import java.util.Random;
public class Practice{
	public void sort(int[] nums){
		if(nums == null || nums.length == 0) return;
		for(int i = nums.length-1; i >= 0; i--){
			buildHeap(nums, i);
			swap(nums, 0, i);
		}
	}
	private void buildHeap(int[] nums, int end){
		int len = end+1;
		for(int i = len/2 - 1; i >= 0; i--){
			int left = 2 * i + 1, right = left + 1, p = left;
			if(right < len && nums[right]>nums[left]) p = right;
			if(nums[p] > nums[i]) swap(nums, i, right);
		}
	}
	private void swap(int[] nums, int i, int j){
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}
	
	public static void main(String[] argu){
		int[] nums = new int[100];
		Random rand = new Random();
		int index = 0;
		while(index < nums.length) nums[index++] = rand.nextInt(100);
		for(Integer n : nums) System.out.println(n);
		Practice sorter = new Practice();
		sorter.sort(nums);
		for(Integer n : nums) System.out.println(n);
	}
}