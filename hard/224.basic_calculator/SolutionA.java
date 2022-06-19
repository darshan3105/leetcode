// https://leetcode.com/problems/basic-calculator/
// TC: O(n)
// SC: O(n)

class SolutionA {
    public int calculate(String s) {
        s=s.replaceAll(" ", "");
        char[] arr = s.toCharArray();
        Stack<Integer> nums = new Stack<>();
        Stack<Character> ops = new Stack<>();
        int result=0;
        
        if(arr[0]=='(') {
            ops.push('+');
        }
        
        int i=0;
        while(i<arr.length) {
            if(isDigit(arr[i])) {
                if(i==0 || arr[i-1]=='(') {
                    ops.push('+');
                }
                int curNum=0;
                while(i<arr.length && isDigit(arr[i])) {
                    curNum=curNum*10 + (arr[i]-'0');
                    i++;
                }
                nums.push(curNum);
            }    
            else if(arr[i]==')') {
                int temp=0;
                while(ops.peek()!='(') {
                    char op = ops.pop();
                    int n = nums.pop();
                    if(op == '+') {
                        temp+=n;
                    }
                    else {
                        temp-=n;
                    }
                }
                nums.push(temp);
                ops.pop();
                i++;
            }
            else {
                ops.push(arr[i]);
                i++;
            }
            
        }
        
        while(!ops.isEmpty()) {
            char op = ops.pop();
            int n = nums.pop();
            if(op == '+') {
                result+=n;
            }
            else {
                result-=n;
            }
        }
        return result;
    }
    
    private boolean isDigit(char ch) {
        return ch>='0' && ch<='9';
    }
}