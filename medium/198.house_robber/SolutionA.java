// https://leetcode.com/problems/house-robber/
// TC: O(n)
// SC: O(n)

class SolutionA {
    public int rob(int[] nums) {
        int n = nums.length;        
        if(n==1) {
            return nums[0];
        }
        for(int i=2;i<n;i++) {
            nums[i] = Math.max(nums[i-1], nums[i]+nums[i-2]);
        }
        return nums[n-1];
    }
}