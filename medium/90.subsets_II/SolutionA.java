// https://leetcode.com/problems/subsets-ii/
// TC: O(2^n * n) 2^n subsets and n for copying the list into result
// SC: O(2^n)

class SolutionA {
    
    List<List<Integer>> result = new ArrayList<>();
    
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        for(int i=0;i<=nums.length;i++) {
            List<Integer> curList = new ArrayList<>();
            calculate(nums, i, 0, curList);
        }
        return result;
    }
    
    private void calculate(int[] nums, int size, int start, List<Integer> curList) {
        if(curList.size() == size) {
            result.add(new ArrayList<>(curList));
            return;
        }
        
        for(int i=start;i<nums.length;i++) {
            if(i!=start && nums[i] == nums[i-1]) {
                continue;
            }
            
            curList.add(nums[i]);
            calculate(nums, size, i+1, curList);
            curList.remove(curList.size()-1);
        }
    }
}