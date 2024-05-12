class Solution {
    public int[][] largestLocal(int[][] grid) {
        int length = grid.length;
        int resultRow = 0;
        int resultCol = 0;
        int[][] result = new int[length - 2][length - 2];
        int maxInWindow = 0;
        for (int windowRow = 0; windowRow + 2 < grid.length; windowRow++) {
            for (int windowCol = 0; windowCol + 2 < grid.length; windowCol++) {
                for (int row = windowRow; row <= windowRow + 2; row++) {
                    for (int col = windowCol; col <= windowCol + 2; col++) {
                        maxInWindow = Math.max(maxInWindow, grid[row][col]);
                    }
                }
                result[resultRow][resultCol] = maxInWindow;
                maxInWindow = 0;
                resultCol++;
            }
            resultRow++;
            resultCol = 0;
        }

        return result;
    }
}