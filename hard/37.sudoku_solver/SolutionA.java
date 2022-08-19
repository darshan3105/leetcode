class SolutionA {
    public void solveSudoku(char[][] board) {
        fill(board);
    }
    
    private boolean fill(char[][] board) {
        for(int i=0;i<board.length;i++) {
            for(int j=0;j<board[0].length;j++) {
                if(board[i][j] == '.') {
                    for(char num='1';num<='9';num++) {
                        if(canPlace(num, i, j, board)) {
                            board[i][j] = num;
                            if(fill(board)) {
                                return true;
                            }
                            board[i][j] = '.';
                        }
                    }
                    return false;
                }
            }            
        }
        return true;
    }
    
    
    private boolean canPlace(char num, int row, int col, char[][] board) {
        for(int j=0;j<board[0].length;j++) {
            if(board[row][j] == num) {
                return false;
            }
        }
        
        for(int i=0;i<board.length;i++) {
            if(board[i][col] == num) {
                return false;
            }
        }
        
        for(int i=3*(row/3);i<3*(row/3)+3;i++) {
            for(int j=3*(col/3);j<3*(col/3)+3;j++) {
                if(board[i][j] == num) {
                    return false;
                }
            }
        }
        return true;
    }
}