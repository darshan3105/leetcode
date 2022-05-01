// https://leetcode.com/problems/single-element-in-a-sorted-array/
// TC: O(logn)
// SC: O(1)

class SolutionA {
    public int singleNonDuplicate(int[] nums) {
        int n = nums.length;
        int l=0,r=n-1,m;
        while(l<r) {
            m = (l+r)/2;
            if(m-1>=0 && nums[m-1]!=nums[m] && m+1<n && nums[m+1]!=nums[m]) {
                return nums[m];
            }
            
            if(m-1>=0 && nums[m-1]==nums[m]) {
                if((m-l+1)%2==0) {
                    l=m+1;
                }
                else {
                    r=m;
                }
            }
            else {
                if((r-m+1)%2==0) {
                    r=m-1;
                }
                else {
                    l=m;
                }
            }
        }
        
        return nums[l];
    }
}