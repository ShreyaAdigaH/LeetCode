class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
          long max = 0;
        int[] freq = new int[100001];
        int uniqueCount = 0;
        long sum = 0;

        for (int i = 0; i < k; i++) {
            sum += nums[i];
            freq[nums[i]]++;
            if (freq[nums[i]] == 1) {
                uniqueCount++;
            }
        }

        if (uniqueCount == k) {
            max = Math.max(max, sum);
        }

        for (int i = k; i < nums.length; i++) {
            int toRemove = nums[i - k];
            freq[toRemove]--;
            if (freq[toRemove] == 0) {
                uniqueCount--;
            }

            int toAdd = nums[i];
            freq[toAdd]++;
            if (freq[toAdd] == 1) {
                uniqueCount++;
            }

            sum = sum - toRemove + toAdd;

            if (uniqueCount == k) {
                max = Math.max(max, sum);
            }
        }

        return max;
    }
}