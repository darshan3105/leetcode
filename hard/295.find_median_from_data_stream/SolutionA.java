// https://leetcode.com/problems/find-median-from-data-stream/
// TC: addNum: O(logn), findMedian: O(1)
// SC: O(n)

class MedianFinder {
    
    Queue<Integer> minHeap;
    Queue<Integer> maxHeap;

    public MedianFinder() {
        minHeap = new PriorityQueue<>();
        maxHeap = new PriorityQueue<>(Collections.reverseOrder());
    }
    
    public void addNum(int num) {
        maxHeap.add(num);
        int max = maxHeap.isEmpty() ? Integer.MIN_VALUE : maxHeap.peek();
        int min = minHeap.isEmpty() ? Integer.MAX_VALUE : minHeap.peek();
        if(max > min) {
            minHeap.add(maxHeap.poll());
            maxHeap.add(minHeap.poll());
        }
        if(maxHeap.size() == minHeap.size()+2) {
            minHeap.add(maxHeap.poll());
        }
    }
    
    public double findMedian() {
        int size = minHeap.size() + maxHeap.size();
        if(size%2==0) {
            return (double)(maxHeap.peek() + minHeap.peek())/2;
        }
        else {
            return maxHeap.peek();
        }
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */