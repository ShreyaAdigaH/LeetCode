class Solution {
    public int findMaxK(int[] nums) {
        Arrays.sort(nums);
        int rp = nums.length - 1;
        int lp = 0;

        while (lp < rp) {
            int sum = nums[lp] + nums[rp];
            if (sum == 0) {
                return nums[rp];
            } else if (sum < 0) {
                lp++;
            } else {
                rp--;
            }
        }
        return -1;
    }
}