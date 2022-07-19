// https://leetcode.com/problems/factorial-trailing-zeroes/
// TC: O(n*(log2(n)+log5(n)))
// SC: O(1)

class SolutionA {
    public int trailingZeroes(int n) {
        int fives=0, twos=0;
        for(int i=n;i>=0;i--) {
            fives+=func(i, 5);
            twos+=func(i, 2);
        }
        return Math.min(fives, twos);
    }
    
    private int func(int n, int div) {
        int rem=0, cnt=0;
        while(n>0 && rem==0) {
            rem=n%div;
            n=n/div;
            if(rem==0) {
                cnt++;
            }
        }
        return cnt;
    }
}