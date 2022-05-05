// https://leetcode.com/problems/maximum-sum-bst-in-binary-tree/
// TC: O(n)
// SC: O(height(tree))

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

class Node {
    int min;
    int max;
    int sum;
    boolean isBST;
    
    public Node(int min, int max, int sum, boolean isBST) {
        this.min = min;
        this.max = max;
        this.sum = sum;
        this.isBST = isBST;
    }
    
    public Node(boolean isBST) {
        this.isBST = isBST;
    }
}

class SolutionA {
    
    int result = 0;
    
    public int maxSumBST(TreeNode root) {
        calculate(root, 0);
        return result;
    }
    
    private Node calculate(TreeNode node, int dir) {
        if(node==null) {
            if(dir==0) {
                return new Node(Integer.MIN_VALUE, Integer.MIN_VALUE, 0, true);
            }
            else {
                return new Node(Integer.MAX_VALUE, Integer.MAX_VALUE, 0, true);
            }
        }
        
        Node left = calculate(node.left, 0);
        Node right = calculate(node.right, 1);
        
        if(left.isBST && right.isBST && left.max<=node.val && right.min>node.val) {
            int sum = left.sum+right.sum+node.val;
            result = Math.max(result, sum);
            int min = left.min==Integer.MIN_VALUE ? node.val : left.min;
            int max = right.max==Integer.MAX_VALUE ? node.val : right.max;
            return new Node(min, max, sum, true);
        }
        else {
            return new Node(false);
        }
    }
}