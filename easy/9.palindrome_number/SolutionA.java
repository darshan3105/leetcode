class SolutionA {
    public boolean isPalindrome(int x) {
        if (x<0) {
            return false;
        }

        int initial_num = x;
        int final_num = 0;
        while (x!=0) {
            int rem = x%10;
            x = x/10;
            final_num = final_num * 10 + rem;
        }

        return initial_num == final_num;
    }
}
