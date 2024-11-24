class Solution {
    public long maxMatrixSum(int[][] matrix) {
        long min = Long.MAX_VALUE;
        int negCount = 0;
        long sum = 0;
        for (int r = 0; r < matrix.length; r++) {
            for (int c = 0; c < matrix[0].length; c++) {
                if (matrix[r][c] < 0) {
                    negCount++;
                }
                sum += Math.abs(matrix[r][c]);

                min = Math.min(min, Math.abs(matrix[r][c]));
            }
        }

        if (min != 0 && negCount % 2 != 0) {
            sum = sum - (2 * min);
        }

        return sum;
    }
}