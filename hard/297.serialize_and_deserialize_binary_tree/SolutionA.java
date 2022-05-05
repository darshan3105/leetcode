// https://leetcode.com/problems/serialize-and-deserialize-binary-tree/

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {
    
    int ptr = 0;

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder builder = new StringBuilder();
        preOrder(root, builder);
        return builder.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] vals = data.split(",");
        ptr = 0;
        return toTree(vals);
    }
    
    private void preOrder(TreeNode node, StringBuilder builder) {
        if(node == null) {
            builder.append("n,");
            return;
        }
        
        builder.append(String.valueOf(node.val) + ",");
        preOrder(node.left, builder);
        preOrder(node.right, builder);
    }
    
    private TreeNode toTree(String[] vals) {
        if(ptr==vals.length-1) {
            return null;
        }
        
        if(vals[ptr].equals("n")) {
            ptr++;
            return null;
        }
        
        TreeNode node = new TreeNode(Integer.valueOf(vals[ptr]));
        System.out.println(node.val);
        ptr++;
        node.left = toTree(vals);
        node.right = toTree(vals);
        
        return node;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));