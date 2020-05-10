import java.util.Queue;
public class WallsAndGates{
    public voic wallsAndGates(int[][] rooms){
        //coner case
        if(rooms==null || rooms.length == 0|| rooms[0].length == 0) return;
        //initializing
        int m = rooms.length;
        int n = rooms[0].length;
        Queue<int[]> queue = new LinkedList<>();
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(rooms[i][j] == 0) queue.add(new int[] {i, j});
            }
        }

        //就深度优先遍历和广度优先遍历来说，两者复杂度基本没有区别
        int level = 1;
        int[][] directions = new int[][] {{0,1},{0,-1},{1,0},{-1,0}};
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0; i < size; i++){
                int[] cur = queue.poll();
                for(int[] dir : directions){
                    int x = cur[0]+dir[0];
                    int y = cur[1]+dir[1];
                    if(x < 0 || x == m || y < 0 || y > m || rooms[x][y] != Integer.MAX_VALUE){
                        continue;
                    }
                    queue.add(new int[] {x, y});
                    rooms[x][y] = level;
                }
            }
            level++;
        }
    }
}