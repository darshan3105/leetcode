// https://leetcode.com/problems/search-a-2d-matrix/
// TC: O(logm) + O(logn)
// SC: O(1)

class SolutionA {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        int l=0,r=m-1,mid;
        int targetRow = -1;
        
        while(l<=r) {
            mid = (l+r)/2;
            if(target>=matrix[mid][0] && target<=matrix[mid][n-1]) {
                targetRow = mid;
                break;
            }
            else if(target<matrix[mid][0]) {
                r=mid-1;
            }
            else {
                l=mid+1;
            }
        }
        
        if(targetRow==-1) {
            return false;
        }
        
        return isPresentInRow(matrix[targetRow], target);
    }
    
    private boolean isPresentInRow(int[] arr, int target) {
        int n = arr.length;
        int l=0,r=n-1,mid;
        
        while(l<=r) {
            mid = (l+r)/2;
            if(arr[mid] == target) {
                return true;
            }
            else if(arr[mid] > target) {
                r=mid-1;
            }
            else {
                l=mid+1;
            }
        }
        return false;
    }
}