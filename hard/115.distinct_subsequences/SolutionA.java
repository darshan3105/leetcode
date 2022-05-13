//https://leetcode.com/problems/distinct-subsequences/

class SolutionA {
        
    int solve(char[] s, char[] t, int ptr1, int ptr2, int[][] dp) {
        if(ptr2==t.length) {
            return 1;
        }
        if(ptr1==s.length) {
            return 0;
        }
        if(dp[ptr1][ptr2]!=-1) {
            return dp[ptr1][ptr2];
        }
        
        int sum = 0;
        int first = ptr1;
        while(ptr1<s.length) {
            if(s[ptr1] == t[ptr2]) {
                sum += solve(s, t, ptr1+1, ptr2+1, dp);
            }
            ptr1++;
        }
        
        dp[first][ptr2] = sum;
        return sum;
    }
    
    public int numDistinct(String s_string, String t_string) {
        char[] s = s_string.toCharArray();
        char[] t = t_string.toCharArray();
        
        int[][] dp = new int[s.length][t.length];
        for(int i=0;i<s.length;i++) {
            for(int j=0;j<t.length;j++) {
                dp[i][j] = -1;
            }
        }
        
        solve(s, t, 0, 0, dp);
        return dp[0][0];
    }
}