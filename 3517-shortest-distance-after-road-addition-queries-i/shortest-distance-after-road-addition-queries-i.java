class Solution {
    public int[] shortestDistanceAfterQueries(int n, int[][] queries) {
         int[] res = new int[queries.length];
        List<List<Integer>> adjacency = new ArrayList<>(n);

        for(int i = 0; i < n; i++) {
            adjacency.add(new ArrayList<>(n));
        }

        for(int i = 0; i < n; i++) {
            adjacency.get(i).add(i + 1); // define adjacency list for each nodes
        }


        // 0 - 1; 1 - 2; 2 - 3; 3 - 4
        // 2 - 4

        for(int query = 0; query < queries.length; query++) {
            int src = queries[query][0];
            int dst = queries[query][1];

            adjacency.get(src).add(dst);

            HashSet<Integer> visitedNode = new HashSet<>();

            Deque<Pair<Integer, Integer>> pathLength = new ArrayDeque<>();

            pathLength.add(new Pair<>(0, 0)); //current node and length of the path traversed

            while(!pathLength.isEmpty()) {
                //go through every neighbours of current node
                Pair<Integer, Integer> currentNode = pathLength.pollFirst();
                int node = currentNode.getKey();
                int length = currentNode.getValue();
                if(node == n - 1) {
                    res[query] = length;
                    break;
                }

                for(int adjacent : adjacency.get(node)) {
                    if (adjacent == 0)
                        break;
                    if(!visitedNode.contains(adjacent)) {
                        visitedNode.add(adjacent);
                        pathLength.add(new Pair<>(adjacent, length + 1));
                    }
                }

            }


        }
        return res;
    }
}