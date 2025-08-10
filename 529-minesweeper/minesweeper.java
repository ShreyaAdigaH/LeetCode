class Solution {
    public char[][] updateBoard(char[][] board, int[] click) {
        int x = click[0];
        int y = click[1];

        if (board[x][y] == 'M') {
            board[x][y] = 'X';
            return board;
        }

        reveal(board, x, y);
        return board;
    }

    private void reveal(char[][] board, int x, int y) {
        // If already revealed, skip
        if (board[x][y] != 'E') return;

        // Count adjacent mines
        int minesCount = 0;
        List<int[]> neighbours = getNeighbours(x, y, board);
        for (int[] n : neighbours) {
            if (board[n[0]][n[1]] == 'M') minesCount++;
        }

        if (minesCount > 0) {
            board[x][y] = (char) ('0' + minesCount);
        } else {
            board[x][y] = 'B'; 
            for (int[] n : neighbours) {
                reveal(board, n[0], n[1]);
            }
        }
    }

    private List<int[]> getNeighbours(int x, int y, char[][] board) {
        int[][] directions = {
            { 0, 1 }, { 1, 0 }, { -1, 0 }, { 0, -1 },
            { 1, 1 }, { -1, 1 }, { 1, -1 }, { -1, -1 }
        };
        List<int[]> neighbours = new ArrayList<>();
        for (int[] dir : directions) {
            int newX = x + dir[0];
            int newY = y + dir[1];
            if (newX >= 0 && newX < board.length &&
                newY >= 0 && newY < board[0].length) {
                neighbours.add(new int[] { newX, newY });
            }
        }
        return neighbours;
    }
}
