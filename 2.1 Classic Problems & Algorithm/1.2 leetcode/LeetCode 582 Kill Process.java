import java.util.ArrayList;

//leetcode 582 Kill Process
class Solution{
    public List<Integer> killProcess(int[] pid, int[] ppid, int kill){
        HashMap<Integer, HashSet<Integer>> parent2Son = new HashMap<>();
        for(int i = 0; i < ppid.length; i++){
            if(!map.containsKey(ppid[i])) map.put(ppid[i], new HashSet<Integer>);
            map.get(ppid[i]).add(pid[i]);
        }

        ArrayList<Integer> res;
        killAllProcess(hash, kill, res);
        return res;
    }

    private void killAllProcess(HashMap<>() parent2Son, int kill, ArrayList<Integer> res){
        res.add(kill);
        for(Integer son : parent2Son.get(kill)){
            killAllProcess(parent2Son, son, res);
        }
    }
}

class Solution{
    public List<Integer> killProcess(int[] pid, int[] ppid, int kill){
        HashMap<Integer, HashSet<Integer>> parent2Son = new HashMap<>();
        for(int i = 0; i < ppid.length; i++){
            if(!map.containsKey(ppid[i])) map.put(ppid[i], new HashSet<Integer>);
            map.get(ppid[i]).add(pid[i]);
        }

        ArrayList<Integer> res = new ArrayList<>();
        killAllProcess(hash, kill, res);
        return res;
    }

    private void killAllProcess(HashMap<>() parent2Son, int kill, ArrayList<Integer> res){
        res.add(kill);
        for(Integer son : parent2Son.get(kill)){
            killAllProcess(parent2Son, son, res);
        }
    }
}

class Solution{
    public List<Integer> killProcess(int[] pid, int[] ppid, int kill){
        HashMap<Integer, HashSet<Integer>> parent2Son = new HashMap<>();
        for(int i = 0; i < ppid.length; i++){
            if(!map.containsKey(ppid[i])) map.put(ppid[i], new HashSet<Integer>);
            map.get(ppid[i]).add(pid[i]);
        }

        ArrayList<Integer> res = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        queue.push(kill);
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0; i < size; i++){
                Integer cur = queue.pop();
                res.add(cur);
                for(Integer son : parent2Son.get(cur)){
                    queue.push(son);
                }
            }
        }
        return res;
    }
}