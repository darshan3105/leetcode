// https://leetcode.com/problems/subsets/
// TC: O(n*2^n) where 2^n are the number of subsets and n required to copy them in the result list
// SC: O(n) excluding the space required to store the result

class SolutionA {

    List<List<Integer>> result  = new ArrayList<>();
    
    public List<List<Integer>> subsets(int[] nums) {
        int n = nums.length;
        for(int i=0;i<=n;i++) {
            List<Integer> curList = new ArrayList<>();
            calculate(nums, i, 0, curList);
        }
        
        return result;
    }
    
    private void calculate(int[] nums, int n, int start, List<Integer> curList) {
        if(curList.size() == n) {
            result.add(new ArrayList<>(curList));
            return;
        }
        
        for(int i=start;i<nums.length;i++) {
            curList.add(nums[i]);
            calculate(nums, n, i+1, curList);
            curList.remove(curList.size()-1);
        }
    }
}