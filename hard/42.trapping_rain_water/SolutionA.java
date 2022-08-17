// https://leetcode.com/problems/trapping-rain-water/
// TC: O(n)
// SC: O(n)

class SolutionA {
    public int trap(int[] height) {
        Stack<Integer> st = new Stack<>();
        int result = 0;
        for(int i=0;i<height.length;i++) {
            while(!st.isEmpty() && height[i] > height[st.peek()]) {
                int top = st.pop();
                if(st.isEmpty()) {
                    break;
                }
                
                int dist = i - st.peek() - 1;
                int ht = Math.min(height[i], height[st.peek()]) - height[top];
                result += dist*ht;
            }
            st.push(i);
        }
        return result;
    }
}