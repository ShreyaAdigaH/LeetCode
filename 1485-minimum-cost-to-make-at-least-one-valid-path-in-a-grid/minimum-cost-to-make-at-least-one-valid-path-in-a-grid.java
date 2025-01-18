class Solution {
    public int minCost(int[][] grid) {
          int[][] dir = {
                {0, 1},
                {0, -1},
                {1, 0},
                {-1, 0}
        };
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        Deque<int[]> nodes = new ArrayDeque<>();
        nodes.offerFirst(new int[] {0, 0});
        int[][] cost = new int[grid.length][grid[0].length];

        for(int row = 0; row < grid.length; row++) {
            for(int col = 0; col < grid[row].length; col++) {
                cost[row][col] = Integer.MAX_VALUE;
            }
        }

        cost[0][0] = 0;

        while(!nodes.isEmpty()) {
            int[] curr = nodes.pollFirst();
            int currX = curr[0];
            int currY = curr[1];

            for(int i = 0; i < 4; i++) {
                int newX = currX + dir[i][0];
                int newY = currY + dir[i][1];

                if(newX >= 0 && newX < grid.length && newY >= 0 && newY < grid[0].length) {
                    int newCost = cost[currX][currY] + (grid[currX][currY] == i + 1 ? 0 : 1);

                    if(newCost < cost[newX][newY]) {
                        cost[newX][newY] = newCost;

                        if (grid[currX][currY] == i + 1) {
                            nodes.offerFirst(new int[]{newX, newY});
                        } else {
                            nodes.offerLast(new int[]{newX, newY});
                        }
                    }
                }
            }
        }
        return cost[grid.length - 1][grid[0].length - 1];
    }
}