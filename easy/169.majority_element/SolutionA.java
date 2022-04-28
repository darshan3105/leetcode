// https://leetcode.com/problems/majority-element/
// TC: O(n)
// SC: O(1)

class SolutionA {
    public int majorityElement(int[] nums) {
        int count=0;
        int ele=-1;
        for(int i=0;i<nums.length;i++) {
            if(count==0) {
                ele=nums[i];
            }
            if(ele==nums[i]) {
                count++;
            }
            else {
                count--;
            }
        }
        
        return ele;
    }
}