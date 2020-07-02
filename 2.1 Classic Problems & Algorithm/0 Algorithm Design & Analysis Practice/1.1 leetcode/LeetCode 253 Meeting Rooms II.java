//LeetCode 253 Meeting Rooms II
//核心思路，同一时间点最多有几场会议在进行？等同于需要会议室的数量
import java.util.Comparator;
import java.util.Arrays;
import java.util.PriorityQueue;
public class Solution {
    private class Interval{
        int start;
        int end;
    }
    public int minMeetingRooms(Interval[] intervals) {
        Arrays.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval i1, Interval i2) {
                return Integer.compare(i1.start, i2.start);
            }
        });
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();//小顶堆
        int rooms = 0;
        for(int i=0; i<intervals.length; i++) {
            minHeap.offer(intervals[i].end);
            if (intervals[i].start < minHeap.peek()) {
                rooms ++;
            } else {
                minHeap.poll();
            }
        }
        return rooms;
    }
}

public class Solution {
    public int minMeetingRooms(Interval[] intervals) {
        Arrays.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval i1, Interval i2) {
                return Integer.compare(i1.start, i2.start);
            }
        });
        int rooms = 0;
        int active = 0;
        PriorityQueue<Integer> heap = new PriorityQueue<>();//正在进行的会议
        for(int i=0; i<intervals.length; i++) {
            active ++;//新开会议室
            //最早结束的会议和当前会议无交集
            while (!heap.isEmpty() && heap.peek() <= intervals[i].start) {
                active--;//减少会议室
                heap.poll();
            }
            heap.offer(intervals[i].end);
            rooms = Math.max(rooms, active);
        }
        return rooms;
    }
}