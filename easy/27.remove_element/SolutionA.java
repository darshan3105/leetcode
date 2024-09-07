// https://leetcode.com/problems/remove-element/
// TC: O(n)
// SC: O(1)

class SolutionA {
    public int removeElement(int[] nums, int val) {
        int swapPtr=-1;
        for (int i=0;i<nums.length;i++) {
            if(nums[i]==val) {
                continue;
            }

            nums[swapPtr+1] = nums[i];
            swapPtr++;
        }
        return swapPtr+1;
    }
}
