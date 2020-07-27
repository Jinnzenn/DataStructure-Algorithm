package Chapter201ClassicProblemsAndAlgorithm.Section104Sorting;

import java.util.Random;

public class QuickSort{
	public void sort(int[] nums){
		if(nums == null || nums.length == 0) return;
		quickSort(nums, 0, nums.length-1);
	}
	private void quickSort(int[] nums, int low, int high){
		if(low >= high) return;
		int p = partition(nums, low, high);
		quickSort(nums, low, p-1);
		quickSort(nums, p+1, high);
	}
	private int partition(int[] nums, int low, int high){
		//???????
		Random rand = new Random();
		int r = rand.nextInt(high-low+1);
		swap(nums, low, low+r);
		
		int i = low, j = high+1;
		int value = nums[low];
		while(i < j){
			while(++i <= high && nums[i] < value);
			while(--j >= low && nums[j] > value);
			if(i >= j) break;
			swap(nums, i, j);
		}
		swap(nums, low, j);
		return j;
	}
	private void swap(int[] nums, int i, int j){
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}
	
	public static void main(String[] argu){
		int[] nums = new int[100];
		int index = 0;
		Random rand = new Random();
		while(index < nums.length){
			nums[index++] = rand.nextInt(1000);
		}
		
		QuickSort sorter = new QuickSort();
		sorter.sort(nums);
		for(int num : nums){
			System.out.println(num);
		}
	}

}