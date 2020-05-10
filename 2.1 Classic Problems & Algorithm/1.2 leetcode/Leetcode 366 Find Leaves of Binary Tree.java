//LeetCode 366
//核心思路 叶结点的树高为0，根据树高依序删除
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public List<List<Integer>> findLeaves(TreeNode root) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        height(root, res);
        return res;
    }
    
    private int height(TreeNode root, List<List<Integer>> res){
        if(root == null){
            return -1;
        }
        int h = 1+Math.max(height(root.left, res), height(root.right, res));
        if(res.size() < h+1){
            res.add(new ArrayList<Integer>());
        }
        res.get(h).add(root.val);
        return h;
    }
}