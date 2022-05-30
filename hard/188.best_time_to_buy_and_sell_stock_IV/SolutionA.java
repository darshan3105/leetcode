// https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iv/
// TC: O(k*(n^2))
// SC: O(k*n)

class SolutionA {
    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        int[][] dp = new int[k+1][n];
        int result = 0;
        
        for(int j=1;j<n;j++) {
            for(int i=0;i<k+1;i++) {
                dp[i][j] = dp[i][j-1];
            }
            
            for(int K=1;K<k+1;K++) {
                for(int i=j-1;i>=0;i--) {
                    int prev = i==0 ? 0 : dp[K-1][i-1];
                    dp[K][j] = Math.max(dp[K][j], prices[j]-prices[i]+prev); 
                }
                result = Math.max(result, dp[K][j]);
            }
        }
        
        return result;
    }
}

