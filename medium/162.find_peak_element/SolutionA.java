// https://leetcode.com/problems/find-peak-element/
// TC: O(logn)
// SC: O(1)

class SolutionA {
    public int findPeakElement(int[] nums) {
        int low=0, high=nums.length-1;
        while(low<high) {
            int mid = (low+high)/2;
            int left = mid==0 ? Integer.MIN_VALUE : nums[mid-1];
            int right = mid==nums.length-1 ? Integer.MIN_VALUE : nums[mid+1];
            
            if(nums[mid]>left && nums[mid]>right) {
                return mid;
            }
            else if(left>nums[mid]) {
                high=mid-1;
            }
            else {
                low=mid+1;
            }
        }
        return low;
    }
}