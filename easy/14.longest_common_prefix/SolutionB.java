class SolutionB {
    public String longestCommonPrefix(String[] strs) {
        int[] ptrs = new int[strs.length];
        String result = "";
        boolean isComplete = false;
        while (isComplete) {
            for(int i=0;i<ptrs.length;i++) {
                if (ptrs[i] > strs[i].length()) {
                    isComplete = true;
                    break;
                }
            }

            for (int i=1;i<ptrs.length;i++) {
                if(strs[i].charAt(ptrs[i]) != strs[i-1].charAt(ptrs[i-1])) {
                    isComplete = true;
                    break;
                }
            }

            result += strs[0].charAt(ptrs[0]);

            for (int i=0;i<ptrs.length;i++) {
                ptrs[i]++;
            }
        }

        return result;
    }
}
