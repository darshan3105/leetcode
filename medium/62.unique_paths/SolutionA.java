// https://leetcode.com/problems/unique-paths/
// TC: O(m*n)
// SC: O(n)

class SolutionA {
    public int uniquePaths(int m, int n) {
        if(m==1) {
            return 1;
        }
        
        int[] above = new int[n];
        int[] below = new int[n];
        
        for(int i=0;i<n;i++) {
            above[i] = 1;
        }
        
        for(int i=1;i<m;i++) {
            below[0] = 1;
            for(int j=1;j<n;j++) {
                below[j] = above[j] + below[j-1];
            }
            for(int j=0;j<n;j++) {
                above[j] = below[j];
            }
        }
        
        return below[n-1];
    }
}