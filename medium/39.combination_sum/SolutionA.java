// https://leetcode.com/problems/combination-sum/
// TC: O(2^n)
// SC: O(n * number of combinations)
// where ne is the length of candidates array

class SolutionA {
    
    List<List<Integer>> result = new ArrayList<>();
    
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<Integer> curList = new ArrayList<>();
        calculate(candidates, target, 0, 0, curList);
        return result;
    }
    
    private void calculate(int[] candidates, int target, int curSum, int start, List<Integer> curList) {
        if(curSum > target) {
            return;
        }
        else if(curSum == target) {
            List<Integer> copyOfCurList = new ArrayList<>(curList);
            result.add(copyOfCurList);
            return;
        }
        
        for(int i=start;i<candidates.length;i++) {
            curList.add(candidates[i]);
            curSum += candidates[i];
            calculate(candidates, target, curSum, i, curList);
            curList.remove(curList.size()-1);
            curSum -= candidates[i];
        }
    }
}