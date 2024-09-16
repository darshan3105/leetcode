// https://leetcode.com/problems/container-with-most-water/
// TC: O(n)
// SC: O(1)

class Solution {
    public int maxArea(int[] height) {
        int l=0, r=height.length-1;
        int result = 0;
        while(r!=l) {
            result = Math.max(result, Math.min(height[l], height[r]) * (r-l));
            if (height[l]<height[r]) {
                l++;
            } else {
                r--;
            }
        }
        return result;
    }
}
