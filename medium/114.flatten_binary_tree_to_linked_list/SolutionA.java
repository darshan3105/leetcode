// https://leetcode.com/problems/flatten-binary-tree-to-linked-list/
// TC: O(n)
// SC: O(1)

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class SolutionA {
    public void flatten(TreeNode root) {
        getTailOfChain(root);
    }
    
    private TreeNode getTailOfChain(TreeNode node) {
        if(node==null) {
            return null;
        }
        
        TreeNode leftTail = getTailOfChain(node.left);
        TreeNode rightTail = getTailOfChain(node.right);
        
        if(leftTail==null && rightTail==null) {
            return node;
        }
        if(leftTail==null) {
            return rightTail;
        }
        if(rightTail==null) {
            node.right = node.left;
            node.left=null;
            return leftTail;
        }
        
        leftTail.right = node.right;
        node.right = node.left;
        node.left=null;
        return rightTail;
    }
}