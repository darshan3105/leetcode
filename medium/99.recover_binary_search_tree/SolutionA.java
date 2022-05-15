// https://leetcode.com/problems/recover-binary-search-tree/
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
    
    TreeNode first = null, middle = null, last = null;
    TreeNode prev = null;
    
    public void recoverTree(TreeNode root) {
        inorder(root);
        if(last==null) {
            swapVal(first, middle);
        }
        else {
            swapVal(first, last);
        }
    }
    
    private void swapVal(TreeNode n1, TreeNode n2) {
        int temp = n1.val;
        n1.val = n2.val;
        n2.val = temp;
    }
    
    private void inorder(TreeNode node) {
        if(node==null) {
            return;
        }
        
        inorder(node.left);
        if(prev!=null && node.val < prev.val) {
            if(first==null) {
                first = prev;
                middle = node;
            }
            else {
                last = node;
            }
        }
        prev = node;
        inorder(node.right);
    }
}