// https://leetcode.com/problems/3sum-closest/

class SolutionA {
    public int threeSumClosest(int[] nums, int target) {
        Integer result = null;
        Arrays.sort(nums);
        for (int i=0;i<nums.length-2;i++) {
            int j=i+1,k=nums.length-1;
            while (j!=k) {
                int sum = nums[i]+nums[j]+nums[k];
                if (result == null) {
                    result = sum;
                } else {
                    result = Math.abs(target-result) < Math.abs(target-sum) ? result : sum;
                }
                if (sum>target) {
                    k--;
                } else {
                    j++;
                }
            }
        }

        return result;
    }
}
