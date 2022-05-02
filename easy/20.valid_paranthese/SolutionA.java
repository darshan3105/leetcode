// https://leetcode.com/problems/valid-parentheses/
// TC: O(n)
// SC: O(n)

class SolutionA {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for(int i=0;i<s.length();i++) {
            char ch = s.charAt(i);
            if(ch=='(' || ch == '{' || ch == '[') {
                stack.push(ch);
            }
            else {
                if(stack.isEmpty()) {
                    return false;
                }
                
                if(ch==')' && stack.peek()=='(') {
                    stack.pop();
                    continue;
                }
                else if(ch=='}' && stack.peek()=='{') {
                    stack.pop();
                    continue;
                }
                else if(ch==']' && stack.peek()=='[') {
                    stack.pop();
                    continue;
                }
                
                return false;
            }
        }
        
        if(stack.isEmpty()) {
            return true;
        }
        
        return false;
    }
}