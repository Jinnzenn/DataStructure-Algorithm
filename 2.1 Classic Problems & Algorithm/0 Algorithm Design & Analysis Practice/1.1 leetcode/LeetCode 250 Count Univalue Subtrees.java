//LeetCode 250
class Solution {
    public int countUnivalSubtrees(TreeNode root) {
            int [] res = {0};
            dfs(root, res);
            return res[0];
    }
        
    private boolean dfs(TreeNode root, int [] res){
        if(root == null){
            return true;
        }
        
        boolean left = dfs(root.left, res);
        boolean right = dfs(root.right, res);
        if(left && right){
            if(root.left!=null && root.left.val!=root.val){
                return false;
            }
            
            if(root.right!=null && root.right.val!=root.val){
                return false;
            }
            
            res[0]++;
            return true;
        }
        
        return false;
    }
}