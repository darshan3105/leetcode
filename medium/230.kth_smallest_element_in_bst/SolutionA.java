// https://leetcode.com/problems/kth-smallest-element-in-a-bst/
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
    
    int num = -1;

    public int kthSmallest(TreeNode root, int k) {
        find(root, k, 0);
        return num;
    }
    
    private int find(TreeNode node, int k, int numsBefore) {
        if(node==null) {
            return 0;
        }
        
        int left = find(node.left, k, numsBefore);
        if(left+1+numsBefore==k) {
            num=node.val;
        }
        int right = find(node.right, k, left+1+numsBefore);
        return left+right+1;
    }
}