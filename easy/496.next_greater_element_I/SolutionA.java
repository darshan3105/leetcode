// https://leetcode.com/problems/next-greater-element-i/
// TC: O(n1 + n2)
// SC: O(n2) where n1 = length of nums1, n2 = length of nums2

class SolutionA {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] geOf = new int[10001];
        Stack<Integer> stack = new Stack<>();
        
        for(int i=0;i<nums2.length;i++) {
            while(!stack.isEmpty() && nums2[i] > stack.peek()) {
                int top = stack.pop();
                geOf[top] = nums2[i];
            }
            stack.push(nums2[i]);
        }
        
        while(!stack.isEmpty()) {
            int top = stack.pop();
            geOf[top] = -1;
        }
        
        for(int i=0;i<nums1.length;i++) {
            nums1[i] = geOf[nums1[i]];
        }
        
        return nums1;
    }
}