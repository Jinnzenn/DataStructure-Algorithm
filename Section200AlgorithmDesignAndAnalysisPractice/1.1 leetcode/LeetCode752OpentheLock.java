import java.util.*;
import java.lang.Exception;
class LeetCode752OpentheLock {
    public int openLock(String[] deadends, String target) {
        HashSet<String> visited = new HashSet<>();
        for(String deadend : deadends){
            visited.add(deadend);
        }
        //int len = target.length();
        int step = 0;
        Queue<String> queue = new LinkedList<>();
        queue.offer("0000");
        //visited.add("0000");
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0; i < size; i++){
                String choice = queue.poll();
                System.out.println(choice);
                if(visited.contains(choice)) continue;
                if(choice.equals(target)) return step;
                for(int j = 0; j < 4; j++){
                    String up = upTurn(choice, j);
                    if(!visited.contains(up)){
                        queue.offer(up);
                        //visited.add(up);
                    }
                    String down = downTurn(choice, j);
                    if(!visited.contains(down)){
                        queue.offer(down);
                        //visited.add(down);
                    }
                }
            }
            step++;
        }
        return -1;
    }


    private String upTurn(String s, int pos){
        char[] chars = s.toCharArray();
        if(chars[pos] == '9'){
            chars[pos] = '0';
        }else{
            chars[pos] += 1;
        }
        return String.valueOf(chars);
    }

    private String downTurn(String s, int pos){
        char[] chars = s.toCharArray();
        if(chars[pos] == '0'){
            chars[pos] = '9';
        }else{
            chars[pos] -= 1;
        }
        return String.valueOf(chars);
    }

    
    public static void main(String[] args){
        String[] deadends = {"8887","8889","8878","8898","8788","8988","7888","9888"};
		

        String target = "8888";
        int ret = new LeetCode752OpentheLock().openLock(deadends, target);
        System.out.println(ret);
        
        /*
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            String[] deadends = stringToStringArray(line);
            line = in.readLine();
            String target = stringToString(line);
            
            int ret = new LeetCode752OpentheLock().openLock(deadends, target);
            
            String out = String.valueOf(ret);
            
            System.out.print(out);
        }
        */
    }
}