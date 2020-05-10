import java.util.*;
public class FlipGameII{
    public boolean flipGame(String s){
        int len = s.length();
        StringBuilder str = new StringBuilder(s);
        for(int i = 0; i < len - 1;i++){
            if(s.charAt(i) == '+' && s.charAt(i+1) == '+'){
                str.setCharAt(i, '-');
                str.setCharAt(i+1, '-');
                if(!flipGame(str.toString())){
                    return true;
                }
            }
        }
        return false;
    }
}