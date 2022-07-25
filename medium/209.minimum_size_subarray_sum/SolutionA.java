// https://leetcode.com/problems/minimum-size-subarray-sum/
// TC: O(n)
// Sc: O(1)

class SolutionA {
    public int minSubArrayLen(int target, int[] nums) {
        int result = Integer.MAX_VALUE;
        int l=0,r=0,sum=nums[0];
        while(r<nums.length) {
            if(sum<target) {
                r++;
                if(r==nums.length) {
                    break;
                }
                sum+=nums[r];
            }
            else {
                result = Math.min(result, r-l+1);
                sum-=nums[l];
                l++;
                if(l>r) {
                    r++;
                }
            }
        }
        return result==Integer.MAX_VALUE ? 0 : result;
    }
}