import java.util.*;
public class FlipGame{
    public List<String> flipGame(String s){
        List<String> res = new ArrayList<>();
        int len = s.length();
        StringBuilder str = new StringBuilder(s);
        for(int i = 0; i < len - 1;i++){
            if(s.charAt(i) == '+' && s.charAt(i+1) == '+'){
                str.setCharAt(i, '-');
                str.setCharAt(i+1, '-');
                res.add(str.toString());
                str.setCharAt(i, '+');
                str.setCharAt(i+1, '+');
            }
        }
        return res;
    }
}