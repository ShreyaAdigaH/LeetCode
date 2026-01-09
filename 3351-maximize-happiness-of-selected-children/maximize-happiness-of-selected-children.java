class Solution {
    public long maximumHappinessSum(int[] happiness, int k) {
        Arrays.sort(happiness);
        int picked = 0;
        long ans = 0;

        for (int i = happiness.length - 1; i >= 0 && picked < k; i--) {
            if (happiness[i] - picked > 0) {
                ans += (happiness[i] - picked);
            }
            picked++;
        }

        return ans;
    }
}