// https://leetcode.com/problems/find-the-duplicate-number/
// TC: O(n)
// SC: O(1)

class SolutionA {
    public int findDuplicate(int[] nums) {
        int i=0;
        int ans=0;
        while(true) {
            int temp_i = i;
            i=nums[i];
            nums[temp_i]=-1;
            if(nums[i]==-1) {
                ans = i;
                break;
            }
        }
        return ans;
    }
}