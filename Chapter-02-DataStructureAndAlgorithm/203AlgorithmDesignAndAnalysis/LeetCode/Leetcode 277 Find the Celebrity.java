//LeetCode 277
// Forward declaration of the knows API.
bool knows(int a, int b);
 
class Solution {
public:
    int findCelebrity(int n) {
        int k = 0;
        for(int i = 1; i < n; i++)
            k = knows(i, k)?k:i;//如果i不知道k,k肯定不是celebrity，相应的i有可能是celebrity
        for(int i = 0; i < n; i++)
            if(i != k && (knows(k, i)||!knows(i, k)))//验证得到的k是不是celebrity
                return -1;
        return k;
    }
};