// https://leetcode.com/problems/lru-cache/

class Node {
    int key;
    int val;
    Node next;
    Node prev;
    
    public Node(int key, int val) {
        this.key = key;
        this.val = val;
        this.next = null;
        this.prev = null;
    }
}

class LRUCache {
    Node head, tail;
    int capacity, size;
    Map<Integer, Node> mp;

    public LRUCache(int capacity) {
        head = tail = null;
        this.capacity = capacity;
        size = 0;
        mp = new HashMap<>();
    }
    
    public int get(int key) {
        Node node = mp.getOrDefault(key, null);
        if(node==null) {
            return -1;
        }
        else {
            rearrange(node);
            return node.val;
        }
    }
    
    public void put(int key, int value) {
        Node node = mp.getOrDefault(key, null);
        if(node==null) {
            node = new Node(key, value);
            mp.put(key, node);
            if(head==null) {
                head = tail = node;
            }
            else {
                node.next = head;
                head.prev = node;
                head = node;
            }
            
            size++;
            if(size>capacity) {
                mp.remove(tail.key);
                tail = tail.prev;
                tail.next = null;
                size--;
            }
        }
        else {
            node.val = value;
            rearrange(node);
        }
        
    }
    
    private void rearrange(Node node) {
        if(node==head) {
                
        }
        else if(node==tail) {
            tail = tail.prev;
            tail.next = null;
            node.next = head;
            head.prev = node;
            head = node;
        }
        else {
            node.prev.next = node.next;
            node.next.prev = node.prev;
            node.next = head;
            head.prev = node;
            head = node;
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */