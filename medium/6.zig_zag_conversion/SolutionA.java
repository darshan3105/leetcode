// https://leetcode.com/problems/zigzag-conversion/
// TC = O(n)
// SC = O(n*numRows)
// where n = length of the input string

class SolutionA {
    public String convert(String str, int numRows) {
        if(numRows==1) {
            return str;
        }
        
        char[] s = str.toCharArray();
        int len = s.length;
        char[][] grid = new char[numRows][len];
        
        for(int i=0;i<numRows;i++) {
            for(int j=0;j<len;j++) {
                grid[i][j] = '*';
            }
        }
        
        int cur_row = 0;
        int cur_col = 0;
        boolean isGoingUp = false;
        
        for(int i=0;i<len;i++) {
            if(cur_row == numRows) {
                isGoingUp = true;
                cur_row-=2;
                cur_col++;
            }
            else if(cur_row == -1) {
                isGoingUp = false;
                cur_row+=2;
                cur_col--;
            }
            
            grid[cur_row][cur_col] = s[i];
            
            if(!isGoingUp) {
                cur_row++;
            }
            else {
                cur_row--;
                cur_col++;
            }
        }
        
        char[] result = new char[len];
        int ptr = 0;

        for(int i=0;i<numRows;i++) {
            for(int j=0;j<len;j++) {
                if(grid[i][j] != '*') {
                    result[ptr++] = grid[i][j];
                }
            }
        }
        
        return String.valueOf(result);
    }
}