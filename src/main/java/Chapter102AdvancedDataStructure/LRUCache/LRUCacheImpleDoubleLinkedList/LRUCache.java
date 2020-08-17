package Chapter102AdvancedDataStructure.LRUCache.LRUCacheImpleDoubleLinkedList;

import java.util.HashMap;
import java.util.Random;

public class LRUCache{
    // key -> Node(key, val)
    private HashMap<Integer, Node> map;
    // Node(k1, v1) <-> Node(k2, v2)...
    public DoubleList cache;
    // 最大容量
    private int capacity;
    public LRUCache(int capacity){
        this.capacity = capacity;
        map = new HashMap<>();
        cache = new DoubleList();
    }
    //接口设计目标，不直接调用map,cache的接口
    public int get(int key){
        if(map.containsKey(key)){
            makeRecently(key);
            return map.get(key).val;
        }else{
            return -1;
        }
    }
    public void put(int key, int val){
        if(map.containsKey(key)){
            deleteKey(key);
            addRecently(key, val);
        }else{
            if(capacity == cache.size()){
                removeOldest();
            }
            addRecently(key, val);
        }
    }
    private void deleteKey(int key){
        Node node = map.get(key);
        cache.remove(node);
        map.remove(key);
    }
    private void addRecently(int key, int val){
        Node node = new Node(key, val);
        map.put(key, node);
        cache.addLast(node);
    }
    private void makeRecently(int key){
        Node node = map.get(key);
        deleteKey(key);
        addRecently(key, node.val);
    }
    private void removeOldest(){
        Node node = cache.removeFirst();
        map.remove(node.key);
    }
    @Override
    public String toString() {
        StringBuilder ret = new StringBuilder();
        Node head = cache.head;
        Node tail = cache.tail;
        Node curr = head.next;
        while(curr != tail){
            ret.append(curr.key);
            ret.append(":");
            ret.append(curr.val);
            ret.append(" ");
            curr = curr.next;
        }
        return "LRUCacheImpleDoubleLinkedList{" +
                "cache=" + ret.toString() +
                '}';
    }
    
    class Node{
        int key, val;
        Node next, prev;
        public Node(int key, int val){
            this.key = key;
            this.val = val;
        }
    }
    class DoubleList{
        int size;
        Node head, tail;
        public DoubleList(){
            head = new Node(0, 0);
            tail = new Node(0, 0);
            head.next = tail;
            tail.prev = head;
        }
        public Node removeFirst(){
            if(head.next == tail) return null;
            Node node = head.next;
            remove(node);
            return node;
        }
        public void remove(Node node){
            node.next.prev = node.prev;
            node.prev.next = node.next;
            --size;
        }
        public void addLast(Node node){
            node.next = tail;
            node.prev = tail.prev;
            tail.prev = node;
            node.prev.next = node;
            ++size;
        }
        public int size(){
            return size;
        }
        
        
    }
    
    public static void main(String[] args){
        LRUCache cache = new LRUCache(10);
        int NUM = 10;
        Random rand = new Random();
        for(int i = 0; i < 100; i++){
            int key = (i*19)%13;
            cache.put(key, rand.nextInt(NUM));
            System.out.println(key + " " + cache.get(key));
        }
        System.out.println(cache.toString());
    }
}
