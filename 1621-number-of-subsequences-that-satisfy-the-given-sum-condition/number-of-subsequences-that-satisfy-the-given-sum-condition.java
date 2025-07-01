class Solution {
    public int numSubseq(int[] nums, int target) {
        int mod = 1000000007;
        Arrays.sort(nums);

        int left = 0;
        int right = nums.length - 1;
        int totalComb = 0;

        int[] pow = new int[nums.length];
        pow[0] = 1;
        for(int i = 1; i < nums.length; i++) {
            pow[i] = (pow[i - 1] * 2) % mod;
        }
        while(left <= right) {
            int sum = nums[right] + nums[left];
            if(sum <= target) {
                int len = right - left;
                 totalComb = (pow[len] + totalComb) % mod;
                 left++;
            } else {
                right--;
            }
        }
        return totalComb;
    }
}