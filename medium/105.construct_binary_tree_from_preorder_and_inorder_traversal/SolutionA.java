// https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
// TC: O(n^2)
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
class SolutionA {
    int ptr=0;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return construct(preorder, inorder, 0, inorder.length-1);
    }
    
    TreeNode construct(int[] preorder, int[] inorder, int low, int high) {
        if(low>high || ptr==preorder.length) {
            return null;
        }
        
        int i=low;
        for(;i<=high;i++) {
            if(inorder[i] == preorder[ptr]) {
                break;
            }
        }
        
        TreeNode node = new TreeNode(preorder[ptr]);
        ptr++;
        node.left = construct(preorder, inorder, low, i-1);
        node.right = construct(preorder, inorder, i+1, high);
        
        return node;
    }
}