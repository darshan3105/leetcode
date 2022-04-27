// https://leetcode.com/problems/merge-sorted-array/
// TC: O(n*m)
// SC: O(1)

class SolutionA {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if(n==0) {
            return;
        }
        else if(m==0) {
            for(int i=0;i<n;i++) {
                nums1[i] = nums2[i];
            }
            return;
        }
        
        int i=0;
        while(i<m) {
            if(nums1[i] > nums2[0]) {
                int temp = nums1[i];
                nums1[i] = nums2[0];
                nums2[0] = temp;
                reorder(nums2);
            }
            i++;
        }
        
        for(i=0;i<n;i++) {
            nums1[i+m] = nums2[i];
        }
    }
    
    private void reorder(int[] nums) {
        for(int i=0;i<nums.length-1;i++) {
            if(nums[i] < nums[i+1]) {
                break;
            }
            
            int temp = nums[i];
            nums[i] = nums[i+1];
            nums[i+1] = temp;
        }
    }
}