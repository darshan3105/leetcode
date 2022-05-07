// https://leetcode.com/problems/longest-consecutive-sequence/
// TC: O(n)
// SC: O(n)

class SolutionA {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int result = 0;
        for(int i=0;i<nums.length;i++) {
            set.add(nums[i]);
        }
        
        for(int i=0;i<nums.length;i++) {
            if(set.contains(nums[i]-1)) {
                continue;
            }
            
            int temp = nums[i];
            int cnt = 0;
            while(set.contains(temp)) {
                cnt++;
                temp++;
            }
            
            result = Math.max(result, cnt);
        }
        
        return result;
    }
}