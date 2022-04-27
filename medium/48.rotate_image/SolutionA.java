// https://leetcode.com/problems/rotate-image/
// TC: O(n^2)
// SC: O(1) where n^2 is the size of the matrix

class SolutionA {
    public void rotate(int[][] matrix) {
        int len = matrix.length;
        for(int i=0;i<len;i++) {
            for(int j=i;j<len;j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        
        for(int i=0;i<len;i++) {
            reverse(matrix[i]);
        }
    }
    
    private void reverse(int[] arr) {
        int len = arr.length;
        for(int i=0;i<len/2;i++) {
            int temp = arr[i];
            arr[i] = arr[len-i-1];
            arr[len-i-1] = temp;
        }
    }
}