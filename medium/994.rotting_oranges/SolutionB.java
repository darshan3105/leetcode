class SolutionB {
    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] vis = new boolean[m][n];
        int[][] time = new int[m][n];
        int result = 0;
        
        for(int i=0;i<m;i++) {
            for(int j=0;j<n;j++) {
                time[i][j] = Integer.MAX_VALUE;
            }
        }
        
        for(int i=0;i<m;i++) {
            for(int j=0;j<n;j++) {
                if(grid[i][j]==2) {
                    dfs(grid, i, j, vis, time, 0);
                }
            }
        }
        
        for(int i=0;i<m;i++) {
            for(int j=0;j<n;j++) {
                if(grid[i][j]==1) {
                    result = Math.max(result, time[i][j]);
                }
            }
        }
        return result==Integer.MAX_VALUE ? -1 : result;
    }
    
    private void dfs(int[][] grid, int row, int col, boolean[][] vis, int[][] time, int curTime) {
        time[row][col] = Math.min(time[row][col], curTime);
        vis[row][col] = true;
        
        int[] i_dx = new int[]{-1,0,1,0};
        int[] i_dy = new int[]{0,1,0,-1};
        
        int result = 0;
        for(int i=0;i<4;i++) {
            int newRow = row+i_dx[i];
            int newCol = col+i_dy[i];
            if(isValid(newRow, newCol, grid, vis)) {
                dfs(grid, newRow, newCol, vis, time, curTime+1);
            }
        }
        vis[row][col] = false;
    }
    
    private boolean isValid(int row, int col, int[][] grid, boolean[][] vis) {
        return row>=0 && row<grid.length && col>=0 && col<grid[0].length && grid[row][col] == 1 && !vis[row][col];
    }
}