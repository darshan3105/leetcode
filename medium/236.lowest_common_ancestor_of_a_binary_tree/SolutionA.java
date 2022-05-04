// https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/
// TC: O(N)
// SC: O(1)

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    
    TreeNode lca = null;
    
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        getTargetNodeCnt(root, p, q);
        return lca;
    }
    
    private int getTargetNodeCnt(TreeNode node, TreeNode p, TreeNode q) {
        if(node==null) {
            return 0;
        }
        
        int left = getTargetNodeCnt(node.left, p, q);
        int right = getTargetNodeCnt(node.right, p, q);
        
        if(node == p || node == q) {
            if(left==1 || right ==1) {
                lca = node;
                return 2;
            }
            else {
                return 1;
            }
        }
        else {
            if(left==2 || right==2) {
                return 2;
            }
            else if(left==1 && right==1) {
                lca = node;
                return 2;
            }
            else if(left==1 || right ==1) {
                return 1;
            }
            else {
                return 0;
            }
        }
        
    } 
}