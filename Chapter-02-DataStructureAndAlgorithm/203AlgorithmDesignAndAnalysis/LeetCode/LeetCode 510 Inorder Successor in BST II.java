//LeetCode 510
/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node parent;
};
*/
class Solution {
    public Node inorderSuccessor(Node x) {
        if(x == null){
            return x;
        }
        //右子树中的最左子节点
        if(x.right != null){
            Node suc = x.right;
            while(suc.left != null){
                suc = suc.left;
            }
            
            return suc;
        }

        //在父节点中回溯
        while(x.parent != null && x.parent.right == x){
            x = x.parent;
        }
        
        return x.parent;
    }
}