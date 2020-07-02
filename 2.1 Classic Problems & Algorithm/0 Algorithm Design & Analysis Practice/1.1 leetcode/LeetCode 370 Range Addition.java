//LeetCode 370. Range Addition
public class solution{
    public int[] getModifiedArray(int length, int[][] updates){
        int[] res = new int[length];
        for(int[] triplet : updates){
            int start = triplet[0];
            int end = triplet[1];
            int add = triplet[2];
            res[start] += add;
            if(end < length-1) res[end+1] -= add;
        }

        //累加
        for(int i = 1; i < length; i++){
            res[i] += res[i-1];
        }
        return res;
    }
}

public static class main{
    
}