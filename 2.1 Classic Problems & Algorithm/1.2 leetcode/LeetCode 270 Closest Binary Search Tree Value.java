//LeetCode 270和 LeetCode 235很像
//dfs，迭代写法比较好，不用遍历所有节点
public class Solution {
    public int closestValue(TreeNode root, double target) {
        if(root == null){
            return -1;
        }
        
        int cloest = root.val;
        double minDiff = Double.MAX_VALUE;
        
        while(root != null){
            if(Math.abs(root.val - target) < minDiff){
                minDiff = Math.abs(root.val - target);
                cloest = root.val;
            }
            if(target > root.val){
                root = root.right;
            }else if(target < root.val){
                root = root.left;
            }else{
                return root.val;//剪枝功能
            }
        }
        return cloest;
    }
}

//递归写法
class Solution {
    private int minDiff = Double.MAX_VALUE;
    private int cloest = 0;
    public int closestValue(TreeNode root, double target) {
        if(root == null) return -1;
        cloest = root.val;
        DFS(root, target);
        return cloest;
    }
    private void DFS(TreeNode root, int target){
        if(root == null) return;
        int diff = Math.abs(root.val - target);
        if(diff < minDiff){
            cloest = root.val;
            minDiff = diff;
        }
        //自带剪枝，如果target
        if(target > root.val) DFS(root.right, target);//左子树中不可能有diff<minDiff
        if(target < root.val) DFS(root.left, target);
    }
}