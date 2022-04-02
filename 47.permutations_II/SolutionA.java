// https://leetcode.com/problems/permutations-ii/
// TC: O(n!)
// SC: O(n) excluding the space needed for storing the result
// where n is the size of nums

class SolutionA {
    
    List<List<Integer>> result = new ArrayList<>();
    
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<Integer> curList = new ArrayList<>();
        boolean[] vis = new boolean[nums.length];
        calculate(nums, vis, curList);
        return result;
    }
    
    private void calculate(int[] nums, boolean[] vis, List<Integer> curList) {
        if(curList.size() == nums.length) {
            result.add(new ArrayList<>(curList));
        }
        else {
            boolean[] isUnique = new boolean[21];
            for(int i=0;i<21;i++) {
                isUnique[i] = true;
            }
            
            for(int i=0;i<nums.length;i++) {
                if(!vis[i] && isUnique[nums[i]+10]) {
                    isUnique[nums[i]+10] = false;
                    vis[i] = true;
                    curList.add(nums[i]);
                    
                    calculate(nums, vis, curList);
                    
                    curList.remove(curList.size()-1);
                    vis[i] = false;
                }
            }
        }
    }
}