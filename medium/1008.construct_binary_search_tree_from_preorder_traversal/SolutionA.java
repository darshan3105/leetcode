// https://leetcode.com/problems/construct-binary-search-tree-from-preorder-traversal/
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
class SolutionA {
    public TreeNode bstFromPreorder(int[] preorder) {
        Stack<TreeNode> st = new Stack<>();
        TreeNode root = new TreeNode(preorder[0]);
        st.push(root);
        for(int i=1;i<preorder.length;i++) {
            if(preorder[i]<st.peek().val) {
                st.peek().left = new TreeNode(preorder[i]);
                st.push(st.peek().left);
            }
            else {
                TreeNode prev = null;
                while(!st.isEmpty() && st.peek().val<=preorder[i]) {
                    prev = st.pop();
                }
                prev.right = new TreeNode(preorder[i]);
                st.push(prev.right);
            } 
        }
        return root;
    }
}