class Solution {
    public void solveSudoku(char[][] board) {
        boolean res = sudokuSolver(0, 0, board);
    }

    /*** solve sudoku by backtracking ******/
    public boolean sudokuSolver(int row, int col, char[][] board) {
       if(col == 9) {
        row = row + 1;
        col = 0;
        if(row == 9) {
            return true;
        }
       }

       if(board[row][col] == '.') {
        return tryEachNumbers(row, col, board);
       }

       return sudokuSolver(row, col + 1, board);
    }

    /******* try each number starting from 1 *******/
    public boolean tryEachNumbers(int row, int col, char[][] board) {
        for(char i = '1'; i <= '9'; i++) {
            if(isValid(row, col, i, board)) {
                board[row][col] = i;
                if(sudokuSolver(row, col + 1, board)) {
                    return true;
                }
            }
        }
        board[row][col] = '.';
        return false;
    }
    /********* check if added number is valid *******/
    public boolean isValid(int row, int col, char value, char[][] board) {
        // check if it is valid col wise
        for(int i = 0; i < 9; i++) {
            if(board[i][col] == value) {
                return false;
            } 
        }

        for(int i = 0; i < 9; i++) {
            if(board[row][i] == value) {
                return false;
            } 
        }

        // 9 groups
        // when you divide by 3 --> which bucket it falls into
        int rowStart = (row / 3) * 3;
        int colStart = (col / 3) * 3;

        for(int i = rowStart; i < rowStart + 3; i++) {
            for(int j = colStart; j < colStart + 3; j++) {
                if(board[i][j] == value) {
                    return false;
                }
            }
        }

        return true;
    }
}