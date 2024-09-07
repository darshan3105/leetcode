class SolutionB {
    public int removeDuplicates(int[] nums) {
        if (nums.length==1) {
            return 1;
        }

        int swapPtr=0;
        for (int i=0;i<nums.length;i++) {
            if(nums[i] == nums[swapPtr]) {
                continue;
            }

            nums[swapPtr+1] = nums[i];
            swapPtr++;
        }

        return swapPtr+1;
    }
}
