import java.util.*;
import java.io.*;

class LeetCode670 {
    public int maximumSwap(int num) {
        char[] digits = String.valueOf(num).toCharArray();
        int max = Integer.MIN_VALUE;
        int max_index = 0;
        int[] arr = new int[digits.length];//存放某个位置i后方最大的数字的索引

        for(int i = digits.length-1; i >= 0; i--){
            if(digits[i] - '0' > max){
                max = digits[i]-'0';
                max_index = i;
            }
            arr[i] = max_index;
            //System.out.println("digits[i] :" + digits[i] + " max_index" + max_index);
        }

        for(int i = 0; i < digits.length; i++){
            //&& digits[arr[i]] != digits[i] 98368--98863
            if(arr[i] != i && digits[arr[i]] != digits[i]){
                //如果某位置i之后的最大数不是自己，即后面有更大的数字可以交换到前面
                //（同时，该最大数和当前数字不是同一个数字），交换两数字
                char temp = digits[i];
                digits[i] = digits[arr[i]];
                digits[arr[i]] = temp;
                break;
            }
        }
        return Integer.parseInt(new String(digits));
    }
	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String line;
		while((line = in.readLine())!=null){
			int num = Integer.parseInt(line);
			int ret = new LeetCode670().maximumSwap(num);
			String out = String.valueOf(ret);
			System.out.println(out);
			
		}
	}
}