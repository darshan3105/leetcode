class SolutionA {
    public boolean isPalindrome(int x) {
        if (x<0) {
            return false;
        }

        int initial_num = x;
        int final_num = 0;
        int multiplier = 10;
        while (x!=0) {
            int rem = x%10;
            x = x/10;
            final_num = final_num * multiplier + rem;
        }

        return initial_num == final_num;
    }
}
