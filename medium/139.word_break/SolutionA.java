// https://leetcode.com/problems/word-break/
// TC: O(n^3)
// SC: O(len(wordDict)) where n is the length of the string

class SolutionA {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> set = new HashSet<>(wordDict);
        boolean dp[] = new boolean[s.length()];
        
        for(int i=0;i<s.length();i++) {
            for(int j=i;j>=0;j--) {
                String cur = s.substring(j,i+1);
                if(j==0) {
                    if(set.contains(cur)) {
                        dp[i] = true;
                        break;
                    }
                }
                else {
                    if(set.contains(cur) && dp[j-1]) {
                        dp[i] = true;
                        break;
                    }
                }
            }
        }
        return dp[s.length()-1];
    }
}