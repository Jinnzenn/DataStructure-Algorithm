//leetcode 285
//核心思路，顺序遍历树，找到p的后继节点
//中序遍历，有pre节点，递归写法
class Solution{
    private TreeNode pre = null;
    private TreeNode ans = null;
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p){
        //递归基，对root进行递归
        if(root == null) return root;
        inorderSuccessor(root.left, p);
        if(pre == p){
            ans = root;
            return;//剪枝
        }
        pre = root;
        inorderSuccessor(root.right, p);
        return ans;
    }
}

//中序遍历，有pre，迭代写法
class Solution{
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p){
        if(root == null) return null;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode pre = null;
        TreeNode cur = root;
        while(cur!=null || !stack.isEmpty()){
            while(cur!=null){
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            if(pre == p){
                return cur;
            }
            cur = cur.right;
        }
        return null;//说明p是最后一个节点
    }
}





//核心思路，要利用二叉搜索树的性质，根据节点大小来剪枝
//递归写法
class Solution {
    //关键要明确递归的语义，递归返回值可能是后继节点，也可能是null
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        //successor must be larger then the node itself, so:
        //if p is in root.left, root can be the successor, null cannot be
        //if p is in root.right, root can not be the successor, null can be
        if (root == null) return null;
        if (root.val <= p.val) {
            return inorderSuccessor(root.right, p);
        } else {
            TreeNode leftRes = inorderSuccessor(root.left, p);//可能找到的是null
            return leftRes == null ? root : leftRes;
        }
    }
}