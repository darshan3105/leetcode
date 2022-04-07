// https://leetcode.com/problems/simplify-path/
// TC: O(n)
// SC: O(n)
// where n is the length of the path

class SolutionA {
    public String simplifyPath(String path) {
        char[] arr = path.toCharArray();
        Stack<Character> s = new Stack<>();
        int i=0;
        
        while(i<arr.length) {
            if(arr[i]=='/') {
                if(s.isEmpty() || s.peek()!='/') {
                    s.push(arr[i]);
                }
                i++;
            }
            else if(arr[i] == '.') {
                if(!s.isEmpty() && s.peek() == '/') {
                    int dots = 0;
                    while(i<arr.length && arr[i]=='.') {
                        s.push(arr[i]);
                        dots++;
                        i++;
                    }
                    if(i==arr.length || arr[i] == '/') {
                        if(dots==1) {
                            s.pop();
                        }
                        else if(dots==2) {
                            s.pop();s.pop();s.pop();
                            while(!s.isEmpty() && s.peek()!='/') {
                                s.pop();
                            }
                        }
                    }
                }
                else {
                    s.push(arr[i]);
                    i++;
                }
                
            }
            else {
                s.push(arr[i]);
                i++;
            }
        }
        
        StringBuilder sb = new StringBuilder();
        while(!s.isEmpty()) {
            sb.append(s.pop());
        }
        
        if(sb.length()==0) {
            return "/";
        }
        
        sb.reverse();
        String result = sb.toString();
        if(result.length() > 1 && result.charAt(result.length()-1) == '/') {
            return result.substring(0, result.length()-1);
        }
        
        return result;
    }
}