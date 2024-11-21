class Solution {
    public int countUnguarded(int m, int n, int[][] guards, int[][] walls) {
           int[][] grid = new int[m][n];

       for(int i = 0; i < guards.length; i++) {
           grid[guards[i][0]][guards[i][1]] = 1;
       }

       for(int i = 0; i < walls.length; i++) {
           grid[walls[i][0]][walls[i][1]] = 2;
       }

       for(int guard = 0; guard < guards.length; guard++) {
           int r = guards[guard][0];
           int c = guards[guard][1];
                for(int row = r + 1; row < m; row++) {
                    if(grid[row][c] == 1 || grid[row][c] == 2){
                        break;
                    }
                    grid[row][c] = 3;
                }
           for(int row = r - 1; row >= 0; row--) {
               if(grid[row][c] == 1 || grid[row][c] == 2){
                   break;
               }
               grid[row][c] = 3;
           }
           for(int col = c + 1;  col < n; col++) {
               if(grid[r][col] == 1 || grid[r][col] == 2){
                   break;
               }
               grid[r][col] = 3;
           }
           for(int col = c - 1;  col >= 0; col--) {
               if(grid[r][col] == 1 || grid[r][col] == 2){
                   break;
               }
               grid[r][col] = 3;
           }
       }

       int res = 0;
       for(int r = 0; r < grid.length; r++) {
           for(int c = 0; c < grid[0].length; c++) {
               if(grid[r][c] == 0) {
                   res++;
               }
           }
       }
       return res;
    }
}