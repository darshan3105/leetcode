// https://leetcode.com/problems/evaluate-reverse-polish-notation/
// TC: O(n)
// SC: O(n)

class SolutionA {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for(int i=0;i<tokens.length;i++) {
            if(isOperator(tokens[i])) {
                int op2 = stack.pop();
                int op1 = stack.pop();
                
                int val = 0;
                if(tokens[i].equals("+")) {
                    val=op1+op2;
                }
                else if(tokens[i].equals("-")) {
                    val=op1-op2;
                }
                else if(tokens[i].equals("*")) {
                    val=op1*op2;
                }
                else if(tokens[i].equals("/")) {
                    val=op1/op2;
                }
                stack.push(val);
            }
            else {
                int val = Integer.parseInt(tokens[i]);
                stack.push(val);
            }
        }
        return stack.pop();
    }
    
    private boolean isOperator(String s) {
        return s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/");
    }
}