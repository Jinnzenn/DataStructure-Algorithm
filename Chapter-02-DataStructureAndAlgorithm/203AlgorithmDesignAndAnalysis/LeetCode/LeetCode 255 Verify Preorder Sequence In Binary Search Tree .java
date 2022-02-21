//LeetCode 255
public class Solution {
    public boolean VerifySquenceOfBST(int[] sequence) {
        if(sequence.length == 0){
            return false;
        }
        return Verify(sequence, 0 , sequence.length-1);
    }
    private boolean Verify(int[] sequence, int begin, int end){
        if(begin>=end){
            return true;
        }
        int split = begin;
        while(sequence[split] < sequence[end]){
            split++;
        }
        for(int i = split; i < end; i++){
            if(sequence[i] < sequence[end]){
                return false;
            }
        }
        return Verify(sequence, begin, split - 1) && Verify(sequence, split, end - 1);
    }
}
/*
bool verifyPreorder(vector<int>& preorder) {
    return helper(preorder,0,preorder.size()-1,INT_MIN,INT_MAX);
}

bool helper(vector<int>& preorder,int start, int end,int lower,int higher){
    if(start>end) return true;
    int val=preorder[start];
    if(val<=lower||val>=higher) return false;
    int i=start+1;
    for(;i<=end;i++){
        if(preorder[i]>val) break;
    }
    return helper(preorder,start,i-1,lower,preorder[start])&&helper(preorder,i,end,preorder[start],higher);
}

//方法2：stack
bool verifyPreorder(vector<int>& preorder) {

    stack<int> ss;
    int lower_bound=INT_MIN;
    for(int i=0;i<preorder.size();i++){
        if(preorder[i]>=lower_bound) return false;
        if(ss.empty()||preorder[i]<ss.top()){//ss.empty()用于加保护，防止越界
            ss.push(preorder[i]);   
        }
        while(!ss.empty()&&preorder[i]>ss.top()){
            lower_bound=ss.top();
            ss.pop();   
        }
    }   
    return true;
}
*/