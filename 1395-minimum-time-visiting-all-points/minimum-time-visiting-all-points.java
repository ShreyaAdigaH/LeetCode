class Solution {
    public int minTimeToVisitAllPoints(int[][] points) {
        int currX = points[0][0];
        int currY = points[0][1];
        int steps = 0;
        for(int[] point : points) {
            int x = point[0];
            int y = point[1];

            steps += Math.max(Math.abs(x - currX), Math.abs(y - currY));
            currX = x;
            currY = y;
        }

        return steps;
    }
}