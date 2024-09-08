// https://leetcode.com/problems/string-to-integer-atoi/

class SolutionA {
    public int myAtoi(String s) {
        int result=0, mult=1;
        boolean gotChar = false;
        for(int i=0;i<s.length();i++) {
            final char ch = s.charAt(i);
            if (ch==' ' && !gotChar) {
                continue;
            }

            if(!isDigit(ch)) {
                if ((ch=='-' || ch=='+') && !gotChar) {
                    mult = ch=='-' ? -1 : 1;
                    gotChar = true;
                    continue;
                }
                break;
            }

            gotChar = true;
            int num = mult * (int)(ch - '0');
            if (result > Integer.MAX_VALUE/10 || (result==Integer.MAX_VALUE/10 && num>7)) {
                result = Integer.MAX_VALUE;
                break;
            }

            if (result < Integer.MIN_VALUE/10 || (result==Integer.MIN_VALUE/10 && num<-8)) {
                result = Integer.MIN_VALUE;
                break;
            }

            result = result*10 + num;
        }

        return result;
    }

    private boolean isDigit(char ch) {
        return ch>='0' && ch<='9';
    }
}
