// https://leetcode.com/problems/surrounded-regions/
// TC: O(m*n)
// SC: O(1) excluding the recursion stack space

class SolutionA {
    public void solve(char[][] board) {
        int m = board.length;
        int n = board[0].length;
        
        for(int i=0;i<m;i++) {
            if(board[i][0]=='O') {
                mark(board, i, 0);
            }
            if(board[i][n-1]=='O') {
                mark(board, i, n-1);
            }
        }
        
        for(int j=0;j<n;j++) {
            if(board[0][j]=='O') {
                mark(board, 0, j);
            }
            if(board[m-1][j]=='O') {
                mark(board, m-1, j);
            }
        }
        
        for(int i=0;i<m;i++) {
            for(int j=0;j<n;j++) {
                if(board[i][j]=='E') {
                    board[i][j] = 'O';
                }
                else {
                    board[i][j] = 'X';
                }
            }
        }
    }
    
    private void mark(char[][] board, int row, int col) {
        board[row][col] = 'E';
        int[] dx = new int[]{-1,0,1,0};
        int[] dy = new int[]{0,1,0,-1};
        
        for(int i=0;i<4;i++) {
            int newRow = row + dx[i];
            int newCol = col + dy[i];
            if(isValid(board, newRow, newCol)) {
                mark(board, newRow, newCol);
            }
        }
    }
    
    private boolean isValid(char[][] board, int i, int j) {
        return i>=0 && i<board.length && j>=0 && j<board[0].length && board[i][j] == 'O';
    }
}