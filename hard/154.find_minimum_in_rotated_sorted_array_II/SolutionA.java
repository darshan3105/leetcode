// https://leetcode.com/problems/find-minimum-in-rotated-sorted-array-ii/
// TC: O(n) in worst case, O(logn) in average case
// SC: O(1)

class SolutionA {
    public int findMin(int[] nums) {
        int low=0,high=nums.length-1;
        while(low<high) {
            int mid = (low+high)/2;
            while(low<mid && nums[low]==nums[mid]) {
                low++;
            }
            while(mid<high && nums[mid]==nums[high]) {
                high--;
            }
            
            if(nums[low]>nums[mid]) {
                high=mid;
            }
            else if(nums[mid]>nums[high]) {
                low=mid+1;
            }
            else {
                high=mid;
            }
        }
        return nums[low];
    }
}