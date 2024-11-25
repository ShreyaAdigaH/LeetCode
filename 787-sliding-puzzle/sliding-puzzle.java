class Solution {
    public int slidingPuzzle(int[][] board) {
           int[][] adjList = {
                {1, 3, -1},
                {0, 2, 4},
                {1, 5, -1},
                {0, 4, -1},
                {1, 3, 5},
                {2, 4, -1}
        };

        StringBuilder boardStr = new StringBuilder(6);
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 3; j++) {
                boardStr.append(board[i][j]);
            }
        }

        String initialState = boardStr.toString();
        int zeroIndex = initialState.indexOf('0');

        Data data = new Data(zeroIndex, initialState, 0);
        Deque<Data> deque = new ArrayDeque<>();
        deque.add(data);
        HashSet<String> visited = new HashSet<>();
        visited.add(initialState);

        while (!deque.isEmpty()) {
            Data currState = deque.pollFirst();
            int currIndex = currState.index;
            String currBoard = currState.board;
            int currPathLength = currState.pathLength;

            if (currBoard.equals("123450")) {
                return currPathLength;
            }

            for (int adj : adjList[currIndex]) {
                if (adj == -1) break;

                char[] newBoard = currBoard.toCharArray();
                char temp = newBoard[currIndex];
                newBoard[currIndex] = newBoard[adj];
                newBoard[adj] = temp;

                String newBoardStr = new String(newBoard);

                if (!visited.contains(newBoardStr)) {
                    deque.add(new Data(adj, newBoardStr, currPathLength + 1));
                    visited.add(newBoardStr);
                }
            }
        }
        return -1; 
    }

     public class Data {
        int index;
        String board;
        int pathLength;

        public Data(int index, String board, int pathLength) {
            this.index = index;
            this.board = board;
            this.pathLength = pathLength;
        }
    }
}