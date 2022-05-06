// https://leetcode.com/problems/kth-largest-element-in-a-stream/

class KthLargest {
    
    Queue<Integer> minHeap;
    Queue<Integer> maxHeap;
    int k;

    public KthLargest(int k, int[] nums) {
        minHeap = new PriorityQueue<>();
        maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        this.k = k;
        
        for(int i=0;i<nums.length;i++) {
            minHeap.add(nums[i]);
            if(minHeap.size()>k) {
                maxHeap.add(minHeap.poll());
            }
        }
    }
    
    public int add(int val) {
        maxHeap.add(val);
        int max = maxHeap.peek();
        int min = minHeap.isEmpty() ? Integer.MAX_VALUE : minHeap.peek();
        if(max > min) {
            minHeap.add(maxHeap.poll());
            maxHeap.add(minHeap.poll());
        }
        
        while(minHeap.size()<k) {
            minHeap.add(maxHeap.poll());
        }
        
        return minHeap.peek();
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */