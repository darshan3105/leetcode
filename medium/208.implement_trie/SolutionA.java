// https://leetcode.com/problems/implement-trie-prefix-tree/

class Trie {
    
    Node root;

    public Trie() {
        root = new Node('#');
    }
    
    public void insert(String word) {
        char[] arr = word.toCharArray();
        Node cur = root;
        for(int i=0;i<arr.length;i++) {
            char ch = arr[i];
            if(cur.next[ch-'a']==null) {
                cur.next[ch-'a'] = new Node(ch);
            }
            cur = cur.next[ch-'a'];
        }
        cur.isDone = true;
    }
    
    public boolean search(String word) {
        char[] arr = word.toCharArray();
        Node cur = root;
        for(int i=0;i<arr.length;i++) {
            char ch = arr[i];
            if(cur.next[ch-'a'] == null) {
                return false;
            }
            cur = cur.next[ch-'a'];
        }
        return cur.isDone;
    }
    
    public boolean startsWith(String prefix) {
        char[] arr = prefix.toCharArray();
        Node cur = root;
        for(int i=0;i<arr.length;i++) {
            char ch = arr[i];
            if(cur.next[ch-'a'] == null) {
                return false;
            }
            cur = cur.next[ch-'a'];
        }
        return true;
    }
}

class Node {
    
    char ch;
    Node[] next;
    boolean isDone;
    
    public Node(char ch) {
        this.ch = ch;
        next = new Node[26];
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */