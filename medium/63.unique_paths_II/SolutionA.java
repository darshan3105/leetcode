// https://leetcode.com/problems/unique-paths-ii/
// TC: O(m*n)
// SC: O(m*n)
// where m*n is the size of the grid

class SolutionA {
    public int uniquePathsWithObstacles(int[][] grid) {        
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];
        
        for(int i=0;i<m;i++) {
            for(int j=0;j<n;j++) {
                if(i==0 && j==0) {
                    dp[i][j] = grid[i][j] == 1 ? 0 : 1;
                    continue;
                }
                
                int left = isValid(i,j-1,dp) ? dp[i][j-1] : 0;
                int up = isValid(i-1,j,dp) ? dp[i-1][j] : 0;
                
                dp[i][j] = grid[i][j]==1 ? 0 : left+up;
            }
        }
        
        return dp[m-1][n-1];
    }
    
    private boolean isValid(int i, int j, int[][] dp) {
        int m = dp.length;
        int n = dp[0].length;
        
        return i>=0 && i<m && j>=0 && j<n;
    }
}