class Solution {
    public int maxAdjacentDistance(int[] nums) {
        int maxDiff = 0;
        for (int i = 0; i < nums.length; i++) {
            int diff = 0;
            if (i == nums.length - 1) {
                diff = nums[i] - nums[0];
            } else {
                diff = nums[i] - nums[i + 1];
            }

            if(diff < 0) {
                diff = -1 * diff;
            }

            maxDiff = Math.max(diff, maxDiff);
        }
        return maxDiff;
    }
}