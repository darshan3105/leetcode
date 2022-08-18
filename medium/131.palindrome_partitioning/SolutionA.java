// https://leetcode.com/problems/palindrome-partitioning/
// TC: O(2^n)
// SC: O(n^2)

class SolutionA {
    
    List<List<String>> result = new ArrayList<>();
    
    public List<List<String>> partition(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        for(int i=0;i<n;i++) {
            dp[i][i] = true;
        }
        
        for(int len=2;len<=n;len++) {
            for(int i=0;i<n-len+1;i++) {
                int j = i+len-1;
                if(s.charAt(i) == s.charAt(j) && isPalin(dp, i+1, j-1)) {
                    dp[i][j] = true;
                }
            }
        }
        
        find(0, s, new ArrayList<>(), dp);
        return result;
    }
    
    private void find(int start, String s, List<String> cur, boolean[][] dp) {
        if(start==s.length()) {
            result.add(new ArrayList<>(cur));
            return;
        }
        
        String str = "";
        for(int i=start;i<s.length();i++) {
            str+=s.charAt(i);
            if(dp[start][i]) {
                cur.add(str);
                find(i+1, s, cur, dp);
                cur.remove(cur.size()-1);
            }
        }
    }
    
    private boolean isPalin(boolean[][] dp, int i, int j) {
        if(i>j) {
            return true;
        }
        
        return dp[i][j];
    }
}