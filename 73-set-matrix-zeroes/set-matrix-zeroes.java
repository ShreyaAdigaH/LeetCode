class Solution {
    public void setZeroes(int[][] matrix) {
   boolean isFirstRowZero = false;
        boolean isFirstColZero = false;
        for(int row = 0; row < matrix.length; row++) {
            for(int col = 0; col < matrix[row].length; col++) {
                if(matrix[row][col] == 0) {
                    matrix[0][col] = 0;
                    matrix[row][0] = 0;

                    if(row == 0) {
                        isFirstRowZero = true;
                    }
                    if(col == 0) {
                        isFirstColZero = true;
                    }
                }
            }
        }
        
        for (int row = 1; row < matrix.length; row++) {
            for(int col = 1; col < matrix[0].length; col++) {
                if(matrix[row][0] == 0 || matrix[0][col] == 0)
                    matrix[row][col] = 0;
            }
        }

        if(isFirstRowZero) {
            Arrays.fill(matrix[0], 0);
        }
        if(isFirstColZero) {
            for(int row = 0; row < matrix.length; row++) {
                matrix[row][0] = 0;
            }
        }

    }
}