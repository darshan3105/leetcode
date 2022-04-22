// https://leetcode.com/problems/n-queens/

class SolutionA {
    
    List<List<String>> result = new ArrayList<>();
    
    public List<List<String>> solveNQueens(int n) {
        char[][] grid = new char[n][n];
        for(int i=0;i<n;i++) {
            for(int j=0;j<n;j++) {
                grid[i][j] = '.';
            }
        }
        solve(0, n, grid);
        return result;
    }
    
    private void solve(int row, int n, char[][] grid) {
        if(row==n) {
            List<String> cur = new ArrayList<>();
            for(int i=0;i<n;i++) {
                cur.add(new String(grid[i]));
            }
            result.add(cur);
            return;
        }
        
        for(int j=0;j<n;j++) {
            if(canPlaceQueen(grid, row, j)) {
                grid[row][j] = 'Q';
                solve(row+1, n, grid);
                grid[row][j] = '.';
            }
        }
    }
    
    private boolean canPlaceQueen(char[][] grid, int row, int col) {
        int n = grid.length;
        for(int j=0;j<n;j++) {
            if(grid[row][j] == 'Q') {
                return false;
            }
        }
        
        for(int i=0;i<n;i++) {
            if(grid[i][col] == 'Q') {
                return false;
            }
        }
        
        int i=row, j=col;
        while(isValid(i,j,n)) {
            if(grid[i][j] == 'Q') {
                return false;
            }
            
            i--;
            j++;
        }
        
        i=row; j=col;
        while(isValid(i,j,n)) {
            if(grid[i][j] == 'Q') {
                return false;
            }
            
            i++;
            j--;
        }
        
        i=row; j=col;
        while(isValid(i,j,n)) {
            if(grid[i][j] == 'Q') {
                return false;
            }
            
            i--;
            j--;
        }
        
        i=row; j=col;
        while(isValid(i,j,n)) {
            if(grid[i][j] == 'Q') {
                return false;
            }
            
            i++;
            j++;
        }
        
        return true;
    }
    
    private boolean isValid(int i, int j, int n) {
        return i>=0 && i<n && j>=0 && j<n;
    }
}