//leetcode 272
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
//中序遍历，递归写法，用Queue保存k个数
class Solution {
    public List<Integer> closestKValues(TreeNode root, double target, int k) {
        LinkedList<Integer> res = new LinkedList<>();
        if(root == null || k <= 0){
            return res;
        }
        
        inorder(root, target, k, res);
        return res;
    }
    
    private void inorder(TreeNode root, double target, int k, LinkedList<Integer> que){
        if(root == null){
            return;
        }
        
        inorder(root.left, target, k, que);
        if(que.size() == k){
            if(Math.abs(que.peek() - target) > Math.abs(root.val - target)){
                //diff较大的数
                que.pollFirst();
            }else{
                return;//无需再往右深入
            }
        }
        
        que.add(root.val);
        inorder(root.right, target, k, que);
    }
}

//参考leetcode 270，每次返回一个最接近的树，在删除目标节点O(log(n) * k)
//关键，如何删除二叉搜索树的节点？|| 如何删除二叉树的节点？
//关键，如何找到二叉搜索树的后继节点？|| 如何找到二叉树的后继节点？
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
    public List<Integer> closestKValues(TreeNode root, double target, int k) {
        List<Integer> res = new ArrayList<Integer>();
        if(root == null){
            return res;
        }
        
        for(int i = 0; i<k ;i++){
            int closest = closestValue(root, target);
            res.add(closest);
            root = deleteNode(root, closest);
        }
        
        return res;
    }
    
    private int closestValue(TreeNode root, double target){
        if(root == null){
            return Integer.MAX_VALUE;
        }
        int closest = root.val;
        double minDiff = Double.MAX_VALUE;
        while(root != null){
            if(Math.abs(root.val - target) < minDiff){
                minDiff = Math.abs(root.val - target);
                closest = root.val;
            }
            
            if(target > root.val){
                root = root.right;
            }else if(target < root.val){
                root = root.left;
            }else{
                return root.val;
            }
        }
        return closest;
    }
    
    private TreeNode deleteNode(TreeNode root, int key){
        if(root == null){
            return root;
        }
        
        if(root.val > key){
            root.left = deleteNode(root.left, key);
        }else if(root.val < key){
            root.right = deleteNode(root.right, key);
        }else{
            //root.val == key
            if(root.left == null){
                return root.right;
            }else if(root.right == null){
                return root.left;
            }
            
            int suc = findSuc(root.right);
            root.val = suc;
            deleteNode(root.right, suc);
        }
        return root;
    }
    
    private int findSuc(TreeNode root){
        int suc = root.val;
        while(root.left != null){
            root = root.left;
            suc = root.val;
        }
        return suc;
    }
}