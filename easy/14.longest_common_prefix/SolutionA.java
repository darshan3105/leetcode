// https://leetcode.com/problems/longest-common-prefix/

class SolutionA {
    public String longestCommonPrefix(String[] strs) {
        int n = strs.length;
        int[] ptr = new int[n];
        for(int i=0;i<n;i++) {
            ptr[i] = 0;
        }
        StringBuilder builder = new StringBuilder();
        while(canContinue(strs, ptr)) {
            char ch = strs[0].charAt(ptr[0]);
            for(int i=0;i<n;i++) {
                if(strs[i].charAt(ptr[i])!=ch) {
                    return builder.toString();
                }
            }
            for(int i=0;i<n;i++) {
                ptr[i]++;
            }
            builder.append(ch);
        }
        return builder.toString();
    }
    
    private boolean canContinue(String[] strs, int[] ptr) {
        for(int i=0;i<strs.length;i++) {
            if(ptr[i]==strs[i].length()) {
                return false;
            }
        }
        return true;
    }
}