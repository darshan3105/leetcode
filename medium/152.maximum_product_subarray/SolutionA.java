class SolutionA {
    public int maxProduct(int[] nums) {
        int maxLeft = Integer.MIN_VALUE;
        int maxRight = Integer.MIN_VALUE;
        int curMax = 1;
        for(int i=0;i<nums.length;i++) {
            curMax*=nums[i];
            maxLeft = Math.max(maxLeft, curMax);
            if(curMax==0) {
                curMax = 1;
            }
        }
        curMax=1;
        for(int i=nums.length-1;i>=0;i--) {
            curMax*=nums[i];
            maxRight = Math.max(maxRight, curMax);
            if(curMax==0) {
                curMax = 1;
            }
        }
        return Math.max(maxLeft, maxRight);
    }
}