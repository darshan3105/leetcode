// https://leetcode.com/problems/word-ladder/
// TC: O(n^2*(len(word)))
// SC: O(n + E) where n = number of words, E = number of edges

class SolutionA {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        List<String> words = new ArrayList<>();
        if(!beginWordPresentInList(beginWord, wordList)) {
            words.add(beginWord);
        }
        
        for(String word : wordList) {
            words.add(word);
        }
        
        swapBeginWordWithFirst(beginWord, words);
        
        Graph g = new Graph(words.size());
        for(int i=0;i<words.size()-1;i++) {
            for(int j=i+1;j<words.size();j++) {
                if(canAddEdge(words.get(i), words.get(j))) {
                    g.addEdge(i, j);
                }
            }
        }
        
        return shortestDist(g, beginWord, endWord, words);
    }
    
    private void swapBeginWordWithFirst(String beginWord, List<String> words) {
        int ptr=-1;
        for(int i=0;i<words.size();i++) {
            if(words.get(i).equals(beginWord)) {
                ptr=i;
                break;
            }
        }
        
        String temp = words.get(0);
        words.set(0, words.get(ptr));
        words.set(ptr, temp);
    }
    
    private boolean beginWordPresentInList(String beginWord, List<String> words) {
        for(String word: words) {
            if(word.equals(beginWord)) {
                return true;
            }
        }
        return false;
    }
    
    private int shortestDist(Graph g, String beginWord, String endWord, List<String> words) {
        Queue<int[]> q = new LinkedList<>();
        Set<Integer> vis = new HashSet<>();
        q.add(new int[]{0, 1});
        vis.add(0);
        
        while(!q.isEmpty()) {
            int[] top = q.poll();
            if(words.get(top[0]).equals(endWord)) {
                return top[1];
            }
            
            for(int next : g.getNext(top[0])) {
                if(!vis.contains(next)) {
                    vis.add(next);
                    q.add(new int[]{next, top[1]+1});
                }
            }
        }
        
        return 0;
    }
    
    private boolean canAddEdge(String s1, String s2) {
        if(s1.length()!=s2.length()) {
            return false;
        }
        
        int cnt=0;
        for(int i=0;i<s1.length();i++) {
            if(s1.charAt(i)!=s2.charAt(i)) {
                cnt++;
            }
        }
        
        return cnt==1;
    }
}

class Graph {
    List<Integer> next[];
    
    public Graph(int size) {
        next = new ArrayList[size];
        for(int i=0;i<size;i++) {
            next[i] = new ArrayList<>();
        }
    }
    
    public void addEdge(int src, int dest) {
        next[src].add(dest);
        next[dest].add(src);
    }
    
    public List<Integer> getNext(int node) {
        return next[node];
    }
}