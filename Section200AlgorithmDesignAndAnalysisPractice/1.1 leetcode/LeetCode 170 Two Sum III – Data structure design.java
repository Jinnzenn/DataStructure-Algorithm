/**
 * Design and implement a TwoSum class. It should support the following operations: add
and find.
add(input) – Add the number input to an internal data structure.
find(value) – Find if there exists any pair of numbers which sum is equal to the value.
For example,
add(1); add(3); add(5); find(4) -> true; find(7) -> false
 */
import java.util.HashMap;
import java.util.Map;
 
public class TwoSum {
     
    HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
     
    public void add(int input) {
        if (map.containsKey(input)) {
            map.put(input, map.get(input) + 1);
        } else
            map.put(input, 1);
        //map.put(input, map.getOrDefault(input, 0)+1);
    }
 
    public boolean find(int sum) {
        //调出键值对进行操作
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (map.containsKey(sum - entry.getKey())) {
                if (entry.getKey() == sum - entry.getKey() && entry.getValue() == 1)
                    return false;
                return true;
            }
        }
        return false;
    }
}
//其实用HashSet就可以了？？不行，一个数的互补数可能是它自己。所以要注意主线次数。