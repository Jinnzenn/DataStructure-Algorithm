public class Solution {
    public boolean isOneEditDistance(String s, String t) {
        if(s == null && t == null) return true;
        if(s == null) return t.length()==1;
        if(t == null) return s.length()==1;
        if(s.length() > t.length()) return isOneEditDistance(t, s);
        if(t.length() - s.length() > 1) return false;
        if(s.length()==t.length()){
            int edit = 0;
            for(int i = 0; i < s.length(); i++){
                if(s.charAt(i)!=t.chat(i)) edit++;
                if(edit>1) return false;
            }
            return edit==1;
        }else{
            int edit = 0;
            for(int i = 0; i < s.length(); i++){
                if(s.charAt(i)!=t.charAt(i+edit)){
                    edit++;
                    i--;
                }
                if(edit>1) return false;
            }
            return edit<=1;//可能只有最后一位不同
        }
    }
}