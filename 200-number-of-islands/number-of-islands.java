class Solution {
    boolean[][] visited;
    int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    int rows;
    int cols;
    char[][] area;

    public int numIslands(char[][] grid) {
          area = grid;
        visited = new boolean[grid.length][grid[0].length];
        if(grid.length == 0)
            return 0;

         rows = grid.length;
         cols = grid[0].length;
        int island = 0;
        for(int row = 0; row < rows; row++) {
            for(int col = 0; col < cols; col++) {
                if(grid[row][col] == '1' && !visited[row][col]) {
                    bfs(row, col);
                    island += 1;
                }
            }
        }
        return island;
    }

    public  void bfs(int row, int col) {
        Deque<int[]> adjacentCell = new LinkedList<>();
        visited[row][col] = true;
        adjacentCell.add(new int[]{row, col});

        while(!adjacentCell.isEmpty()) {
            int[] cell = adjacentCell.removeLast();
            int bfsRow = cell[0];
            int bfsCol = cell[1];

            for(int[] dir : directions) {
                row = bfsRow + dir[0];
                col = bfsCol + dir[1];

                if(row >= 0 && row < rows && col >= 0 && col < cols && area[row][col] == '1' && !visited[row][col]) {
                    visited[row][col] = true;
                    adjacentCell.add(new int[]{row, col});
                }
            }
        }
    }
}