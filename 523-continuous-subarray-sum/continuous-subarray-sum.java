class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        int numsLength = nums.length;
        HashMap<Integer, Integer> remainders = new HashMap<>();
        int prefixSum = 0;

        remainders.put(0, -1); // when subarray starts from index = 0, then prefix sum calculated at a index,
                               // if divisible by given number yields 0.
        // to capture that subarray give index = -1 as value for key(remainder) = 0

        for (int index = 0; index < numsLength; index++) {
            prefixSum += nums[index];
            int remainder = prefixSum % k;

            if (remainders.containsKey(remainder)) { // this means that you have added a number along the way that gets
                                                     // divided by k. Hence you got the same remainder as before
                if (index - remainders.get(remainder) > 1) {
                    return true;
                }
            } else {
                remainders.put(remainder, index);
            }
        }

        return false;
    }
}