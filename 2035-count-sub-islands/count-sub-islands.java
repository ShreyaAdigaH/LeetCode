class Solution {
    boolean[][] visited;
    int rows;
    int cols;
    int[][] grid2A;
    int[][] grid1A;

    public int countSubIslands(int[][] grid1, int[][] grid2) {
        grid1A = grid1;
        grid2A = grid2;
        int count = 0;
        rows = grid1.length;
        cols = grid1[0].length;
        visited = new boolean[rows][cols];

        for (int g2Row = 0; g2Row < rows; g2Row++) {
            for (int g2Col = 0; g2Col < cols; g2Col++) {
                if (grid2[g2Row][g2Col] == 1 && !visited[g2Row][g2Col] && dfs(g2Row, g2Col)) {
                    count += 1;
                }
            }
        }
        return count;
    }

    public boolean dfs(int row, int col) {

        if (row < 0 || col < 0 || row == rows || col == cols || grid2A[row][col] == 0 || visited[row][col]) {
            return true;
        }
        visited[row][col] = true;
        boolean isSub = true;
        if (grid1A[row][col] == 0) { // grid1[row][col] = 0 and grid2[row][col] = 1
            isSub = false;
        }

        // run dfs if it is a part of subIsland

        isSub = dfs(row - 1, col) && isSub;
        isSub = dfs(row + 1, col) && isSub;
        isSub = dfs(row, col + 1) && isSub;
        isSub = dfs(row, col - 1) && isSub;

        return isSub;
    }
}