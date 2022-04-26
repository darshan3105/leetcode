// https://leetcode.com/problems/maximum-subarray/
// TC: O(n)
// SC: O(1) where n is the length of nums array

class SolutionA {
    public int maxSubArray(int[] nums) {
        int result = nums[0];
        int curSum = 0;
        int min = 0;
        
        for(int i=0;i<nums.length;i++) {
            curSum+=nums[i];
            result = Math.max(result, curSum-min);
            min = Math.min(min, curSum);
        }
        
        return result;
    }
}