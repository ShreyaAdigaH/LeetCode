class Solution {
    public int maxDistinctElements(int[] nums, int k) {
        // range - [min(nums) - k, max(nums) + k]
        Arrays.sort(nums);
        int prev = Integer.MIN_VALUE;
        int curr = 0;
        int cnt = 0;
        for(int num : nums) {
             curr = Math.min(Math.max(num - k, prev + 1), num + k);
            if(curr > prev) {
                prev = curr;
                cnt++;
            }
        }
        return cnt;
    }
}