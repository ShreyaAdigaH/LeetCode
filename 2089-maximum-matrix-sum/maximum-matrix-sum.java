class Solution {
    public long maxMatrixSum(int[][] matrix) {
        long min = Long.MAX_VALUE;
        boolean isNeg = false;
        long sum = 0;
        for(int r = 0; r < matrix.length; r++) {
            for (int c = 0; c < matrix[0].length; c++) {
                int value = matrix[r][c];
                if (value < 0) {
                    isNeg = !isNeg;
                    value = -1 * (value);
                }
                sum += value;

                if (value < min) {
                    min = value;
                }
            }
        }

        if(isNeg) {
            sum = sum - (2 * min);
        }

        return sum;
    }
}