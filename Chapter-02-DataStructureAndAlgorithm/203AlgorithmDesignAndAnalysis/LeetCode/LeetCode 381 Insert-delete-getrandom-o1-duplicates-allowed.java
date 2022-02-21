class RandomizedCollection {
    HashMap<Integer, Set<Integer>> map;
    ArrayList<Integer> list;
    Random rand;
    /** Initialize your data structure here. */
    public RandomizedCollection() {
        map = new HashMap<>();
        list = new ArrayList<>();
        rand = new Random();
    }
    
    /** Inserts a value to the collection. Returns true if the collection did not already contain the specified element. */
    public boolean insert(int val) {
        list.add(val);
        int index = list.size()-1;
        if(!map.containsKey(val)) map.put(val, new HashSet<Integer>());
        map.get(val).add(index);
        return map.get(val).size() == 1;
    }
    
    /** Removes a value from the collection. Returns true if the collection contained the specified element. */
    public boolean remove(int val) {
        if(!map.containsKey(val)) return false;
        if(map.get(val).isEmpty()) return false;
        //if(map.get(val).size() < 1) return false;
        Iterator<Integer> iter = map.get(val).iterator(); 
        Integer index = iter.next();//关键代码 不用hasNext()，因为size!=0
        map.get(val).remove(new Integer(index));//这里自动拆箱装箱 Integer--int，避免Integer缓存
        //if(map.get(val).size() == 0) map.remove(val);
        //iter.remove();

        Integer tailIndex = list.size()-1;
        Integer tailValue = list.get(tailIndex);
        list.set(index, tailValue);
        list.remove(tailIndex);
        //
        //System.out.println("delete element: " + val +  " in index: " + index + " remain size:" + map.get(val).size());
        map.get(tailValue).remove(new Integer(tailIndex));
        map.get(tailValue).add(index);
        return true;
    }
    
    /** Get a random element from the collection. */
    public int getRandom() {
        int bound = list.size();
        if(bound == 0) return -1;
        int randomIndex = rand.nextInt(bound);
        return list.get(randomIndex);
    }
}

/**
 * Your RandomizedCollection object will be instantiated and called as such:
 * RandomizedCollection obj = new RandomizedCollection();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */