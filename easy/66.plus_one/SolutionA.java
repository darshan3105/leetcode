// https://leetcode.com/problems/plus-one/

class SolutionA {
    public int[] plusOne(int[] digits) {
        int carry = 0;
        for (int i=digits.length-1;i>=0;i--) {
            int sum = i==digits.length-1 ? digits[i] + 1 + carry : digits[i] + carry;
            digits[i] = sum%10;
            carry = sum/10;
        }

        int carryLen=0, temp=carry;
        while(temp!=0) {
            temp=temp/10;
            carryLen++;
        }

        int[] result = new int[carryLen + digits.length];
        int ptr = result.length-1;
        for (int i=digits.length-1;i>=0;i--) {
            result[ptr] = digits[i];
            ptr--;
        }

        while(carry!=0) {
            int rem = carry%10;
            carry = carry/10;
            result[ptr] = rem;
            ptr--;
        }

        return result;
    }
}
