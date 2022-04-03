// https://leetcode.com/problems/spiral-matrix/
// TC: O(m*n)
// SC: O(1) excluding the space required to store the result
// where m*n is the size of the matrix

class SolutionA {
    public List<Integer> spiralOrder(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        
        int dir = 0;
        int i = 0, j = 0;
        boolean isOver = false;
        
        boolean[][] vis = new boolean[m][n];
        List<Integer> result = new ArrayList<>();
        
        while(!isOver) {
            result.add(matrix[i][j]);
            vis[i][j] = true;
            
            i = getNextI(i, dir);
            j = getNextJ(j, dir);
            
            if(isValid(vis, i, j)) {
                continue;
            }
            
            dir = getNextDir(dir);
            if(dir==0) {
                i++;
                j++;
            }
            else if(dir==1) {
                j--;
                i++;
            }
            else if(dir==2) {
                i--;
                j--;
            }
            else {
                j++;
                i--;
            }
            
            if(!isValid(vis, i ,j)) {
                isOver = true;
            }
        }
        
        return result;
    }
    
    private int getNextI(int i, int dir) {
        if(dir==0 || dir==2) {
            return i;
        }
        else if(dir==1) {
            return i+1;
        }
        else {
            return i-1;
        }
    }
    
    private int getNextJ(int j, int dir) {
        if(dir==1 || dir==3) {
            return j;
        }
        else if(dir==0) {
            return j+1;
        }
        else {
            return j-1;
        }
    }
    
    private boolean isValid(boolean[][] vis, int i, int j) {
        int m = vis.length;
        int n = vis[0].length;
        
        return i>=0 && i<m && j>=0 && j<n && !vis[i][j];
    }
    
    private int getNextDir(int dir) {
        return (dir+1)%4;
    }
}