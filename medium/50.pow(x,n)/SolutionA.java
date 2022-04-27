// https://leetcode.com/problems/powx-n/
// TC: O(logn)
// SC: O(1)

class SolutionA {
    public double myPow(double x, long n) {
        if(n<0) {
            return myPow(1/x, -n);
        }
        if(n==0) {
            return 1;
        }
        else if(n==1) {
            return x;
        }
        else {
            double res = myPow(x, n/2);
            if(n%2==0) {
                return res*res;
            }
            else {
                return res*res*x;
            }
        }        
    }
}