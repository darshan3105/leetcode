// https://leetcode.com/problems/longest-substring-without-repeating-characters/
// TC: O(n)
// SC: O(n)

class SolutionA {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        int l=0,r=0,result=0;
        while(r<s.length()) {
            char ch = s.charAt(r);
            if(!set.contains(ch)) {
                set.add(ch);
                result = Math.max(result, r-l+1);
            }
            else {
                while(l<r && s.charAt(l)!=ch) {
                    set.remove(s.charAt(l));
                    l++;
                }
                l++;
            }
            r++;
        }
        result = Math.max(result, r-l);
        return result;
    }
}