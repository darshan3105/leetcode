// https://leetcode.com/problems/edit-distance/
// TC: O(len1*len2)
// SC: O(len1*len2)

class SolutionA {
    public int minDistance(String word1, String word2) {
        int len1 = word1.length();
        int len2 = word2.length();
        
        int[][] dp = new int[len2+1][len1+1];
        for(int i=0;i<len2+1;i++) {
            dp[i][0] = i;
        }
        for(int j=0;j<len1+1;j++) {
            dp[0][j] = j;
        }
        
        for(int i=1;i<len2+1;i++) {
            for(int j=1;j<len1+1;j++) {
                if(word2.charAt(i-1) == word1.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1];
                }
                else {
                    dp[i][j] = 1+Math.min(dp[i][j-1], Math.min(dp[i-1][j-1], dp[i-1][j]));
                }
            }
        }
        
        return dp[len2][len1];
    }
}