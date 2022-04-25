// https://leetcode.com/problems/unique-binary-search-trees-ii/

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
        
    public List<TreeNode> generateTrees(int n) {
        return calculate(1, n);
    }
    
    private List<TreeNode> calculate(int l, int r) {
        if(l>r) {
            List<TreeNode> list = new ArrayList<>();
            list.add(null);
            return list;
        }
        
        List<TreeNode> cur = new ArrayList<>();
        for(int root=l;root<=r;root++) {
            List<TreeNode> leftList = calculate(l, root-1);
            List<TreeNode> rightList = calculate(root+1, r);
            
            for(TreeNode left : leftList) {
                for(TreeNode right : rightList) {
                    TreeNode rootNode = new TreeNode(root);
                    rootNode.left = left;
                    rootNode.right = right;
                    
                    cur.add(rootNode);
                }
            }
        }
        
        return cur;
    }
}