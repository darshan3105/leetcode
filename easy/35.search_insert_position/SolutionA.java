// https://leetcode.com/problems/search-insert-position/description/

class SolutionA {
    public int searchInsert(int[] nums, int target) {
        int l=0,r=nums.length-1;
        while(r>=l) {
            int m = (l+r)/2;
            if (nums[m] == target) {
                return m;
            } else if (nums[m] > target) {
                r=m-1;
            } else {
                l=m+1;
            }
        }
        return r+1;
    }
}
