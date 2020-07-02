//LeetCode 346
//C++写法
class MovingAverage {
    /** Initialize your data structure here. */
    MovingAverage(int size): len(size), sum(0) {
        queue = new LinkedList<>();
    }
    
    public double next(int val) {
        sum += val;
        queue.push(val);
        if(que.size() > len)
        {
            sum -= queue.front();
            queue.pop();
        }
        return sum/que.size();
    }
    private int len;
    private double sum;
    private Queue<Integer> queue;
};
