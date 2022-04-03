// https://leetcode.com/problems/next-permutation/
// TC: O(n)
// SC: O(1)
// where n is the length of nums

class SolutionA {
    public void nextPermutation(int[] nums) {
        boolean foundLargerNumToRight = false;
        int i;
        for(i=nums.length-2;i>=0;i--) {
            if(nums[i] < nums[i+1]) {
                foundLargerNumToRight = true;
                break;
            }
        }
        
        if(!foundLargerNumToRight) {
            reverse(nums, 0, nums.length-1);
        }
        else {
            int index = nums.length-1;
            for(int j=i+1;j<nums.length;j++) {
                if(nums[j] <= nums[i]) {
                    index = j-1;
                    break;
                }
            }
            
            swap(nums, i, index);
            reverse(nums, i+1, nums.length-1);
        }
    }
    
    private void reverse(int nums[], int start, int end) {
        while(start < end) {
            swap(nums, start, end);
            start++;
            end--;
        }
    }
    
    private void swap(int[] nums, int i, int j) {
        int temp = nums[j];
        nums[j] = nums[i];
        nums[i] = temp;
    } 
}