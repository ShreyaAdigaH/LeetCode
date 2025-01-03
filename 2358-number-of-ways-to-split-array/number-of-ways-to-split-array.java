class Solution {
    public int waysToSplitArray(int[] nums) {
        long[] prefixSum = new long[nums.length + 1];

        for (int i = 0; i < nums.length; i++) {
            prefixSum[i + 1] = prefixSum[i] + nums[i];
        }

        int splits = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            if (prefixSum[i + 1] >= prefixSum[nums.length] - prefixSum[i + 1]) {
                splits++;
            }
        }
        return splits;
    }
}