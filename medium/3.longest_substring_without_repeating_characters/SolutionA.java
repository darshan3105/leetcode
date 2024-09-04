// https://leetcode.com/problems/longest-substring-without-repeating-characters/
// TC: O(n)
// SC: O(n)

class SolutionA {
    public int lengthOfLongestSubstring(String s) {
        int left=0, right=0, result=0;
        final Set<Character> set = new HashSet<>();

        while (right < s.length()) {
            char curr = s.charAt(right);
            while (left<=right && set.contains(curr)) {
                set.remove(s.charAt(left));
                left++;
            }
            result = Math.max(result, right-left+1);
            set.add(curr);
            right++;
        }

        return result;
    }
}
