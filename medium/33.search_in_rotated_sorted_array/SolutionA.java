// https://leetcode.com/problems/search-in-rotated-sorted-array/
// TC: O(logn)
// SC: O(1)
// where n is the length of nums

class SolutionA {
    public int search(int[] nums, int target) {
        int l=0,r=nums.length-1;
        while(l <= r) {
            int m = (l+r)/2;
            
            if(nums[m] == target) {
                return m;
            }
            else if(nums[l] <= nums[m]) {
                if(target >= nums[l] && target < nums[m]) {
                    r = m-1;
                }
                else {
                    l = m+1;
                }
            }
            else {
                if(target > nums[m] && target <= nums[r]) {
                    l = m+1;
                }
                else {
                    r = m-1;
                }
            }
        }
        
        return -1;
    }
}