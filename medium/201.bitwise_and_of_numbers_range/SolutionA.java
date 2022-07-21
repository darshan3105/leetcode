// https://leetcode.com/problems/bitwise-and-of-numbers-range/
// TC: O(log(min(left, right)))
// SC: O(1)

class SolutionA {
    public int rangeBitwiseAnd(int left, int right) {
        int result = 0, cnt=0, power=1;
        int num1=left, num2=right;
        while(left!=0 && right!=0) {
            int r1 = left%2;
            int r2 = right%2;
            if(r1==1 && r2==1) {
                if(Math.abs(num1-num2)+1<=power) {
                    result+=Math.pow(2, cnt);
                }
            }
            
            cnt++;
            power*=2;
            left = left/2;
            right = right/2;
        }
        
        return result;
    }
}