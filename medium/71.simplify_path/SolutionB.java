// https://leetcode.com/problems/simplify-path/
// TC: O(n)
// SC: O(n)
// where n is the length of the path

class SolutionB {
    public String simplifyPath(String path) {
        Stack<String> s = new Stack<>();
        StringBuilder sb = new StringBuilder();
        String[] p = path.split("/");
        
        System.out.println(p.length);
        for(int i=0;i<p.length;i++) {
            System.out.println(p[i]);
        }
        
        for(int i=0;i<p.length;i++) {
            if(p[i].equals("..")) {
                if(!s.isEmpty()) {
                    s.pop();
                }     
            }
            else if(!p[i].equals(".") && !p[i].equals("")) {
                s.push(p[i]);
            }
        }
        
        List<String> resultList = new ArrayList<>();
        while(!s.isEmpty()) {
            resultList.add(s.pop());
        }
        
        for(int i=resultList.size()-1;i>=0;i--) {
            sb.append('/');
            sb.append(resultList.get(i));
        }
        
        if(sb.length()==0) {
            return  "/";
        }
        
        return sb.toString();
    }
}