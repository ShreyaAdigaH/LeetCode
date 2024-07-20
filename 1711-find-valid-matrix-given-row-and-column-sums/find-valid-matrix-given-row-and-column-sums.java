class Solution {
    public int[][] restoreMatrix(int[] rowSum, int[] colSum) {
 int[][] result = new int[rowSum.length][colSum.length];

        for(int row = 0; row < result.length; row++) {
            result[row][0] = rowSum[row];
        }

        for(int col = 0; col < colSum.length; col++) {
            long init_col_sum = 0;
            for(int row = 0; row < rowSum.length; row++) {
                init_col_sum += result[row][col];
            }

            int row1 = 0;
            while(init_col_sum > colSum[col]) {
                long excess = init_col_sum - colSum[col];
                long max_shift = Math.min(excess, result[row1][col]);
                result[row1][col] -= max_shift;
                result[row1][col + 1] += max_shift;
                init_col_sum -= max_shift;
                row1++;
            }
        }
        return result;
    }
}