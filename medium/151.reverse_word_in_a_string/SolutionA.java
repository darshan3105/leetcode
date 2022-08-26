// https://leetcode.com/problems/reverse-words-in-a-string/
// TC: O(n)
// SC: O(n)

class SolutionA {
    public String reverseWords(String s) {
        String[] tokens = s.strip().split(" ");
        StringBuilder builder = new StringBuilder();
        for(int i=tokens.length-1;i>=0;i--) {
            if(!tokens[i].equals(" ") && !tokens[i].equals("")) {
                builder.append(tokens[i]);
                builder.append(" ");
            }
        }
        String result = builder.toString();
        return result.substring(0, result.length()-1);
    }
}