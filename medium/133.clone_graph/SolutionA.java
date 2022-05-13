// https://leetcode.com/problems/clone-graph/
// TC: O(n)
// SC: O(n) where n = number of nodes in graph

/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class SolutionA {
    
    Map<Integer, Node> mp = new HashMap<>();
    
    public Node cloneGraph(Node node) {
        if(node==null) {
            return node;
        }
        if(mp.containsKey(node.val)) {
            return mp.get(node.val);
        }
        
        Node copy = new Node(node.val);
        mp.put(copy.val, copy);
        for(Node next : node.neighbors) {
            copy.neighbors.add(cloneGraph(next));
        }
        
        return copy;
    }
}