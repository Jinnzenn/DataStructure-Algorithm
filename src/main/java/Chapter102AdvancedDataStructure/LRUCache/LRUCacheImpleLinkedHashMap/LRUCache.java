package Chapter102AdvancedDataStructure.LRUCache.LRUCacheImpleLinkedHashMap;

import java.util.LinkedHashMap;
import java.util.Random;

public class LRUCache {
    private int capacity;
    LinkedHashMap<Integer, Integer> cache;
    
    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.cache = new LinkedHashMap<>();
    }
    
    public void put(int key, int val) {
        if (cache.containsKey(key)) {
            //更新
            cache.put(key, val);
            makeRecently(key);
            return;
        } else {
            //新增
            if (cache.size() >= this.capacity) {
                Integer olderstKey = cache.keySet().iterator().next();//删除头部元素
                cache.remove(olderstKey);
            }
            cache.put(key, val);
        }
        
    }
    
    public int get(int key) {
        if (cache.containsKey(key)) {
            makeRecently(key);
            return cache.get(key);
        } else {
            return -1;
        }
    }
    
    private void makeRecently(int key) {
        int val = cache.remove(key);
        cache.put(key, val);
    }
    
    public static void main(String[] args) {
        LRUCache cache = new LRUCache(10);
        int NUM = 10;
        Random rand = new Random();
        for (int i = 0; i < 100; i++) {
            int key = (i * 19) % 13;
            cache.put(key, rand.nextInt(NUM));
            System.out.println(key + " " + cache.get(key));
        }
        System.out.println(cache.cache.entrySet().toString());
    }
}
