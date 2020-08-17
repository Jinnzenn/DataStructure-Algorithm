package Chapter102AdvancedDataStructure.LFUCache.LFUCacheImpleList;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

class Solution {
    public int maxDistance(int[] position, int m) {
        int basketNum = position.length;
        if(m > basketNum) return 0;//篮子数量小于球的数量，势必有两个球放在同一篮子里，此时最小磁力==0
        if(m == 1) return Integer.MAX_VALUE;//1个球，磁力认为是无限
        //if(m == 2) return maxDistanceBetweenTwoPosition;
        //remove basketNum-m basket from the postions
        Set<Integer> set = new HashSet<>();
        for(int pos : position) set.add(pos);
        PriorityQueue<Basket> queue = new PriorityQueue<>((o1, o2)->(o1.distanceTotal - o2.distanceTotal));
        for(int pos : position){
            Basket basket = new Basket(pos);
            for(int p : position){
                if(p != pos) basket.add(p);
            }
            queue.offer(basket);
        }
        for(int i = 0; i < (basketNum - m); ++i){
            Integer temp = queue.poll().position;//find the basket to remove;
            PriorityQueue<Basket> q = new PriorityQueue<>((o1, o2)->(o1.distanceTotal - o2.distanceTotal));
            while(!queue.isEmpty()){
                Basket b = queue.poll();
                b.remove(temp);
                q.offer(b);
            }
            queue = q;
            set.remove(temp);
        }
        int minDis = Integer.MAX_VALUE;
        for(int pos : set){
            for(int p : set){
                if(pos != p) minDis = Math.min(minDis, Math.abs(pos - p));
            }
        }
        return minDis;
        
        
    }
    static class Basket{
        //Set<Integer> set;
        int distanceTotal;
        int position;
        public Basket(int pos){
            this.position = pos;
        }
        public void add(int pos){
            //set.add(pos);
            distanceTotal += Math.abs(pos-position);
        }
        public void remove(int pos){
            //set.remove(pos);
            distanceTotal -= Math.abs(pos-position);
        }
    }
    public static void main(String[] args){
        int[] position = new int[] {1, 2, 3, 4, 7};
        int m = 3;
        int ret = new Solution().maxDistance(position, m);
        System.out.println(ret);
    }
}
