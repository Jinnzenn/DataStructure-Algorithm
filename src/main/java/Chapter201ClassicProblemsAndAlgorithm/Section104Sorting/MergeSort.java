package Chapter201ClassicProblemsAndAlgorithm.Section104Sorting;

import java.util.Random;
public class MergeSort{
	public void sort(int[] nums){
		if(nums == null || nums.length == 0) return;
		mergeSort(nums, 0, nums.length-1);
	}
	private void mergeSort(int[] nums, int low, int high){
		if(low >= high) return;
		int mid = low + ((high-low)>>>1);
		mergeSort(nums, low, mid);
		mergeSort(nums, mid+1, high);
		merge(nums, low, mid, high);
	}
	private void merge(int[] nums, int low, int mid, int high){
		int[] tempArr = new int[high-low+1];
		int i = low, j = mid+1, k = 0;
		while(i <= mid && j <= high){ tempArr[k++] = nums[i] <= nums[j] ? nums[i++] : nums[j++];}
		while(i <= mid){ tempArr[k++] = nums[i++];}
		while(j <= high){ tempArr[k++] = nums[j++];}
		System.arraycopy(tempArr, 0, nums, low, high-low+1);
	}
	
	public static void main(String[] argu){
		int[] nums = new int[1000];
		int index = 0;
		Random rand = new Random();
		while(index < nums.length){
			nums[index++] = rand.nextInt((int)System.currentTimeMillis());
		}
		MergeSort sorter = new MergeSort();
		sorter.sort(nums);
		for(int num : nums){
			System.out.println(num);
		}
	}
}
