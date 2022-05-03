// https://leetcode.com/problems/lfu-cache/

class Node {
    int key;
    int val;
    int freq;
    
    Node next;
    Node prev;
    
    public Node(int key, int val) {
        this.key = key;
        this.val = val;
        freq=1;
        next = prev = null;
    }
}

class DLL {
    Node head;
    Node tail;
    int size;
    
    public DLL() {
        head = tail = null;
        size=0;
    }
    
    public boolean isEmpty() {
        return size==0;
    }
    
    public void remove(Node node) {
        if(size==1) {
            head = tail = null;
            node.next = null;
            node.prev = null;
            
            size--;
            return;
        }
        
        if(node==head) {
            head = head.next;
            head.prev = null;
        }
        else if(node==tail) {
            tail = tail.prev;
            tail.next = null;
        }
        else {
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }
        
        node.next = null;
        node.prev = null;
        size--;
     }
    
    public void addFirst(Node node) {
        if(head==null) {
            head = tail = node;
            size++;
            return;
        }
        
        node.next = head;
        head.prev = node;
        head = node;
        size++;
    }
    
    public Node pollLast() {
        if(size==1) {
            Node tempTail = tail;
            head = tail = null;
            size--;
            return tempTail;
        }
        
        Node tempTail = tail;
        tail = tail.prev;
        tail.next = null;
        size--;
        return tempTail;
    }
}

class LFUCache {
    
    Map<Integer, DLL> freqToQ;
    Map<Integer, Node> cache;
    
    int capacity;
    int size;
    int minFreq;

    public LFUCache(int capacity) {
        this.capacity = capacity;
        size=0;
        minFreq=0;
        freqToQ = new HashMap<>();
        cache = new HashMap<>();
    }
    
    public int get(int key) {
        if(capacity==0) {
            return -1;
        }
        Node node = cache.getOrDefault(key, null);
        if(node==null) {
            return -1;
        }
        
        DLL srcList = freqToQ.get(node.freq);
        srcList.remove(node);
        if(srcList.isEmpty()) {
            freqToQ.remove(node.freq);
            if(node.freq==minFreq) {
                minFreq = node.freq+1;
            }
        }
        
        node.freq++;
        DLL destList = freqToQ.getOrDefault(node.freq, new DLL());
        destList.addFirst(node);
        freqToQ.put(node.freq, destList);
        
        // System.out.println("get " + key);
        // System.out.println(freqToQ);
        // System.out.println(cache);
        return node.val;
    }
    
    public void put(int key, int value) {
        if(capacity==0) {
            return;
        }
        Node node = cache.getOrDefault(key, null);
        if(node==null) {
            if(size==capacity) {
                DLL minFreqQ = freqToQ.get(minFreq);
                Node nodeToRemove = minFreqQ.pollLast();
                cache.remove(nodeToRemove.key);
                if(minFreqQ.isEmpty()) {
                    freqToQ.remove(minFreq);
                }
                size--;
            }
            
            node = new Node(key, value);
            cache.put(key, node);
            DLL freqOneQ = freqToQ.getOrDefault(1 , new DLL());
            freqOneQ.addFirst(node);
            freqToQ.put(1, freqOneQ);
            minFreq = 1;
            size++;
        }
        else {
            node.val = value;
            DLL srcList = freqToQ.get(node.freq);
            srcList.remove(node);
            if(srcList.isEmpty()) {
                freqToQ.remove(node.freq);
                if(node.freq==minFreq) {
                    minFreq = node.freq+1;
                }
            }
            
            node.freq++;
            DLL destList = freqToQ.getOrDefault(node.freq, new DLL());
            destList.addFirst(node);
            freqToQ.put(node.freq, destList);
        }
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */