class Solution {
    public int minimumTime(int[][] grid) {
         if (grid.length < 2 || grid[0].length < 2 || (grid[0][1] > 1 && grid[1][0] > 1)) {
        return grid.length == 1 && grid[0].length == 1 ? 0 : -1;
    }

    int rows = grid.length;
    int cols = grid[0].length;

    PriorityQueue<int[]> path = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));
    path.add(new int[]{0, 0, 0}); // Initial state: time = 0, row = 0, col = 0
    boolean[][] visited = new boolean[rows][cols];
    int[][] directions = {{0, 1}, {0, -1}, {-1, 0}, {1, 0}}; // Directions: right, left, up, down

    while (!path.isEmpty()) {
        int[] currentState = path.poll();
        int time = currentState[0];
        int row = currentState[1];
        int col = currentState[2];

        for (int[] dir : directions) {
            int newRow = row + dir[0];
            int newCol = col + dir[1];

            if (newRow >= 0 && newCol >= 0 && newRow < rows && newCol < cols && !visited[newRow][newCol]) {
                 int newTime = time + 1;
                if (grid[newRow][newCol] > newTime) {
                    int wait = ((grid[newRow][newCol] - newTime + 1) / 2) * 2;
                    newTime += wait;
                }
                
                if (newRow == rows - 1 && newCol == cols - 1) {
                    return newTime;
                }
                
                visited[newRow][newCol] = true;
                path.offer(new int[]{newTime, newRow, newCol});
            }
        }
    }
    return -1;
    }
}