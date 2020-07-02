import java.util.*;
public class Solution {
    private void find(List<Integer> factors, int target, List<List<Integer>> results) {
        // System.out.printf("factors=%s\n", factors);
        if (target == 1) {
            if (!factors.isEmpty()) {
                List<Integer> result = new ArrayList<>(factors.size());
                result.addAll(factors);
                results.add(result);
            }
            return;
        }
        int min = factors.isEmpty()? 2 : factors.get(factors.size()-1);
        int max = factors.isEmpty()? target/2 : target;//
        //for(f = 2;f*f<target;
        for(int f = min; f <= max; f ++) {
            if (target % f != 0) continue;
            factors.add(f);
            find(factors, target/f, results);
            factors.remove(factors.size()-1);
        }
    }
    public List<List<Integer>> getFactors(int n) {
        List<List<Integer>> results = new ArrayList<>();
        find(new ArrayList<>(), n, results);
        return results;
    }
}