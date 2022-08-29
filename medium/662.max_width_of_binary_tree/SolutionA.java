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
    public int widthOfBinaryTree(TreeNode root) {
        int result = 0;
        Queue<MyNode> q = new LinkedList<>();
        q.add(new MyNode(root, 0, 0));
        while(!q.isEmpty()) {
            MyNode top = q.peek();
            List<MyNode> nodes = new ArrayList<>();
            while(!q.isEmpty() && top.level == q.peek().level) {
                nodes.add(q.poll());
            }
            result = Math.max(result, nodes.get(nodes.size()-1).index-nodes.get(0).index+1);
            for(MyNode myNode : nodes) {
                int index = Math.max(0, myNode.index-1);
                if(myNode.node.left!=null) {
                    q.add(new MyNode(myNode.node.left, myNode.level+1, 2*index+1));
                }
                
                if(myNode.node.right!=null) {
                    q.add(new MyNode(myNode.node.right, myNode.level+1, 2*index+2));
                }
            }
        }
        return result;
    }
}

class MyNode {
    TreeNode node;
    int level, index;
    
    public MyNode(TreeNode node, int level, int index) {
        this.node = node;
        this.level = level;
        this.index = index;
    }
}