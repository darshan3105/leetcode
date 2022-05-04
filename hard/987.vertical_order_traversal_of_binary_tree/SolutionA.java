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
    TreeNode treeNode;
    int x;
    int y;
    
    public Node(TreeNode treeNode, int x, int y) {
        this.treeNode = treeNode;
        this.x = x;
        this.y = y;
    }
}

class SolutionA {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        TreeMap<Integer, TreeMap<Integer, Queue<Integer>>> mp = new TreeMap<>();
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(root, 0, 0));
        
        while(!q.isEmpty()) {
            Node top = q.poll();
            TreeMap<Integer, Queue<Integer>> valMap = mp.getOrDefault(top.y, new TreeMap<>());
            if(valMap.isEmpty()) {
                Queue<Integer> pq = new PriorityQueue<>();
                pq.add(top.treeNode.val);
                valMap.put(top.x, pq);
                mp.put(top.y, valMap);
            }
            else {
                if(valMap.containsKey(top.x)) {
                    valMap.get(top.x).add(top.treeNode.val);
                }
                else {
                    Queue<Integer> pq = new PriorityQueue<>();
                    pq.add(top.treeNode.val);
                    valMap.put(top.x, pq);
                }
            }
            
            if(top.treeNode.left!=null) {
                q.add(new Node(top.treeNode.left, top.x+1, top.y-1));
            }
            
            if(top.treeNode.right!=null) {
                q.add(new Node(top.treeNode.right, top.x+1, top.y+1));
            }
        }
                
        List<List<Integer>> result = new ArrayList<>();
        for(int y : mp.keySet()) {
            List<Integer> cur = new ArrayList<>();
            for(int x : mp.get(y).keySet()) {
                Queue<Integer> pq = mp.get(y).get(x);
                while(!pq.isEmpty()) {
                    cur.add(pq.poll());
                }
            }
            result.add(cur);
        }
        
        return result;
    }
}