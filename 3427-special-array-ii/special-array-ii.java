class Solution {
    public boolean[] isArraySpecial(int[] nums, int[][] queries) {
             int n = nums.length;

        int[] specialPrefix = new int[n];
        for (int i = 1; i < n; i++) {
            specialPrefix[i] = specialPrefix[i - 1];
            if ((nums[i - 1] % 2) != (nums[i] % 2)) {
                specialPrefix[i]++;
            }
        }

        boolean[] result = new boolean[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int fromi = queries[i][0];
            int toi = queries[i][1];

            int totalPairs = toi - fromi;

            int specialPairs = specialPrefix[toi] - specialPrefix[fromi];

            result[i] = specialPairs == totalPairs;
        }

        return result;
    }
}