// https://leetcode.com/problems/remove-duplicates-from-sorted-array/
// TC: O(n)
// SC: O(1)

class SolutionA {
    public int removeDuplicates(int[] nums) {
        int i=0;
        while(i<nums.length) {
            if(i!=0 && nums[i]==nums[i-1]) {
                int cur = nums[i];
                while(i<nums.length && nums[i]==cur) {
                    nums[i] = -101;
                    i++;
                }
            }
            i++;
        }
        
        int hole = 0;
        for(i=0;i<nums.length;i++) {
            while(hole < nums.length && nums[hole]!=-101) {
                hole++;
            }
            
            if(i>hole && nums[i] != -101) {
                int temp = nums[hole];
                nums[hole] = nums[i];
                nums[i] = temp;
            }
        }
        
        int result = 0;
        for(i=0;i<nums.length;i++) {
            if(nums[i] == -101) {
                break;
            }
            result++;
        }
        return result;
    }
}