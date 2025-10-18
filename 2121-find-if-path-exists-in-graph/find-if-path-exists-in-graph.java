class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        // using dfs

        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for(int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }

        boolean[] visited = new boolean[n];
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(source);

        while(!queue.isEmpty()) {
            int curr = queue.poll();

            if(curr == destination) {
                return true;
            }

            for(int neigh : graph.get(curr)) {
                if(!visited[neigh]) {
               
                    queue.offer(neigh);
                         visited[neigh] = true;
                }
            }
        }

        return false;

    }
}