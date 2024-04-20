class Solution {
    int[] memo;

    public int rob(int[] nums) {
        memo = new int[nums.length + 1];
        Arrays.fill(memo, -1);
        return rob(nums, 0);
    }

    private int rob(int[] nums, int i) {
        if (i > nums.length - 1) {
            return 0;
        }
        if (memo[i] >= 0) {
            return memo[i];
        }

        int result = Math.max(rob(nums, i + 2) + nums[i], rob(nums, i + 1));
        memo[i] = result;
        return result;
    }
}