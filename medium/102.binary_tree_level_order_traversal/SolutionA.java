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
    public List<List<Integer>> levelOrder(TreeNode root) {
        Map<Integer, List<Integer>> mp = new HashMap<>();
        Queue<MyNode> q = new LinkedList<>();
        if(root!=null) {
            q.add(new MyNode(root, 0));
        }
        while(!q.isEmpty()) {
            MyNode top = q.poll();
            List<Integer> curList = mp.getOrDefault(top.level, new ArrayList<>());
            curList.add(top.node.val);
            mp.put(top.level, curList);
            if(top.node.left!=null) {
                q.add(new MyNode(top.node.left, top.level+1));
            }
            if(top.node.right!=null) {
                q.add(new MyNode(top.node.right, top.level+1));
            }
        }
        List<List<Integer>> result = new ArrayList<>();
        for(int key : mp.keySet()) {
            result.add(mp.get(key));
        }
        return result;
    }
}

class MyNode {
    TreeNode node;
    int level;
    
    public MyNode(TreeNode node, int level) {
        this.node = node;
        this.level = level;
    }
}