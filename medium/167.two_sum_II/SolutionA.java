// https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/
// TC: O(nlogn)
// SC: O(1)

class SolutionA {
    public int[] twoSum(int[] numbers, int target) {
        for(int i=0;i<numbers.length;i++) {
            int left = find(numbers, 0, i-1, target-numbers[i]);
            int right = find(numbers, i+1, numbers.length-1, target-numbers[i]);
            if(left!=-1) {
                return new int[]{left+1, i+1};
            }
            else if(right!=-1) {
                return new int[]{i+1, right+1};
            }
        }
        return null;
    }
    
    private int find(int nums[], int low, int high, int target) {
        while(low<=high) {
            int mid = (low+high)/2;
            if(nums[mid]==target) {
                return mid;
            }
            else if(nums[mid]<target) {
                low=mid+1;
            }
            else {
                high=mid-1;
            }
        }
        return -1;
    }
}