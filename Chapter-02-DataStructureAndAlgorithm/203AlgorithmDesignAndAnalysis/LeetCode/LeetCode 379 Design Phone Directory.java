//LeetCode 379
//哈希表 映射<phoneNumber, isExist> + 队列/栈/集合
public class PhoneDirectory {
    int max;
    HashSet<Integer> set;
    LinkedList<Integer> queue;
  
    /** Initialize your data structure here
        @param maxNumbers - The maximum numbers that can be stored in the phone directory. */
    public PhoneDirectory(int maxNumbers) {
        set = new HashSet<Integer>();
        queue = new LinkedList<Integer>();
        for(int i=0; i<maxNumbers; i++){
            queue.offer(i);
        }
        max=maxNumbers-1;
    }
  
    /** Provide a number which is not assigned to anyone.
        @return - Return an available number. Return -1 if none is available. */
    public int get() {
        if(queue.isEmpty())
            return -1;
  
        int e = queue.poll();
        set.add(e);
        return e;
    }
  
    /** Check if a number is available or not. */
    public boolean check(int number) {
        return !set.contains(number) && number<=max;
    }
  
    /** Recycle or release a number. */
    public void release(int number) {
        if(set.contains(number)){
            set.remove(number);
            queue.offer(number);
        }
    }
}

//思路，两个HashSet，一个存放已被使用的电话号码，一个存放可供选择的电话号码

//题目特点，号码值[1，n]思路,可以用直接映射表，映射<phoneNumber, isExist>，两个数组，一个存放所有电话号码，以索引idx为界，数组中索引小于idx部分存放可选择号码，大于idx部分存放不可选择号码。一个数组标记号码可用状态。
class PhoneDirectory {
    public:
        PhoneDirectory(int maxNumbers) {
            nums.resize(maxNumbers);
            used.resize(maxNumbers);
            idx = maxNumbers - 1;
            iota(nums.begin(), nums.end(), 0);
        }
        int get() {
            if (idx < 0) return -1;
            int num = nums[idx--];
            used[num] = 1;
            return num;
        }
        bool check(int number) {
            return used[number] == 0;
        }
        void release(int number) {
            if (used[number] == 0) return;
            nums[++idx] = number;
            used[number] = 0;
        }
    
    private:
        int idx;
        vector<int> nums, used;
    };