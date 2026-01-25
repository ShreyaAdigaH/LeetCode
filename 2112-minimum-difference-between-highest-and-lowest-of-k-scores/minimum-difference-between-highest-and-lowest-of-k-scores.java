class Solution {
    public int minimumDifference(int[] nums, int k) {
        Arrays.sort(nums);
        int ans = Integer.MAX_VALUE;

        // track max and min in each window
        // min - first element, max - last element 

        for(int i = 0; i + k - 1 < nums.length; i++) {
            int min = nums[i];
            int max = nums[i + k - 1];
            int diff = max - min;
            ans = Math.min(diff, ans);
        }

        return ans;
    }
}

// 1, 4, 7, 8
// cant apply the sum logic to difference 