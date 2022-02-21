/**
 * Given a binary tree where all the right nodes are either leaf nodes with a sibling (a left node that shares the same parent node) or empty, flip it upside down and turn it into a tree where the original right nodes turned into left leaf nodes. Return the new root.

For example:
Given a binary tree {1,2,3,4,5},

    1
   / \
  2   3
 / \
4   5

 

return the root of the binary tree [4,5,2,#,#,3,1].

   4
  / \
 5   2
    / \
   3   1  
 */
//LeetCode 156
/**

 * Definition for a binary tree node.

 * struct TreeNode {

 *     int val;

 *     TreeNode *left;

 *     TreeNode *right;

 *     TreeNode(int x) : val(x), left(NULL), right(NULL) {}

 * };

 */

class Solution {

public:

    public TreeNode upsideDownBinaryTree(TreeNode root) {

        if(root == null || root.left == null) return root;//此时右边肯定没有子树
        //左子树中找出newRoot，此时，root节点肯定还指着原来的子节点，按此进行改造
        TreeNode newRoot = upsideDownBinaryTree(root.left);
        //调整连接持续
        root.left.left = root.right;
        root.left.right = root;
        root.left = null；
        root.right = null;

        return newRoot;
    }
};