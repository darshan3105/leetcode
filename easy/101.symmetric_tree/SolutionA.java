// https://leetcode.com/problems/symmetric-tree/
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
class Solution {
    public boolean isSymmetric(TreeNode root) {
        return isMirror(root, root);
    }
    
    private boolean isMirror(TreeNode p, TreeNode q) {
        if(p == null && q == null) {
            return true;
        }
        
        if(p==null || q==null || p.val!=q.val) {
            return false;
        }
        
        if(!isMirror(p.left, q.right)) {
            return false;
        }
        else {
            if(!isMirror(p.right, q.left)) {
                return false;
            }
            
            return true;
        }
    }
}