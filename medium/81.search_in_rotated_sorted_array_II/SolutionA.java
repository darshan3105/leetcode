// https://leetcode.com/problems/search-in-rotated-sorted-array-ii/
// TC: O(n) in worst case and O(logn) in best case when there are no duplicates
// SC: O(1)

class SolutionA {
    public boolean search(int[] nums, int target) {        
        int l=0, r=nums.length-1,m;
        while(l<=r) {
            while(l<r && nums[l]==nums[r]) {
                l++;
            }
            
            m = (l+r)/2;
            if(nums[m]==target) {
                return true;
            }
            
            if(nums[l]<=nums[m]) {
                if(target>=nums[l] && target < nums[m]) {
                    r=m-1;
                }
                else {
                    l=m+1;
                }
            }
            else {
                if(target>nums[m] && target <= nums[r]) {
                    l=m+1;
                }
                else {
                    r=m-1;
                }
            }
        }
        
        return false;
    }    
}