// https://leetcode.com/problems/word-search-ii/

class SolutionA {
    
    List<String> result = new ArrayList<>();
    
    public List<String> findWords(char[][] board, String[] words) {
        Node root = new Node();
        for(String word : words) {
            insert(root, word);
        }
        
        int m = board.length;
        int n = board[0].length;
        boolean[][] vis = new boolean[m][n];
        
        for(int i=0;i<m;i++) {
            for(int j=0;j<n;j++) {
                dfs(board, i, j, vis, root);
            }
        }
        return result;
    }
    
    private void dfs(char[][] board, int row, int col, boolean[][] vis, Node root) {
        if(!isValid(row, col, board) || vis[row][col]) {
            return;
        }
        
        char ch = board[row][col];
        if(root.children[ch-'a']==null) {
            return;
        }
        
        vis[row][col] = true;
        if(root.children[ch-'a'].str!=null) {
            result.add(root.children[ch-'a'].str);
            root.children[ch-'a'].str = null;
        }
        
        int[] dx = new int[]{-1,0,1,0};
        int[] dy = new int[]{0,1,0,-1};
        
        for(int i=0;i<4;i++) {
            int newRow = row+dx[i];
            int newCol = col+dy[i];
            dfs(board, newRow, newCol, vis, root.children[ch-'a']);
        }
        
        vis[row][col] = false;
    }
    
    private boolean isValid(int i, int j, char[][] board) {
        return i>=0 && i<board.length && j>=0 && j<board[0].length;
    }
    
    private void insert(Node root, String word) {
        Node cur = root;
        for(int i=0;i<word.length();i++) {
            char ch = word.charAt(i);
            if(cur.children[ch-'a']==null) {
                cur.children[ch-'a'] = new Node();
            }
            cur = cur.children[ch-'a'];
        }
        cur.str = word;
    }
}

class Node {
    Node[] children;
    String str;
    
    public Node() {
        children = new Node[26];
        str = null;
    }
}