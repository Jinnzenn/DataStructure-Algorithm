import java.util.Deque;
import java.util.HashSet;

//LeetCode 353
public class SnakeGame{
    class Position{
        int x, y;
        public Position(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    private int[][] food;
    private int width, height;
    private HashSet<Position> body = new HashSet<>();
    private Deque<Position> snake = new LinkedList<>();
    private int score;

    /** Initialize your data structure here.
        @param width - screen width
        @param height - screen height 
        @param food - A list of food positions
        E.g food = [[1,1], [1,0]] means the first food is positioned at [1,1], the second is at [1,0]. */

    public SnakeGame(int width, int height, int[][] food){
        this.food = food;
        this.width = width;
        this.height = height;
        Position head = new Position(0, 0);
        snake.add(head);
        body.add(head);
    }


    /** Moves the snake.
    @param direction - 'U' = Up, 'L' = Left, 'R' = Right, 'D' = Down 
    @return The game's score after the move. Return -1 if game over. 
    Game over when snake crosses the screen boundary or bites its body. */
    public int move(string direction){
        Position head = snake.getFirst();
        Position next = new Position(head.y, head.x);
        switch(direction){
            case "U" : next.y--; break;
            case "D" : next.y++; break;
            case "L" : next.x--; break;
            case "R" : next.x++; break;
            default: return -1;
        }
        //越界或吃到自己，Game Over
        if(next.y < 0 || next.y >= height || next.x < 0 || next.x >= width) return -1;
        if(body.contains(next)) return -1;
        //判断有无食物
        if(food[next.x][next.y] == 1){
            score++;
            food[next.x][next.y] == 0;
            snake.addFirst(next);
            body.add(next);
            return score;
        }else{
            snake.addFirst(next);
            body.add(next);
            body.remove(snake.removeLast());
            return score;
        }
    }
}
