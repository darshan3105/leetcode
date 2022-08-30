// https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/

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
    public TreeNode sortedArrayToBST(int[] nums) {
        return construct(nums, 0, nums.length-1);
    }
    
    private TreeNode construct(int[] nums, int l, int r) {
        if(l>r) {
            return null;
        }
        
        int m = (l+r)/2;
        TreeNode node = new TreeNode(nums[m]);
        node.left = construct(nums, l, m-1);
        node.right = construct(nums, m+1, r);
        return node;
    }
}