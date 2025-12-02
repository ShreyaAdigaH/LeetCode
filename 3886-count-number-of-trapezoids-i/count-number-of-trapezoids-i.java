class Solution {
    public int countTrapezoids(int[][] points) {
        HashMap<Integer, Integer> ySeg = new HashMap<>();
        final int mod = 1000000007;
        for (int[] point : points) {
            int y = point[1];

            if (ySeg.containsKey(y)) {
                ySeg.put(y, ySeg.get(y) + 1);
            } else {
                ySeg.put(y, 1);
            }

        }

        long ans = 0;
        long prevEdges = 0;
        for (int yCount : ySeg.values()) {
            // calculate total combinations for 
            long totalEdges = ((long)yCount * (yCount - 1)) / 2;
            ans = (ans + (totalEdges * prevEdges)) % mod;
            prevEdges = (prevEdges + totalEdges) % mod;
        }

        return (int) ans;
    }
}