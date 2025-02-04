class Solution {
    public int maxAscendingSum(int[] nums) {
         int prev = nums[0];
        int sum = prev;
        int max = sum;
        for(int i = 1; i < nums.length; i++) {
            if(nums[i] > prev) {
                sum += nums[i];
              
            } else {
                sum = nums[i];
            }
            max = Math.max(sum, max);
            prev = nums[i];
        }
        return max;
    }
}