// https://leetcode.com/problems/two-sum/
// TC: O(n)
// SC: O(n)

class SolutionA {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> mp = new HashMap<>();
        int[] result = new int[2];
        for(int i=0;i<nums.length;i++) {
            if(mp.containsKey(target-nums[i])) {
                result[0] = i;
                result[1] = mp.get(target-nums[i]);
                break;
            }
            mp.put(nums[i], i);
        }
        return result;
    }
}