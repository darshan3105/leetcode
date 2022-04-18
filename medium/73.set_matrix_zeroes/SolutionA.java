// https://leetcode.com/problems/set-matrix-zeroes/
// TC: O(m*n)
// SC : O(m+n)
// where m = number of rows, n = number of cols

class Solution {
    public void setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        
        List<Integer> rows = new ArrayList<>();
        List<Integer> cols = new ArrayList<>();
        
        for(int i=0;i<m;i++) {
            for(int j=0;j<n;j++) {
                if(matrix[i][j] == 0) {
                    rows.add(i);
                    cols.add(j);
                }
            }
        }
        
        for(int row : rows) {
            for(int j=0;j<n;j++) {
                matrix[row][j] = 0;
            }
        }
        
        for(int col : cols) {
            for(int i=0;i<m;i++) {
                matrix[i][col] = 0;
            }
        }
    }
}