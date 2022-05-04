// https://leetcode.com/problems/binary-tree-maximum-path-sum/
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
    
    int maxSum = Integer.MIN_VALUE;
    
    public int maxPathSum(TreeNode root) {
        sumOf(root);
        return maxSum;
        
    }
    
    private int sumOf(TreeNode node) {
        if(node==null) {
            return 0;
        }
        
        int leftSum = sumOf(node.left);
        int rightSum = sumOf(node.right);
        
        if(leftSum>0 && rightSum>0) {
            maxSum = Math.max(maxSum, node.val+leftSum+rightSum);
            return Math.max(leftSum, rightSum) + node.val;
        }
        else if(leftSum>0) {
            maxSum = Math.max(maxSum, node.val+leftSum);
            return leftSum + node.val;
        }
        else if(rightSum>0) {
            maxSum = Math.max(maxSum, node.val+rightSum);
            return rightSum + node.val;
        }
        else {
            maxSum = Math.max(maxSum, node.val);
            return node.val;
        }
    }
}