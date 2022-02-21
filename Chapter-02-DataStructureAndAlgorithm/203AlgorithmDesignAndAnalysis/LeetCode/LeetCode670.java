import java.util.*;
import java.io.*;

class LeetCode670 {
    public int maximumSwap(int num) {
        char[] digits = String.valueOf(num).toCharArray();
        int max = Integer.MIN_VALUE;
        int max_index = 0;
        int[] arr = new int[digits.length];//���ĳ��λ��i���������ֵ�����

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
                //���ĳλ��i֮�������������Լ����������и�������ֿ��Խ�����ǰ��
                //��ͬʱ����������͵�ǰ���ֲ���ͬһ�����֣�������������
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