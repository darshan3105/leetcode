/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class SolutionA {
    public Node connect(Node root) {
        Queue<MyNode> q = new LinkedList<>();
        if(root!=null) {
            q.add(new MyNode(root, 0));
        }
        while(!q.isEmpty()) {
            MyNode top = q.poll();
            if(top.node.left!=null) {
                q.add(new MyNode(top.node.left, top.level+1));
            }
            if(top.node.right!=null) {
                q.add(new MyNode(top.node.right, top.level+1));
            }
            MyNode prev = top;
            while(!q.isEmpty() && q.peek().level == top.level) {
                MyNode cur = q.poll();
                if(cur.node.left!=null) {
                    q.add(new MyNode(cur.node.left, cur.level+1));
                }
                if(cur.node.right!=null) {
                    q.add(new MyNode(cur.node.right, cur.level+1));
                }
                prev.node.next = cur.node;
                prev = cur;
            }
            prev.node.next = null;
        }
        return root;
    }
}

class MyNode {
    Node node;
    int level;
    
    public MyNode(Node node, int level) {
        this.node = node;
        this.level = level;
    }
}