class Solution {
    int rows;
    int cols;

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        rows = heights.length;
        cols = heights[0].length;
        boolean[][] pacific = new boolean[heights.length][heights[0].length];
        boolean[][] atlantic = new boolean[heights.length][heights[0].length];
        List<List<Integer>> res = new ArrayList<>();

        for (int i = 0; i < cols; i++) {
            dfs(0, i, pacific, heights[0][i], heights);
            dfs(rows - 1, i, atlantic, heights[rows - 1][i], heights);
        }

        for (int i = 0; i < rows; i++) {
            dfs(i, 0, pacific, heights[i][0], heights);
            dfs(i, cols - 1, atlantic, heights[i][cols - 1], heights);
        }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (atlantic[i][j] && pacific[i][j]) {
                   res.add(Arrays.asList(i, j));

                }
            }
        }
        return res;
    }

    public void dfs(int row, int col, boolean[][] visited, int height, int[][] heights) {
        if(row >= 0 && row < rows &&
            col >= 0 && col < cols &&
            !visited[row][col] &&
            height <= heights[row][col]) {
                visited[row][col] = true;
                dfs(row + 1, col, visited, heights[row][col], heights);
                dfs(row - 1, col, visited, heights[row][col], heights);
                dfs(row, col + 1, visited, heights[row][col], heights);
                dfs(row, col - 1, visited, heights[row][col], heights);
            }
            
    }
}