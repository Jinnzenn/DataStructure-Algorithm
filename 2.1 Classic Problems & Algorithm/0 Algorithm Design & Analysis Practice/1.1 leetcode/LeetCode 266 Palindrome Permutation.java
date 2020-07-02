public class Solution{
    public boolean isPalindromes(String s){
        if(s==null || s.length() == 0) return true;

        char[] letters = s.toCharArray();
        int[] counts = new int[256];
        for(char c : letters){
            counts[c]++;
        }
        int countAppearOdd = 0;
        //长度为奇数，只能出现一个
        for(int i = 0; i < 256;i++){
            if(counts[i]%2==1){
                countAppearOdd++;
                if(countAppearOdd>1) return false;
            }
        }
        
        return true;
    }
}