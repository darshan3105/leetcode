// https://leetcode.com/problems/shortest-palindrome/
// TC: O(n)
// SC: O(n)

class SolutionA {
    public String shortestPalindrome(String s) {
        StringBuilder str = new StringBuilder(s);
        StringBuilder rev = new StringBuilder(s);
        rev.reverse();
        String t = str.toString() + "#" + rev.toString();
        int[] dp = new int[t.length()];
        dp[0]=0;
        int i=0,j=1;
        while(j<t.length()) {
            while(t.charAt(i)!=t.charAt(j) && i!=0) {
                i=dp[i-1];
            }
            if(t.charAt(i)==t.charAt(j)) {
                dp[j]=i+1;
                i++;
                j++;
            }
            else {
                dp[j]=0;
                j++;
            }
        }
        
        if(dp[t.length()-1]==s.length()) {
            return s;
        }
        else {
            StringBuilder prefix = new StringBuilder(s.substring(dp[t.length()-1], s.length()));
            prefix.reverse();
            return prefix.toString() + s;
        }
    }
}