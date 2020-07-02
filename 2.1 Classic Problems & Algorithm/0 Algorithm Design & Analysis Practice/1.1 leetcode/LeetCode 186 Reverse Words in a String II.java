class Solution {
    public void reverseWords(String s){
        if(s == null) return;
        int len = s.length();
        reverse(s, 0, len);
        int i=0, j=i;
        while(i<len && j<len){
            while(i < len && s.charAt(i)==' ') i++;
            j=i;
            while(j < len && s.charAt(j)!=' ') j++;
            reverse(s, i, j);
        }
    }
    private void reverse(String s, int i, int j){
        j--;
        while(i<j){
            char temp = s.charAt(i);
            s.setCharAt(i) = s.charAt(j);
            s.setCharAt(j) = temp;
            i++;
            j--;
        }
    }
}