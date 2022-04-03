// https://leetcode.com/problems/jump-game-ii/
// TC: O(n*max(nums))
// SC: O(1)
// where n is the length of nums and max(nums) is the maximum value in nums.

class SolutionA {
    public int jump(int[] nums) {
        int len = nums.length;
        int[] steps = new int[len];
        steps[0] = 0;
        
        for(int i=0;i<len;i++) {
            for(int j=i+1;j<=i+nums[i] && j<len;j++) {
                if(steps[j]==0) {
                    steps[j] = steps[i]+1;
                }
                else {
                    steps[j] = Math.min(steps[j], steps[i]+1);
                }
            }
        }
        
        return steps[len-1];
    }
}