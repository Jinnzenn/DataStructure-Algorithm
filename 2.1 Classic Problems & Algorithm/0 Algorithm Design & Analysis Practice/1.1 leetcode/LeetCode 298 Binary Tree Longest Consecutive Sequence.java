//LeetCode 298
//先序遍历，递归写法, top-down
public class Solution {
    private int maxLen = 0;
     
    public int longestConsecutive(TreeNode root) {
        longestConsecutive(root, 0, 0);
        return maxLen;
    }
     
    private void longestConsecutive(TreeNode root, int lastVal, int curLen) {
        //以root为终点的最长序列
        if (root == null) return;
        if (root.val != lastVal + 1) curLen = 1;
        else curLen++;
        maxLen = Math.max(maxLen, curLen);
        longestConsecutive(root.left, root.val, curLen);
        longestConsecutive(root.right, root.val, curLen);
    }
}
//先序遍历，递归写法，bottom-up
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    int max = 0;
    public int longestConsecutive(TreeNode root) {
        dfs(root);
        return max;
    }
    
    private int dfs(TreeNode root){
        if(root == null){
            return 0;
        }
        
        int l = dfs(root.left)+1;//以root.left为起点的最长序列
        int r = dfs(root.right)+1;
        if(root.left != null && root.val != root.left.val-1){
            l = 1;
        }
        if(root.right != null && root.val != root.right.val-1){
            r = 1;
        }
        
        int curMax = Math.max(l, r);
        max = Math.max(max, curMax);
        return curMax;
    }
}