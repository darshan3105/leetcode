// https://leetcode.com/problems/max-consecutive-ones/
// TC: O(n)
// SC: O(1)

class SolutionA {
    public int findMaxConsecutiveOnes(int[] nums) {
        int ones = 0, result = 0, i=0;
        while(i<nums.length) {
            while(i<nums.length && nums[i] == 1) {
                ones++;
                i++;
            }
            result = Math.max(result, ones);
            ones = 0;
            i++;
        }
        return Math.max(ones, result);
    }
}