class Solution {
    public int swimInWater(int[][] grid) {
        PriorityQueue<int[]> pathCells = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        pathCells.offer(new int[] {grid[0][0], 0, 0});
        int[][] directions = new int[][] {{1, 0}, {0 , 1}, {-1, 0}, {0, -1}};

        while(!pathCells.isEmpty()) {
            int[] currCell = pathCells.poll();
            int currElevation = currCell[0];
            int currRow = currCell[1];
            int currCol = currCell[2];

            if(currRow == grid.length - 1 && currCol == grid.length - 1) {
                return currElevation;
            }

            for(int[] dir : directions) {
                int newRow = currRow + dir[0];
                int newCol = currCol + dir[1];

                if(newRow < 0 || newCol < 0 ||
                   newRow >= grid.length || newCol >= grid.length || visited[newRow][newCol]) {
                    continue;
                   }

                int newHeight = Math.max(currElevation, grid[newRow][newCol]);
                pathCells.offer(new int[] {newHeight, newRow, newCol});
                visited[newRow][newCol] = true;
            }
        }
        return 0;
    }
}