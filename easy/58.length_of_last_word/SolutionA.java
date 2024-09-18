// https://leetcode.com/problems/length-of-last-word/
// TC: O(n)
// SC: O(1)

class SolutionA {
    public int lengthOfLastWord(String s) {
        int result = 0, i=s.length()-1;
        while(i>=0) {
            while (result==0 && i>=0 && s.charAt(i)==' ') {
                i--;
            }

            if (s.charAt(i) == ' ') {
                break;
            }

            result++;
            i--;
        }

        return result;
    }
}
