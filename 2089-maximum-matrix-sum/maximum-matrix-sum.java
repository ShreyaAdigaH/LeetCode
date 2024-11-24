class Solution {
    public long maxMatrixSum(int[][] matrix) {
        long min = Long.MAX_VALUE;
        boolean isNeg = false;
        long sum = 0;
        for(int r = 0; r < matrix.length; r++) {
            for (int c = 0; c < matrix[0].length; c++) {
                if (matrix[r][c] < 0) {
                    isNeg = !isNeg;
                    matrix[r][c] = -1 * (matrix[r][c]);
                }
                sum += matrix[r][c];

                if (matrix[r][c] < min) {
                    min = matrix[r][c];
                }
            }
        }

        if(isNeg) {
            sum = sum - (2 * min);
        }

        return sum;
    }
}