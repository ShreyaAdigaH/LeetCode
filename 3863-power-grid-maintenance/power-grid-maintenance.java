class Solution {
    public int[] processQueries(int c, int[][] connections, int[][] queries) {
        List<Integer>[] graph = new ArrayList[c + 1];
        for (int i = 1; i <= c; i++) graph[i] = new ArrayList<>();
        for (int[] e : connections) {
            graph[e[0]].add(e[1]);
            graph[e[1]].add(e[0]);
        }

        int[] compId = new int[c + 1];
        Arrays.fill(compId, -1);
        int compCount = 0;

        for (int i = 1; i <= c; i++) {
            if (compId[i] == -1) {
                dfs(i, compCount++, graph, compId);
            }
        }

        PriorityQueue<Integer>[] heaps = new PriorityQueue[compCount];
        for (int i = 0; i < compCount; i++) heaps[i] = new PriorityQueue<>();

        boolean[] online = new boolean[c + 1];
        Arrays.fill(online, true);

        for (int i = 1; i <= c; i++) {
            heaps[compId[i]].offer(i);
        }

        List<Integer> res = new ArrayList<>();

        for (int[] q : queries) {
            int type = q[0], x = q[1];

            if (type == 1) { 
                int cid = compId[x];
                if (online[x]) {
                    res.add(x);
                } else {
                    int smallest = -1;
                    while (!heaps[cid].isEmpty()) {
                        int top = heaps[cid].peek();
                        if (online[top]) {
                            smallest = top;
                            break;
                        } else {
                            heaps[cid].poll(); 
                        }
                    }
                    res.add(smallest == -1 ? -1 : smallest);
                }

            } else { 
                online[x] = false;
            }
        }

        int[] ans = new int[res.size()];
        for (int i = 0; i < res.size(); i++) ans[i] = res.get(i);
        return ans;
    }

    private void dfs(int node, int id, List<Integer>[] graph, int[] compId) {
        Stack<Integer> stack = new Stack<>();
        stack.push(node);
        compId[node] = id;

        while (!stack.isEmpty()) {
            int u = stack.pop();
            for (int v : graph[u]) {
                if (compId[v] == -1) {
                    compId[v] = id;
                    stack.push(v);
                }
            }
        }
    }
}
