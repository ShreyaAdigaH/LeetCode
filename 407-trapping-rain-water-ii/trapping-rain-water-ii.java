class Solution {
    public int trapRainWater(int[][] heightMap) {
        int rows = heightMap.length;
        int cols = heightMap[0].length;
        PriorityQueue<int[]> cells = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        boolean[][] visited = new boolean[rows][cols];

        for (int i = 0; i < rows; i++) {
            cells.offer(new int[] {heightMap[i][0], i, 0});
            visited[i][0] = true;

            cells.offer(new int[] {heightMap[i][cols - 1], i, cols - 1});
            visited[i][cols - 1] = true;
        }

        for (int i = 0; i < cols; i++) {
            cells.offer(new int[] {heightMap[0][i], 0, i});
            visited[0][i] = true;

            cells.offer(new int[] {heightMap[rows - 1][i], rows - 1, i});
            visited[rows - 1][i] = true;
        }

        int[][] dir = new int[][] {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        int ans = 0;

        while(!cells.isEmpty()) {
            int[] curr = cells.poll();
            int currHeight = curr[0];
            int currRow = curr[1];
            int currCol = curr[2];

            for(int i = 0; i < 4; i++) {
                int nr = currRow + dir[i][0];
                int nc = currCol + dir[i][1];

                if(nr < rows && nr > 0 && nc < cols && nc > 0 && !visited[nr][nc]) {
                    int cellHeight = heightMap[nr][nc];
                    ans += Math.max(0, currHeight - cellHeight);
                    cells.offer(new int[] {Math.max(currHeight, cellHeight), nr, nc});
                    visited[nr][nc] = true;
                }
            }

        }
        return ans;
    }
}