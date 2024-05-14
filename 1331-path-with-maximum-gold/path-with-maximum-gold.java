class Solution {
    int[] rowDir = { 1, -1, 0, 0 }; //
                                    // {right, left, down, up}
    int[] colDir = { 0, 0, -1, 1 }; //

    public int getMaximumGold(int[][] grid) {
        int maxGold = 0;

        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[row].length; col++) {
                maxGold = Math.max(maxGold, dfs(grid, row, col, grid.length, grid[row].length));
            }
        }
        return maxGold;
    }

     private int dfs(int[][] grid, int row, int col, int rowLength, int colLength) {
        if(row < 0 || col < 0 || row >= rowLength || col >= colLength || grid[row][col] == 0) {
            return 0;
        }

        int currentValue = grid[row][col];
        grid[row][col] = 0; //to not visit the cell already visited
        int localMax = currentValue;

        for(int dir = 0; dir < 4; dir++) {
            int rowOffset = row + rowDir[dir];
            int colOffset = col + colDir[dir];
            localMax = Math.max(localMax, currentValue + dfs(grid, rowOffset, colOffset, rowLength, colLength));
        }

        grid[row][col] = currentValue;
        return localMax;
    }
}