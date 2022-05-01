// https://leetcode.com/problems/median-of-two-sorted-arrays/
// TC: O(log(min(num1.length, nums2.length)))
// SC: O(1)

class SolutionA {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if(nums2.length < nums1.length) {
            return findMedianSortedArrays(nums2, nums1);
        }
        
        int low=0,high=nums1.length;
        int partition = (nums1.length+nums2.length+1)/2;
        while(low<=high) {
            int cut1 = (low+high)/2;
            int cut2 = partition-cut1;
            
            int l1 = cut1==0 ? Integer.MIN_VALUE : nums1[cut1-1];
            int l2 = cut2==0 ? Integer.MIN_VALUE : nums2[cut2-1];
            int r1 = cut1==nums1.length ? Integer.MAX_VALUE : nums1[cut1];
            int r2 = cut2==nums2.length ? Integer.MAX_VALUE : nums2[cut2];
            
            if(l1<=r2 && l2<=r1) {
                if((nums1.length+nums2.length)%2==0) {
                    return (double)(Math.max(l1,l2) + Math.min(r1, r2))/2;
                }
                else {
                    return Math.max(l1,l2);
                }
            }
            else if(l1>r2) {
                high = cut1-1;
            }
            else {
                low = cut1+1;
            }
        }
        
        throw new RuntimeException("Input arrays are invalid");
    }
}