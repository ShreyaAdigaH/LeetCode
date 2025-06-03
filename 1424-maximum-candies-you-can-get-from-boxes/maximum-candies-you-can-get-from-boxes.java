class Solution {
    public int maxCandies(
        int[] status,
        int[] candies,
        int[][] keys,
        int[][] containedBoxes,
        int[] initialBoxes
    ) {
        int n = status.length;
        boolean[] hasBox = new boolean[n];
        boolean[] used = new boolean[n];
        Queue<Integer> q = new LinkedList<>();
        int ans = 0;

        // Mark all the boxes we initially possess
        for (int box : initialBoxes) {
            hasBox[box] = true; // ✅ Important!
            if (status[box] == 1) {
                q.offer(box);
                used[box] = true;
                ans += candies[box];
            }
        }

        while (!q.isEmpty()) {
            int currBox = q.poll();

            // Process all keys in this box
            for (int key : keys[currBox]) {
                // Unlock the target box
                status[key] = 1;
                // If we already have the box but couldn't open it earlier
                if (hasBox[key] && !used[key]) {
                    q.offer(key);
                    used[key] = true;
                    ans += candies[key];
                }
            }

            // Process all boxes found inside the current box
            for (int box : containedBoxes[currBox]) {
                hasBox[box] = true;
                // If we now also have the key or it's open, we can process it
                if (status[box] == 1 && !used[box]) {
                    q.offer(box);
                    used[box] = true;
                    ans += candies[box];
                }
            }
        }

        return ans;
    }
}
