// https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/
// TC: O(n)
// SC: O(1)

class SolutionA {
    public int maxProfit(int[] prices) {
        int result = 0;
        for(int i=1;i<prices.length;i++) {
            if(prices[i]-prices[i-1]>0) {
                result+=prices[i]-prices[i-1];
            }
        }
        return result;
    }
}