//LeetCode 333和 LeetCode 98有关
//带pre节点的解法
class Solution{
    private TreeNode pre = null;
    private int maxNodes = 0;
    public int largestBSTSubtree(TreeNode root){
        DFS(root);
        return maxNodes;
    }
    private int DFS(TreeNode root){
        if(root == null) return 0;
        if(root.left==null && root.right==null) return 1;
        int leftNodes = DFS(root.left);
        if(leftNodes == -1) return -1;
        if(pre!=null && pre.val>=root.val) return -1;
        pre = root;
        int rightNodes = DFS(root.right);
        if(right == -1) return -1;
        int nodes = leftNodes+rightNodes+1;
        maxNodes = Math.max(nodes, maxNodes);
        return nodes;
    }
}

//增加参数的解法
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
    public int largestBSTSubtree(TreeNode root) {
        int [] res = {0};
        helper(root, res);
        return res[0];
    }
    
    private Node helper(TreeNode root, int [] res){
        Node cur = new Node();
        if(root == null){
            cur.isBST = true;
            return cur;
        }
        Node left = helper(root.left, res);
        Node right = helper(root.right, res);
        if(left.isBST && root.val > left.max && right.isBST && root.val < right.min){
            cur.isBST = true;
            cur.min = Math.min(root.val, left.min);
            cur.max = Math.max(root.val, right.max);
            cur.size = left.size + right.size + 1;
            if(cur.size > res[0]){
                res[0] = cur.size;
            }
        }
        return cur;
    }
}
//也可以写成内部类
class Node{
    boolean isBST;
    int min;
    int max;
    int size;
    public Node(){
        isBST = false;
        min = Integer.MAX_VALUE;
        max = Integer.MIN_VALUE;
        size = 0;
    }
}