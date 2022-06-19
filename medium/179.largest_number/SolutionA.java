// https://leetcode.com/problems/largest-number/
// TC: O(nlogn)
// SC: O(n)

class SolutionA {
    public String largestNumber(int[] nums) {
        List<Integer> numbers = new ArrayList<>();
        for(int i=0;i<nums.length;i++) {
            numbers.add(nums[i]);
        }
        Collections.sort(numbers, (a, b) -> {
            String a_str = String.valueOf(a);
            String b_str = String.valueOf(b);
            
            String temp1 = a_str + b_str;
            String temp2 = b_str + a_str;
            return temp2.compareTo(temp1);
        });
        if(numbers.get(0) == 0) {
            return "0";
        }
        
        StringBuilder result = new StringBuilder();
        for(Integer num : numbers) {
            result.append(String.valueOf(num));
        }
        return result.toString();
    }
}