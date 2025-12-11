class Solution {
    public int countCoveredBuildings(int n, int[][] buildings) {
        int[] minRow = new int[n + 1];
        int[] maxRow = new int[n + 1];
        int[] minCol = new int[n + 1];
        int[] maxCol = new int[n + 1];

        Arrays.fill(minRow, n + 1);
        Arrays.fill(minCol, n + 1);

        for(int[] building : buildings) {
            int row = building[0];
            int col = building[1];


            maxRow[col] = Math.max(row, maxRow[col]);
            maxCol[row] = Math.max(col, maxCol[row]);
            minCol[row] = Math.min(col, minCol[row]);
            minRow[col] = Math.min(row, minRow[col]);

        }


        int res = 0;
        for(int[] building : buildings) {
            int row = building[0];
            int col = building[1];

            if(maxRow[col] > row && minRow[col] < row && minCol[row] < col && maxCol[row] > col) {
                res++;
            }
        }
        return res;
    }
}