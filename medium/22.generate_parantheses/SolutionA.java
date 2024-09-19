// https://leetcode.com/problems/generate-parentheses/

class SolutionA {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        compute(n,n, "", result);
        return result;
    }

    private void compute(int open, int close, String curr, List<String> result) {
        if (open==0) {
            for (int i=0;i<close;i++) {
                curr+=')';
            }
            result.add(curr);
            return;
        }

        compute(open-1, close, curr+'(', result);
        if (close-1 >= open) {
            compute(open, close-1, curr+')', result);
        }
        
    }
}
