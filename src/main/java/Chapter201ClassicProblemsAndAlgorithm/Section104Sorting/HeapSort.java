package Chapter201ClassicProblemsAndAlgorithm.Section104Sorting;

import java.util.Random;
public class HeapSort{
	public void sort(int[] nums){
		for(int i = nums.length-1; i >= 0; i--){
			buildHeap(nums, i);//建堆，建立最大堆，根节点为值最大节点
			swap(nums, 0, i);//将最大节点放置到数组末尾。i逐渐减小，end向数组左侧收缩
		}
	}
	
	private void buildHeap(int[] nums, int end){
		int len = end + 1;
		//上浮
		for(int i = len/2-1; i >= 0; i--){
			//堆中i节点对应的左右子节点l和r
			int left = 2*i+1, right = left+1,p = left;
			//选出子节点中较大的
			if(right < len && nums[left] < nums[right]){ p = right; }
			//选出父节点和子节点中较大的
			if(nums[i] < nums[p]){ swap(nums, i, p);}
		}
	}
	private void swap(int[] nums, int i, int j){
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}
	
	public static void main(String[] args){
		int N = 10;
		int[] nums = new int[N];
		int index = 0;
		Random rand = new Random();
		while(index < nums.length){
			nums[index++] = rand.nextInt(N);
		}
		HeapSort sorter = new HeapSort();
		sorter.sort(nums);
		for(int num : nums){
			System.out.print(num + " ");
		}
	}
}