// https://leetcode.com/problems/maximum-gap/
// TC: O(n)
// SC: O(n)

class SolutionA {
    public int maximumGap(int[] nums) {
        int len = nums.length;
        if(len==1) {
            return 0;
        }
        
        int[][] buckets = new int[len-1][2];
        for(int i=0;i<len-1;i++) {
            buckets[i][0] = -1;
            buckets[i][1] = -1;
        }
        int min=nums[0], max=nums[0];
        for(int i=0;i<len;i++) {
            min = Math.min(min, nums[i]);
            max = Math.max(max, nums[i]);
        }
        
        int bucketSize = (int)Math.ceil((double)(max-min)/(len-1));
        
        for(int i=0;i<len;i++) {
            if(nums[i]==min || nums[i]==max) {
                continue;
            }
            int bucket = (nums[i]-min)/bucketSize;
            update(buckets, bucket, nums[i]);
        }
        
        List<int[]> bucks = new ArrayList<>();
        for(int i=0;i<len-1;i++) {
            if(buckets[i][0]!=-1) {
                bucks.add(new int[]{buckets[i][0], buckets[i][1]});
            }
        }
        
        if(bucks.size()==0) {
            return max-min;
        }
        
        int result = Math.max(bucks.get(0)[0]-min, max-bucks.get(bucks.size()-1)[1]);
        for(int i=1;i<bucks.size();i++) {
            result = Math.max(result, bucks.get(i)[0] - bucks.get(i-1)[1]);
        }
        
        return result;
    }
    
    private void update(int[][] buckets, int index, int num) {
        if(buckets[index][0]==-1) {
            buckets[index][0] = buckets[index][1] = num;
        }
        else {
            if(num < buckets[index][0]) {
                buckets[index][0] = num;   
            }
            else if(num>buckets[index][1]) {
                buckets[index][1] = num;
            }
        }
    }
}