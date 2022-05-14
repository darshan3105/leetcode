// https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iii/
// TC: O(n)
// SC: O(n)

class SolutionA {
    public int maxProfit(int[] prices) {
        Stack<Integer> stack = new Stack<>();
        for(int i=prices.length-1;i>=0;i--) {
            if(stack.isEmpty() || prices[stack.peek()] < prices[i]) {
                stack.push(i);
            }
        }
        
        int leftProfit = 0;
        int rightProfit = 0;
        int result = 0;
        int leftMin = Integer.MAX_VALUE;
        for(int i=0;i<prices.length;i++) {
            while(!stack.isEmpty() && stack.peek()<i) {
                stack.pop();
            }
            leftMin = i==0 ? Integer.MAX_VALUE : Math.min(leftMin, prices[i-1]);
            leftProfit = i==0 ? 0 : Math.max(leftProfit, prices[i-1]-leftMin);
            rightProfit = stack.isEmpty() ? 0 : Math.max(0,prices[stack.peek()] - prices[i]);
            result = Math.max(result, rightProfit+leftProfit);
        }
        
        return result;
    }
}