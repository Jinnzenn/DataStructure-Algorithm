import java.util.Random;
public class Practice{
	public  <T extends Comparable<? super T>> void sort(T[] nums){
		if(nums == null || nums.length == 0) return;
		quickSort(nums, 0, nums.length -1);
	}
	private <T extends Comparable<? super T>> void quickSort(T[] nums, int low, int high){
		if(low >= high) return;
		int p = partition(nums, low, high);
		quickSort(nums, low, p-1);
		quickSort(nums, p+1, high);
	}
	private <T extends Comparable<? super T>> int partition(T[] nums, int low, int high){
		T value = nums[low];
		System.out.println(value);
		int i = low, j = high+1;
		while(true){
			while(++i <= high && value.compareTo(nums[i]) > 0);
			while(--j >= low && value.compareTo(nums[j]) < 0);
			if(i>=j) break;
			swap(nums, i, j);
		}
		swap(nums, low, j);
		return j;
	}
	private <T extends Comparable< ? super T>> void swap(T[] nums, int i, int j){
		T temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}
	public static void main(String[] argu){
		Integer[] nums = new Integer[100];
		Random rand = new Random();
		int index = 0;
		while(index < nums.length) nums[index++] = rand.nextInt(100);
		for(Integer n : nums) System.out.println(n);
		Practice sorter = new Practice();
		sorter.sort(nums);
		for(Integer n : nums) System.out.println(n);
	}
}