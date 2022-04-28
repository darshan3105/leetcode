import java.util.Stack;

// https://leetcode.com/problems/largest-rectangle-in-histogram/
// TC: O(n)
// SC: O(n) where n is the length of heights array

class SolutionA {
    public int largestRectangleArea(int[] heights) {
        int len = heights.length;
        Stack<Integer> stack = new Stack<>();
        int maxArea = 0;
        for(int i=0;i<len;i++) {
            while(!stack.isEmpty() && heights[stack.peek()] > heights[i]) {
                int top = stack.pop();
                int prev = stack.isEmpty() ? -1 : stack.peek();
                maxArea = Math.max(maxArea, heights[top]*(i-prev-1));
            }
            stack.push(i);
        }
        
        while(!stack.isEmpty()) {
            int top = stack.pop();
            int prev = stack.isEmpty() ? -1 : stack.peek();
            maxArea = Math.max(maxArea, heights[top]*(len-prev-1));
        }
        
        return maxArea;
    }
}