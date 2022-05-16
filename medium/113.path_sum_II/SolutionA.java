// https://leetcode.com/problems/path-sum-ii/
// TC: O(n)
// SC: O(n)

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
    
    List<List<Integer>> result = new ArrayList<>();
    
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<Integer> cur = new ArrayList<>();
        calculate(root, targetSum, cur);
        return result;
    }
    
    private void calculate(TreeNode node, int targetSum, List<Integer> cur) {
        if(node==null) {
            return;
        }
        
        cur.add(node.val);
        calculate(node.left, targetSum-node.val, cur);
        calculate(node.right, targetSum-node.val, cur);
        
        if(node.left==null && node.right==null && targetSum == node.val) {
            result.add(new ArrayList<>(cur));
        }
        cur.remove(cur.size()-1);
    }
}