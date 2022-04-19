// https://leetcode.com/problems/combinations/
// TC: O(n* n!/(n-k)!), O(n) is required to copy the elements of the array in the end
// SC: O(k) excluding the space required to strore the final result.

class SolutionA {
    
    List<List<Integer>> result = new ArrayList<>();
    
    public List<List<Integer>> combine(int n, int k) {
        List<Integer> curList = new ArrayList<>();
        calculate(n, k, 1, curList);
        return result;
    }
    
    private void calculate(int n, int k, int start, List<Integer> curList) {
        if(curList.size() == k) {
            result.add(new ArrayList<>(curList));
            return;
        }
        
        for(int i=start;i<=n;i++) {
            curList.add(i);
            calculate(n, k, i+1, curList);
            curList.remove(curList.size()-1);
        }
    }
}