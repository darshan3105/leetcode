// https://leetcode.com/problems/maximum-subarray/
// TC: O(n)
// SC: O(1)

class SolutionA {
    public int maxSubArray(int[] nums) {
        int minCum = 0, ans = nums[0], cum=0;
        for(int i=0;i<nums.length;i++) {
            cum+=nums[i];
            ans = Math.max(ans, cum-minCum);
            minCum = Math.min(minCum, cum);
        }
        return ans;
    }
}