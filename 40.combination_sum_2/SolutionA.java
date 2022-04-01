// https://leetcode.com/problems/combination-sum-ii/
// TC: O(2^n)
// SC: O(n) (not considering the space required to hold the result)
// where n is the size of candidates array

class Solution {
    
    List<List<Integer>> result = new ArrayList<>();
    
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<Integer> curList = new ArrayList<>();
        calculate(candidates, target, 0, curList, 0);
        return result;
    }
    
    private void calculate(int[] nums, int target, int curSum, List<Integer> curList, int start) {
        if(curSum > target) {
            return;
        }
        else if(curSum == target) {
            result.add(new ArrayList<>(curList));
        }
        else {
            for(int i=start;i<nums.length;i++) {
                if(i > start && nums[i] == nums[i-1]) {
                    continue;
                }
                
                curList.add(nums[i]);
                curSum += nums[i];
                calculate(nums, target, curSum, curList, i+1);
                curSum -= nums[i];
                curList.remove(curList.size()-1);
            }
        }
    }
}