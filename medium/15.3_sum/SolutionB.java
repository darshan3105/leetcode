// https://leetcode.com/problems/3sum/
// TC: O(n^2)
// SC: O(n)

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        for(int i=0;i<nums.length-1;i++) {
            if(i!=0 && nums[i]==nums[i-1]) {
                continue;
            }
            
            List<List<Integer>> list = getTwoSum(nums, i+1, -nums[i]);
            if(list.size() != 0) {
                for(List<Integer> l : list)  {
                    l.add(nums[i]);
                }
                result.addAll(list);
            } 
        }
        return result;
    }
    
    private List<List<Integer>> getTwoSum(int[] nums, int start, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Map<Integer, Integer> vis = new HashMap<>();
        Set<Integer> set = new HashSet<>();
        set.add(nums[start]);
        
        for(int i=start+1;i<nums.length;i++) {
            if(set.contains(target-nums[i]) && !isPresent(vis, nums[i], target-nums[i])) {
                List<Integer> cur = new ArrayList<>();
                cur.add(nums[i]);
                cur.add(target-nums[i]);
                
                result.add(cur);
                vis.put(Math.min(nums[i], target-nums[i]), Math.max(nums[i], target-nums[i]));
            }
            set.add(nums[i]);
        }
        return result;
    }
    
    private boolean isPresent(Map<Integer, Integer> mp, int num1, int num2) {
        int n1 = Math.min(num1, num2);
        int n2 = Math.max(num1, num2);
        
        return mp.containsKey(n1) && mp.get(n1) == n2;
    }
}