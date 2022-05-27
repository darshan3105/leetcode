// https://leetcode.com/problems/word-break-ii/

class SolutionA {
    public List<String> wordBreak(String s, List<String> wordDict) {
        Set<String> set = new HashSet<>(wordDict);
        List<String>[] dp = new ArrayList[s.length()];
        
        for(int i=0;i<s.length();i++) {
            dp[i] = new ArrayList<>();
        }
        
        for(int r=0;r<s.length();r++) {
            for(int l=r;l>=0;l--) {
                String rightStr = s.substring(l,r+1);
                if(set.contains(rightStr)) {
                    if(l==0) {
                        dp[r].add(rightStr);
                    }
                    else {
                        for(String str : dp[l-1]) {
                            dp[r].add(str + " " + rightStr);
                        }
                    }
                }
            }
        }
        
        return dp[s.length()-1];
    }
}