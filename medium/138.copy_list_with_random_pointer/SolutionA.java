/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class SolutionA {
    public Node copyRandomList(Node head) {
        Map<Node, Node> mp = new HashMap<>();
        Node newHead = null;
        while(head!=null) {
            Node cur = null;
            if(!mp.containsKey(head)) {
                cur = new Node(head.val);
            }
            else {
                cur = mp.get(head);
            }
            if(newHead == null) {
                newHead = cur;
            }
            mp.put(head, cur);
            
            Node next = head.next;
            if(next==null) {
                cur.next = null;
            }
            else {
                if(mp.containsKey(next)) {
                    cur.next = mp.get(next);
                }
                else {
                    Node sNext = new Node(next.val);
                    cur.next = sNext;
                    mp.put(next, sNext);
                }
            }
            
            Node random = head.random;
            if(random==null) {
                cur.random = null;
            }
            else {
                if(mp.containsKey(random)) {
                    cur.random = mp.get(random);
                }
                else {
                    Node sRandom = new Node(random.val);
                    cur.random = sRandom;
                    mp.put(random, sRandom);
                }
            }
            
            head = head.next;
        }
        return newHead;
    }
}