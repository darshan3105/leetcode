// https://leetcode.com/problems/sliding-window-maximum/
// TC: O(n)
// SC: O(n)

class SolutionA {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> q = new LinkedList<>();
        k--;
        int[] result = new int[nums.length-k];
        int ptr=0;
        for(int i=0;i<nums.length;i++) {
            while(!q.isEmpty() && q.peek() < i-k) {
                q.poll();
            }
            
            while(!q.isEmpty() && nums[q.peekLast()] < nums[i]) {
                q.pollLast();
            }
            q.add(i);
            if(i>=k) {
                result[ptr++] = nums[q.peek()];
            }
        }
        return result;
    }
}