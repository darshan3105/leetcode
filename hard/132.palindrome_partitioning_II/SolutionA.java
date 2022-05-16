// https://leetcode.com/problems/palindrome-partitioning-ii/
// TC: O(n^2)
// SC: O(n^2)

class SolutionA {
    public int minCut(String s) {
        int n = s.length();
        boolean[][] isPalin = new boolean[n][n];
        for(int i=0;i<n;i++) {
            isPalin[i][i] = true;
        }
        
        for(int len=2;len<=n;len++) {
            for(int i=0;i<n-len+1;i++) {
                int j = i+len-1;
                if(s.charAt(i) == s.charAt(j)) {
                    isPalin[i][j] = i+1>j-1 || isPalin[i+1][j-1];
                }
            }
        } 
        
        int[] cuts = new int[n];
        for(int i=0;i<n;i++) {
            cuts[i] = Integer.MAX_VALUE;
        }
        for(int r=0;r<n;r++) {
            for(int l=r;l>=0;l--) {
                if(l==0) {
                    if(isPalin[l][r]) {
                        cuts[r] = 0;
                    }
                }
                else {
                    if(isPalin[l][r]) {
                        cuts[r] = Math.min(cuts[r], 1+cuts[l-1]);
                    }
                }
            }
        }
        return cuts[n-1];
    }
}