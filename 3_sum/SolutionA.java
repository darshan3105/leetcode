// https://leetcode.com/problems/3sum/
// TC: O(n^2)
// SC: O(n)
// where n is the size of nums

class SolutionA {
    public List<List<Integer>> threeSum(int[] nums) {
        if(nums.length < 3) {
            return Collections.emptyList();
        }
        
        Arrays.sort(nums);
        Map<Integer, Integer> numToIndex = new HashMap<>();
        for(int i=0;i<nums.length;i++) {
            numToIndex.put(nums[i], i);
        }
        
        List<List<Integer>> result = new ArrayList<>();
        Integer prevNum1 = null;
        
        for(int i=0;i<nums.length-1;i++) {
            if(prevNum1!=null && nums[i] == prevNum1) {
                continue;
            }
            
            Integer prevNum2 = null;
            for(int j=i+1;j<nums.length;j++) {
                if(prevNum2!=null && nums[j] == prevNum2) {
                    continue;
                }
                
                int sum = nums[i]+nums[j];
                
                if(numToIndex.containsKey(-sum)) {
                    int num3Index = numToIndex.get(-sum);
                    if(num3Index > j) {
                        List<Integer> cur = new ArrayList<>();
                        cur.add(nums[i]);
                        cur.add(nums[j]);
                        cur.add(-sum);
                        
                        result.add(cur);
                    }
                }
                
                prevNum2 = nums[j];
            }
            
            prevNum1 = nums[i];
        }
        
        return result;
    }
}