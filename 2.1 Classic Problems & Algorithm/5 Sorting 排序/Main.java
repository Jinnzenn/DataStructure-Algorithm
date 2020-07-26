import java.util.Arrays;
import java.util.Random;

public class Main{
    public static void main(String[] args){
        Main solution = new Main();
        System.out.println("====stable====");
        int[] numsA = new int[] {10, 9, 8, 7, 6, 1, 2, 3, 4, 5};
        solution.mergeSort(numsA, 0, numsA.length-1);
        System.out.println("====unstable====");
        int[] numsB = new int[] {10, 9, 8, 7, 6, 1, 2, 3, 4, 5};
        solution.quickSort(numsB, 0, numsB.length-1);
        System.out.println("====unstable====");
        int[] numsC = new int[] {10, 9, 8, 7, 6, 1, 2, 3, 4, 5};
        solution.heapSort(numsC, 0, numsC.length-1);

    }
    private void mergeSort(int[] nums, int low, int high){
        if(low >= high) return;
        int mid = low + (high-low)/2;
        mergeSort(nums, low, mid);
        mergeSort(nums, mid+1, high);
        merge(nums, low, mid, high);
        System.out.println(Arrays.toString(nums));
    }
    private void merge(int[] nums, int low, int mid, int high){
        int[] temp = new int[high - low + 1];
        int i = low, j = mid + 1, k = 0;
        while(i <= mid && j <= high) temp[k++] = nums[i] <= nums[j] ? nums[i++] : nums[j++];
        while(i <= mid) temp[k++] = nums[i++];
        while(j <= high) temp[k++] = nums[j++];
        System.arraycopy(temp, 0, nums, low, high - low + 1);
    }
    private void quickSort(int[] nums, int low, int high){
        if(low >= high) return;
        int p = partition(nums, low, high);
        System.out.println(Arrays.toString(nums));
        quickSort(nums, low, p-1);
        quickSort(nums, p+1, high);
    }
    private int partition(int[] nums, int low, int high){
        //Random rand = new Random((int)System.currentTimeMillis());
        //int r = rand.nextInt(high-low+1);
        //swap(nums, low, low + r);
        int val = nums[low], i = low, j = high + 1;
        while(i < j){
            while(++i <= high && nums[i] < val);
            while(--j >= low && nums[j] > val);
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
    private void heapSort(int[] nums, int low, int high){
        for(int i = high; i >= low; i--){
            buildHeap(nums, i);
            swap(nums, 0, i);
            System.out.println(Arrays.toString(nums));
        }
    }
    private void buildHeap(int[] nums, int end){
        int len = end + 1;
        for(int i = len / 2 - 1; i >= 0; i--){
            int left = 2 * i + 1, right = left + 1, p = left;
            if(right < len && nums[right] > nums[left]) p = right;
            if(nums[p] > nums[i]) swap(nums, i, p);
        }
    }
}
