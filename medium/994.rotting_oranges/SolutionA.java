// https://leetcode.com/problems/rotting-oranges/
// TC: O(m^2*n^2)
// SC: O(m*n)

class SolutionA {
    private void mark(int grid[][], int[][] dp, int row, int col, int mark) {
        int time=0;
        Queue<int[]> q = new LinkedList<>();
        boolean[][] vis = new boolean[dp.length][dp[0].length];
        q.add(new int[]{row, col, 0});
        
        while(!q.isEmpty()) {
            int[] top = q.poll();
            row = top[0];
            col = top[1];
            time = top[2];
                        
            vis[row][col] = true;
            dp[row][col] = Math.min(time, dp[row][col]);
            int[] x_dx = new int[]{-1,0,1,0};
            int[] y_dy = new int[]{0,1,0,-1};
            
            for(int i=0;i<4;i++) {
                int nextRow = row + x_dx[i];
                int nextCol = col + y_dy[i];
                if(isValid(grid, nextRow, nextCol) && !vis[nextRow][nextCol]) {
                    q.add(new int[]{nextRow, nextCol, time+1});
                }
            }
        }
    }
    
    private boolean isValid(int[][] grid, int row, int col) {
        return row>=0 && row<grid.length && col>=0 && col<grid[0].length && grid[row][col]==1;
    }
    
    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];
        
        for(int i=0;i<m;i++) {
            for(int j=0;j<n;j++) {
                dp[i][j] = Integer.MAX_VALUE;
            }
        }
        
        for(int i=0;i<m;i++) {
            for(int j=0;j<n;j++) {
                if(grid[i][j] == 2) {
                    mark(grid, dp, i, j, 0);
                }
            }
        }
        
        int result = 0;
        for(int i=0;i<m;i++) {
            for(int j=0;j<n;j++) {
                if(grid[i][j] == 0) {
                    continue;
                }
                
                if(dp[i][j] == Integer.MAX_VALUE) {
                    return -1;
                }
                
                result = Math.max(result, dp[i][j]);
            }
        }
        return result;
    }
}