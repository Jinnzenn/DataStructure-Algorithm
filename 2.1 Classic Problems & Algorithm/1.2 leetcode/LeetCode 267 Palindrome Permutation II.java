public class Solution{
    public List<String> generatePalindromes(String s){
        List<String> res = new ArrayList<>();
        if(s==null || s.length() == 0) return res;

        char[] letters = s.toCharArray();
        int[] counts = new int[256];
        for(char c : letters){
            counts[c]++;
        }
        int len = s.length();
        char[] buffer = new char[len];
        int countAppearOdd = 0;
        //长度为奇数，只能出现一个
        for(int i = 0; i < 256;i++){
            if(counts[i]%2==1){
                countAppearOdd++;
                buffer[len/2] = (char)i;
                counts[i]--;
            }
        }
        if(countAppearOdd>1) return res;
        dfs(buffer, res, counts, 0, len-1);
        return res;
    }

    private void dfs(char[] buffer, List<String> res, int[] counts, int left, int right){
        if(left>=right){
            res.add(String.valueOf(buffer));
            return;
        }
        for(int i = 0; i < counts.length; i++){
            if(counts[i] == 0) continue;
            buffer[left] = (char) i;
            buffer[right] = (char) i;
            counts[i] -= 2;
            dfs(buffer, res, counts, left+1, right-1);
            counts[i] += 2;
        }
    }
}
