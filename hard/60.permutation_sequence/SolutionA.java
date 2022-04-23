// https://leetcode.com/problems/permutation-sequence/
// TC: O(n^2)
// SC: O(n)

class SolutionA {
    public String getPermutation(int n, int k) {
        boolean vis[] = new boolean[n];
        k--;
        int curN = n-1;
        int factN = factorial(curN);
        StringBuilder builder = new StringBuilder();
        
        while(curN!=0) {
            int q = k/factN;
            int r = k%factN;
            builder.append(getDigit(vis, q));
            
            k = r;
            factN = factN/curN;
            curN--;
        }
        
        for(int i=0;i<n;i++) {
            if(!vis[i]) {
                builder.append((char)('0' + (i+1)));
                break;
            }
        }
        return builder.toString();
    }
    
    private char getDigit(boolean[] vis, int num) {
        int i=0;
        for(i=0;i<vis.length;i++) {
            if(!vis[i]) {
                if(num==0) {
                    break;
                }
                num--;
            }
        }
        vis[i] = true;
        return (char)('0' + (i+1));
    }
    
    private int factorial(int n) {
        int res = 1;
        while(n!=0) {
            res = res*n;
            n--;
        }
        return res;
    }
}