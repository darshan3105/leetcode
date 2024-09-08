// https://leetcode.com/problems/find-the-index-of-the-first-occurrence-in-a-string/
// TC: O(n * (h-n+1))
// SC: O(1)
// where h = length of haystack, n = length of needle

class SolutionA {
    public int strStr(String haystack, String needle) {
        final int h = haystack.length();
        final int n = needle.length();
        for (int i=0;i<h-n+1;i++) {
            if (isEqual(haystack, needle, i, i+n)) {
                return i;
            }
        }
        return -1;
    }

    private boolean isEqual(String haystack, String needle, int l, int r) {
        int j=0;
        for (int i=l;i<r;i++) {
            if (haystack.charAt(i) != needle.charAt(j)) {
                return false;
            }
            j++;
        }
        return true;
    }
}
