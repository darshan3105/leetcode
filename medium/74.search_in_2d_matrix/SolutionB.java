// https://leetcode.com/problems/search-a-2d-matrix/
// TC: O(m*log(n))
// SC: O(1)

class SolutionB {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        for(int i=0;i<m;i++) {
            if(target>=matrix[i][0] && target<=matrix[i][n-1]) {
                return isPresent(matrix[i], target);
            }
        }
        return false;
    }
    
    private boolean isPresent(int[] arr, int target) {
        int l=0, r=arr.length-1;
        while(l<=r) {
            int m = (l+r)/2;
            if(arr[m]==target) {
                return true;
            }
            else if(arr[m]>target) {
                r=m-1;
            }
            else {
                l=m+1;
            }
        }
        return false;
    }
}